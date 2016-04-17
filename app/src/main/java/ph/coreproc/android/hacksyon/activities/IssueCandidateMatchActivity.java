package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.adapters.CandidateStandRecyclerViewAdapter;
import ph.coreproc.android.hacksyon.models.IssueResponseModel;
import ph.coreproc.android.hacksyon.models.StandOnIssueResponseModel;
import ph.coreproc.android.hacksyon.rest.RestClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by johneris on 4/16/16.
 */
public class IssueCandidateMatchActivity extends BaseActivity {

    private static String ARGS_ISSUE_ID = "ARGS_ISSUE_ID";
    private static String ARGS_ISSUE = "ARGS_ISSUE";
    private static String ARGS_ISSUE_RATING = "ARGS_ISSUE_RATING";

    public static String RESULT_ISSUE_ID = "RESULT_ISSUE_ID";
    public static String RESULT_RATING = "RESULT_RATING";
    public static String RESULT_CANDIDATE_ID = "RESULT_CANDIDATE_ID";
    public static String RESULT_QUOTE= "RESULT_QUOTE";

    public static Intent newIntent(Context context, IssueResponseModel issueResponseModel) {
        Intent intent = new Intent(context, IssueCandidateMatchActivity.class);
        intent.putExtra(ARGS_ISSUE_ID, issueResponseModel.id);
        intent.putExtra(ARGS_ISSUE, issueResponseModel.issue);
        intent.putExtra(ARGS_ISSUE_RATING, issueResponseModel.rating);
        return intent;
    }

    @Bind(R.id.issueTextView)
    TextView mIssueTextView;

    @Bind(R.id.ratingBar)
    RatingBar mRatingBar;

    @Bind(R.id.candidateQuoteRecyclerView)
    RecyclerView mCandidateQuoteRecyclerView;

    @Bind(R.id.doneButton)
    Button mDoneButton;

    private CandidateStandRecyclerViewAdapter mCandidateStandRecyclerViewAdapter;

    private String mIssueId;
    private String mIssue;
    private int mIssueRating;

    private StandOnIssueResponseModel mStandOnIssueResponseModel;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_issue_candidate_match;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        mIssueId = bundle.getString(ARGS_ISSUE_ID);
        mIssue = bundle.getString(ARGS_ISSUE);
        mIssueRating = bundle.getInt(ARGS_ISSUE_RATING);

        initUI();
    }

    private void initUI() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mIssueTextView.setText(mIssue);
        mRatingBar.setRating(mIssueRating);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mCandidateQuoteRecyclerView.setLayoutManager(linearLayoutManager);

        mCandidateQuoteRecyclerView.setNestedScrollingEnabled(false);
        mCandidateQuoteRecyclerView.setHasFixedSize(false);

        List<StandOnIssueResponseModel> standOnIssueResponseModels = new ArrayList<>();

        mCandidateStandRecyclerViewAdapter = new CandidateStandRecyclerViewAdapter(mContext, standOnIssueResponseModels) {
            @Override
            public void onStandOnIssueClicked(StandOnIssueResponseModel standOnIssueResponseModel) {
                mStandOnIssueResponseModel = standOnIssueResponseModel;
            }
        };
        mCandidateQuoteRecyclerView.setAdapter(mCandidateStandRecyclerViewAdapter);


        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String errorMessage = "";
                if (mStandOnIssueResponseModel == null) {
                    errorMessage = "Please select the statement which best matches your view.";
                }
                if (Math.round(mRatingBar.getRating()) <= 0) {
                    errorMessage = errorMessage.isEmpty() ? "Please rate the importance of the issue for you." :
                            errorMessage + "Please rate the importance of the issue for you.";
                }
                if (!errorMessage.isEmpty()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                            .setTitle("Invalid Input")
                            .setMessage(errorMessage)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create();
                    alertDialog.show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(RESULT_ISSUE_ID, mIssueId);
                intent.putExtra(RESULT_RATING, Math.round(mRatingBar.getRating()));
                intent.putExtra(RESULT_CANDIDATE_ID, mStandOnIssueResponseModel.candidateId);
                intent.putExtra(RESULT_QUOTE, mStandOnIssueResponseModel.quote);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        loadStandOnIssue();
    }

    private void loadStandOnIssue() {
        RestClient.switchToLocalMode();
        RestClient.getAPIService().getCandidateStandOnIssue(Integer.parseInt(mIssueId), new Callback<List<StandOnIssueResponseModel>>() {
            @Override
            public void success(List<StandOnIssueResponseModel> standOnIssueResponseModels, Response response) {
                Collections.shuffle(standOnIssueResponseModels);
                mCandidateStandRecyclerViewAdapter.changeData(standOnIssueResponseModels);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }

}
