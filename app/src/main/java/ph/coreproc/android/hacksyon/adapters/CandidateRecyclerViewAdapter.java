package ph.coreproc.android.hacksyon.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.activities.CandidateDetailsActivity;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 6/8/2015.
 */
public class CandidateRecyclerViewAdapter extends RecyclerView.Adapter<CandidateRecyclerViewAdapter.CandidateViewHolder> {

    List<Candidate> mCandidates;
    private Context mContext;

    public CandidateRecyclerViewAdapter(Context context, List<Candidate> candidates) {
        mContext = context;
        mCandidates = candidates;
    }

    @Override
    public CandidateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_candidate, parent, false);
        CandidateViewHolder candidateViewHolder = new CandidateViewHolder(view);
        return candidateViewHolder;
    }

    @Override
    public void onBindViewHolder(CandidateViewHolder holder, int position) {
        final Candidate candidate = mCandidates.get(position);
        holder.mCandidateImageView.setImageResource(candidate.getImage());
        holder.mCandidateBackgroundImageView.setImageResource(candidate.getColor());
        holder.mCandidateNameTextView.setText(candidate.getName());
        holder.mCandidateDescription.setText(candidate.getDescription());
        holder.mMainContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = CandidateDetailsActivity.newIntent(mContext, candidate);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCandidates.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void changeData(List<Candidate> candidates) {
        mCandidates = candidates;
        notifyDataSetChanged();
    }

    public static class CandidateViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.candidateBackgroundImageView)
        CircleImageView mCandidateBackgroundImageView;

        @Bind(R.id.candidateImageView)
        CircleImageView mCandidateImageView;

        @Bind(R.id.candidateNameTextView)
        TextView mCandidateNameTextView;

        @Bind(R.id.candidateDescriptionTextView)
        TextView mCandidateDescription;

        @Bind(R.id.mainContainer)
        LinearLayout mMainContainer;

        CandidateViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
