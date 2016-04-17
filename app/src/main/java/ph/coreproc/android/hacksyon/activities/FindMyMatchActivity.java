package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.adapters.IssueRecyclerViewAdapter;
import ph.coreproc.android.hacksyon.data.Issues;
import ph.coreproc.android.hacksyon.data.presidentiables.PresidentiableEnum;
import ph.coreproc.android.hacksyon.models.Candidate;
import ph.coreproc.android.hacksyon.models.IssueResponseModel;
import ph.coreproc.android.hacksyon.models.MyMatchModel;
import ph.coreproc.android.hacksyon.rest.RestClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by johneris on 4/16/16.
 */
public class FindMyMatchActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, FindMyMatchActivity.class);
        return intent;
    }

    private final int REQUEST_CODE_ISSUE_CANDIDATE = 1;
    private final int REQUEST_CODE_CHOOSE_CANDIDATE_TO_VOTE = 2;

    @Bind(R.id.matchCandidateBackgroundImageView)
    CircleImageView mMatchCandidateBackgroundImageView;

    @Bind(R.id.matchCandidateImageView)
    CircleImageView mMatchCandidateImageView;

    @Bind(R.id.matchScoreTextView)
    TextView mMatchScoreTextView;

    @Bind(R.id.voteBackgroundImageView)
    CircleImageView mVoteBackgroundImageView;

    @Bind(R.id.voteImageView)
    CircleImageView mVoteImageView;

    @Bind(R.id.changeVoteButton)
    Button mChangeVoteButton;

    @Bind(R.id.issuesRecyclerView)
    RecyclerView mIssuesRecyclerView;

    @Bind(R.id.myMatchContainer)
    LinearLayout mMyMatchContainer;

    @Bind(R.id.myVoteContainer)
    LinearLayout mMyVoteContainer;

    IssueRecyclerViewAdapter mIssueRecyclerViewAdapter;

    private MyMatchModel mMyMatchModel;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_find_my_match;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMyMatchModel = new MyMatchModel();
        initUI();
    }


    private void initUI() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mIssuesRecyclerView.setLayoutManager(linearLayoutManager);

        mIssuesRecyclerView.setNestedScrollingEnabled(false);
        mIssuesRecyclerView.setHasFixedSize(false);

        List<IssueResponseModel> issueResponseModels = new ArrayList<>();

        mIssueRecyclerViewAdapter = new IssueRecyclerViewAdapter(mContext, issueResponseModels) {
            @Override
            public void onIssueClicked(IssueResponseModel issueResponseModel) {
                Intent intent = IssueCandidateMatchActivity.newIntent(mContext, issueResponseModel);
                startActivityForResult(intent, REQUEST_CODE_ISSUE_CANDIDATE);
            }
        };
        mIssuesRecyclerView.setAdapter(mIssueRecyclerViewAdapter);

        mChangeVoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ChoosePresidentActivity.newIntent(mContext);
                startActivityForResult(intent, REQUEST_CODE_CHOOSE_CANDIDATE_TO_VOTE);
            }
        });

        getData();
    }

    private void getData() {
        RestClient.switchToLiveMode();
        RestClient.getAPIService().getIssues(RestClient.KEY, RestClient.TOKEN, new Callback<List<IssueResponseModel>>() {
            @Override
            public void success(List<IssueResponseModel> issueResponseModels, Response response) {
                List<String> issuesWithCompleteCandidateStand = Issues.getIssuesWithCompleteCandidateStand();
                List<IssueResponseModel> issueResponseModelsFiltered = new ArrayList<>();
                for (IssueResponseModel issueResponseModel : issueResponseModels) {
                    if (issuesWithCompleteCandidateStand.contains(issueResponseModel.id)) {
                        issueResponseModelsFiltered.add(issueResponseModel);
                    }
                }
                mIssueRecyclerViewAdapter.changeData(issueResponseModelsFiltered);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void updateData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ISSUE_CANDIDATE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String issueId = bundle.getString(IssueCandidateMatchActivity.RESULT_ISSUE_ID);
            int rating = bundle.getInt(IssueCandidateMatchActivity.RESULT_RATING, 0);
            String candidateId = bundle.getString(IssueCandidateMatchActivity.RESULT_CANDIDATE_ID);
        } else if (requestCode == REQUEST_CODE_CHOOSE_CANDIDATE_TO_VOTE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            int candidateId = bundle.getInt(ChoosePresidentActivity.RESULT_CANDIDATE_ID);
            Candidate candidate =  null;
            for (PresidentiableEnum p : PresidentiableEnum.values()) {
                if (p.getObject().getId() == candidateId) {
                    candidate = p.getObject();
                    break;
                }
            }
            if (candidate != null) {
                mMyVoteContainer.setBackgroundColor(ContextCompat.getColor(mContext, candidate.getColor()));
                mVoteBackgroundImageView.setImageResource(candidate.getColor());
                mVoteImageView.setImageResource(candidate.getImage());
                // set object candidate to vote
            }
        }
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
