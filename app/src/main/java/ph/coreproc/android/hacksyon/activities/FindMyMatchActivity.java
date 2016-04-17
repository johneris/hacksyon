package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import ph.coreproc.android.hacksyon.utils.Preferences;
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

        mMyMatchModel = Preferences.getMyMatchModel(mContext);
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

                loadData();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void loadData() {
        if (mMyMatchModel == null) {
            return;
        }

        String candidateIdMatch = mMyMatchModel.candidateIdMatch;
        String candidateIdVote = mMyMatchModel.candidateIdVote;
        Candidate candidateMatch = null;
        Candidate candidateVote = null;
        for (PresidentiableEnum p : PresidentiableEnum.values()) {
            if ((p.getObject().getId() + "").equals(candidateIdMatch)) {
                candidateMatch = p.getObject();
            }
            if ((p.getObject().getId() + "").equals(candidateIdVote)) {
                candidateVote = p.getObject();
            }
        }
        if (candidateMatch != null) {
            mMyMatchContainer.setBackgroundColor(ContextCompat.getColor(mContext, candidateMatch.getColor()));
            mMatchCandidateBackgroundImageView.setImageResource(candidateMatch.getColor());
            mMatchCandidateImageView.setImageResource(candidateMatch.getImage());
            mMatchScoreTextView.setText("" + mMyMatchModel.matchScore);
        }
        if (candidateVote != null) {
            mMyVoteContainer.setBackgroundColor(ContextCompat.getColor(mContext, candidateVote.getColor()));
            mVoteBackgroundImageView.setImageResource(candidateVote.getColor());
            mVoteImageView.setImageResource(candidateVote.getImage());
        }

        List<IssueResponseModel> issueResponseModels = mIssueRecyclerViewAdapter.getIssueResponseModels();
        for (IssueResponseModel issueResponseModel : issueResponseModels) {
            MyMatchModel.IssueResult issueResult = getIssueResult(issueResponseModel.id);
            if (issueResult != null) {
                issueResponseModel.quote = issueResult.quote;
                issueResponseModel.candidate = getPresidentialCandidateById(Integer.parseInt(issueResult.candidateId));
                issueResponseModel.rating = issueResult.rating;
            }
        }
        mIssueRecyclerViewAdapter.changeData(issueResponseModels);
    }

    private void updateAndSaveData() {
        Map<Integer, Integer> mapCandidateScore = new HashMap<>();
        List<IssueResponseModel> issueResponseModels = mIssueRecyclerViewAdapter.getIssueResponseModels();
        List<MyMatchModel.IssueResult> issueResults = new ArrayList<>();
        for (IssueResponseModel issueResponseModel : issueResponseModels) {
            MyMatchModel.IssueResult issueResult = new MyMatchModel.IssueResult();
            issueResult.id = issueResponseModel.id;
            issueResult.candidateId = issueResponseModel.candidate == null ? "-1" : issueResponseModel.candidate.getId() + "";
            issueResult.quote = issueResponseModel.quote;
            issueResult.rating = issueResponseModel.rating;
            issueResults.add(issueResult);

            if (issueResponseModel.candidate == null) {
                continue;
            }

            if (mapCandidateScore.containsKey(issueResponseModel.candidate.getId())) {
                int score = mapCandidateScore.get(issueResponseModel.candidate.getId());
                mapCandidateScore.put(issueResponseModel.candidate.getId(), score + issueResult.rating);
            } else {
                mapCandidateScore.put(issueResponseModel.candidate.getId(), issueResult.rating);
            }
        }

        int candidateIdMatch = -1;
        int candidateScore = 0;
        for (Map.Entry<Integer, Integer> entry : mapCandidateScore.entrySet()) {
            if (candidateIdMatch == -1) {
                candidateIdMatch = entry.getKey();
                candidateScore = entry.getValue();
                continue;
            }
            if (entry.getValue() > candidateScore) {
                candidateIdMatch = entry.getKey();
                candidateScore = entry.getValue();
            }
        }

        if (mMyMatchModel == null) {
            mMyMatchModel = new MyMatchModel();
        }

        mMyMatchModel.candidateIdMatch = candidateIdMatch + "";
        mMyMatchModel.matchScore = candidateScore;
        mMyMatchModel.issueResults = issueResults;

        Preferences.setMyMatch(mContext, mMyMatchModel);

        loadData();
    }

    private Candidate getPresidentialCandidateById(int id) {
        for (PresidentiableEnum p : PresidentiableEnum.values()) {
            if (p.getObject().getId() == id) {
                return p.getObject();
            }
        }
        return null;
    }

    private MyMatchModel.IssueResult getIssueResult(String issueId) {
        if (mMyMatchModel == null) {
            return null;
        }
        for (MyMatchModel.IssueResult issueResult : mMyMatchModel.issueResults) {
            if (issueId.contentEquals(issueResult.id)) {
                return issueResult;
            }
        }
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ISSUE_CANDIDATE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String issueId = bundle.getString(IssueCandidateMatchActivity.RESULT_ISSUE_ID);
            int rating = bundle.getInt(IssueCandidateMatchActivity.RESULT_RATING);
            String candidateId = bundle.getString(IssueCandidateMatchActivity.RESULT_CANDIDATE_ID);
            String quote = bundle.getString(IssueCandidateMatchActivity.RESULT_QUOTE);
            updateIssuesRecyclerView(issueId, rating, candidateId, quote);
        } else if (requestCode == REQUEST_CODE_CHOOSE_CANDIDATE_TO_VOTE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            int candidateId = bundle.getInt(ChoosePresidentActivity.RESULT_CANDIDATE_ID);
            Candidate candidate = null;
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
                mMyMatchModel.candidateIdVote = candidate.getId() + "";
                Preferences.setMyMatch(mContext, mMyMatchModel);
            }
        }
    }

    private void updateIssuesRecyclerView(String issueId, int rating, String candidateId, String quote) {
        List<IssueResponseModel> issueResponseModels = mIssueRecyclerViewAdapter.getIssueResponseModels();
        for (IssueResponseModel issueResponseModel : issueResponseModels) {
            if (issueId.equals(issueResponseModel.id)) {
                issueResponseModel.rating = rating;
                issueResponseModel.candidate = getPresidentialCandidateById(Integer.parseInt(candidateId));
                issueResponseModel.quote = quote;
            }
        }
        mIssueRecyclerViewAdapter.changeData(issueResponseModels);

        updateAndSaveData();
    }

    private void postResult() {
        updateAndSaveData();
        RestClient.switchToLocalMode();
        RestClient.getAPIService().postResult(mMyMatchModel, new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {
                AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                        .setTitle("Success")
                        .setMessage("Thank you for participating! " +
                                "You can visit the overall results online at http://192.168.43.122:3000")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                alertDialog.show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private boolean isReadyForPostResult() {
        if (mMyMatchModel == null) {
            return false;
        }
        List<IssueResponseModel> issueResponseModels = mIssueRecyclerViewAdapter.getIssueResponseModels();
        for (IssueResponseModel issueResponseModel : issueResponseModels) {
            if (issueResponseModel.candidate == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_find_my_match, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.postResult:
                if (isReadyForPostResult()) {
                    postResult();
                }
                return true;
        }
        return false;
    }

}
