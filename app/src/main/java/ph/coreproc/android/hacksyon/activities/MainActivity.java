package ph.coreproc.android.hacksyon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.StandOnIssueResponseModel;
import ph.coreproc.android.hacksyon.rest.RestClient;
import ph.coreproc.android.hacksyon.utils.Preferences;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by johneris on 6/1/2015.
 */
public class MainActivity extends BaseActivity {

    public static String TAG = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Preferences.getFirstStart(mContext)) {
            Intent intent = ChatbotRegisterActivity.newIntent(mContext);
            startActivity(intent);
        } else {
            Intent intent = HomeActivity.newIntent(mContext);
            startActivity(intent);
        }

        finish();

//        for (PresidentiableEnum p : PresidentiableEnum.values()) {
//            candidateIds.add(p.getObject().getId() + "");
//        }
//
//        standOnIssue(candidateIds.get(0));
    }

    List<String> candidateIds = new ArrayList<>();

    private void standOnIssue(final String id) {
        RestClient.getAPIService().getCandidateStandOnIssue(Integer.parseInt(id), "pP6I28KA6", "ccGwXFv9k9vO68igyXmPRvHiYrgp",
                new Callback<List<StandOnIssueResponseModel>>() {
                    @Override
                    public void success(List<StandOnIssueResponseModel> standOnIssueResponseModels, Response response) {
                        Log.d(TAG, "candidate: " + id);
                        for (StandOnIssueResponseModel standOnIssueResponseModel : standOnIssueResponseModels) {
                            if (!standOnIssueResponseModel.quote.isEmpty()) {
                                Log.d(TAG, standOnIssueResponseModel.issueId);
                            }
                        }

                        candidateIds.remove(0);
                        if (!candidateIds.isEmpty()) {
                            standOnIssue(candidateIds.get(0));
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

}
