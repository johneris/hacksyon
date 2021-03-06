package ph.coreproc.android.hacksyon.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.activities.CandidateDetailsActivity;
import ph.coreproc.android.hacksyon.adapters.CandidateRecyclerViewAdapter;
import ph.coreproc.android.hacksyon.data.vice_presidentiables.VicePresidentiableEnum;
import ph.coreproc.android.hacksyon.models.Candidate;
import ph.coreproc.android.hacksyon.utils.DividerItemDecoration;

/**
 * Created by johneris on 6/15/2015.
 */
public class VicePresidentiablesFragment extends Fragment {

    private Context mContext;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;


    public static VicePresidentiablesFragment newInstance() {
        VicePresidentiablesFragment presidentiablesFragment = new VicePresidentiablesFragment();

//        Bundle args = new Bundle();
//        args.putString("key", "value");
//        fragment.setArguments(args);

        return presidentiablesFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candidates, container, false);

//        Bundle bundle = getArguments();

        ButterKnife.bind(this, view);
        initialize();

        return view;
    }

    private void initialize() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(false);

        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST)
        );

        List<Candidate> candidates = new ArrayList<>();
        for (VicePresidentiableEnum vp : VicePresidentiableEnum.values()) {
            candidates.add(vp.getObject());
        }

        CandidateRecyclerViewAdapter candidateRecyclerViewAdapter = new CandidateRecyclerViewAdapter(mContext, candidates) {
            @Override
            public void onCandidateClicked(Candidate candidate) {
                Intent intent = CandidateDetailsActivity.newIntent(mContext, candidate);
                startActivity(intent);
            }
        };
        mRecyclerView.setAdapter(candidateRecyclerViewAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
