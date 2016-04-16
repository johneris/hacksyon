package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.adapters.CandidateRecyclerViewAdapter;
import ph.coreproc.android.hacksyon.data.presidentiables.PresidentiableEnum;
import ph.coreproc.android.hacksyon.models.Candidate;
import ph.coreproc.android.hacksyon.utils.DividerItemDecoration;

/**
 * Created by johneris on 4/17/16.
 */
public class ChoosePresidentActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ChoosePresidentActivity.class);
        return intent;
    }

    public static String RESULT_CANDIDATE_ID = "RESULT_CANDIDATE_ID";

    @Bind(R.id.candidatesRecyclerView)
    RecyclerView mCandidatesRecyclerView;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_choose_president;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
    }

    private void initUI() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mCandidatesRecyclerView.setLayoutManager(linearLayoutManager);

        mCandidatesRecyclerView.setNestedScrollingEnabled(false);
        mCandidatesRecyclerView.setHasFixedSize(false);

        mCandidatesRecyclerView.addItemDecoration(
                new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST)
        );

        List<Candidate> candidates = new ArrayList<>();
        for (PresidentiableEnum p : PresidentiableEnum.values()) {
            candidates.add(p.getObject());
        }

        CandidateRecyclerViewAdapter candidateRecyclerViewAdapter = new CandidateRecyclerViewAdapter(mContext, candidates) {
            @Override
            public void onCandidateClicked(Candidate candidate) {
                Intent intent = new Intent();
                intent.putExtra(RESULT_CANDIDATE_ID, candidate.getId());
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        mCandidatesRecyclerView.setAdapter(candidateRecyclerViewAdapter);
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
