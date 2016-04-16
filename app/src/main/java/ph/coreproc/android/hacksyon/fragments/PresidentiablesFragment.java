package ph.coreproc.android.hacksyon.fragments;

import android.content.Context;
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
import ph.coreproc.android.hacksyon.adapters.CandidateRecyclerViewAdapter;
import ph.coreproc.android.hacksyon.data.presidentiables.SantiagoCandidate;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 6/15/2015.
 */
public class PresidentiablesFragment extends Fragment {

    private Context mContext;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;


    public static PresidentiablesFragment newInstance() {
        PresidentiablesFragment presidentiablesFragment = new PresidentiablesFragment();

//        Bundle args = new Bundle();
//        args.putString("key", "value");
//        fragment.setArguments(args);

        return presidentiablesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candidates, container, false);

//        Bundle bundle = getArguments();

        ButterKnife.bind(this, view);
        initialize();

        mContext = getActivity();

        return view;
    }

    private void initialize() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(false);

        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new SantiagoCandidate());
        candidates.add(new SantiagoCandidate());
        candidates.add(new SantiagoCandidate());
        candidates.add(new SantiagoCandidate());

        CandidateRecyclerViewAdapter candidateRecyclerViewAdapter = new CandidateRecyclerViewAdapter(mContext, candidates);
        mRecyclerView.setAdapter(candidateRecyclerViewAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
