package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.Bind;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.IssueResponseModel;

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

    public static Intent newIntent(Context context, IssueResponseModel issueResponseModel) {
        Intent intent = new Intent(context, IssueCandidateMatchActivity.class);
        intent.putExtra(ARGS_ISSUE_ID, issueResponseModel.id);
        intent.putExtra(ARGS_ISSUE, issueResponseModel.issue);
        intent.putExtra(ARGS_ISSUE_RATING, 0);
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

    private String mIssueId;
    private String mIssue;
    private int mIssueRating;

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

        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(RESULT_ISSUE_ID, mIssueId);
                intent.putExtra(RESULT_RATING, mRatingBar.getNumStars());
                intent.putExtra(RESULT_CANDIDATE_ID, "1");
                setResult(RESULT_OK, intent);
                finish();
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
