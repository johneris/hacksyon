package ph.coreproc.android.hacksyon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.IssueResponseModel;

/**
 * Created by johneris on 6/8/2015.
 */
public abstract class IssueRecyclerViewAdapter extends RecyclerView.Adapter<IssueRecyclerViewAdapter.IssueViewHolder> {

    List<IssueResponseModel> mIssueResponseModels;
    private Context mContext;

    public abstract void onIssueClicked(IssueResponseModel issueResponseModel);

    public IssueRecyclerViewAdapter(Context context, List<IssueResponseModel> issueResponseModels) {
        mContext = context;
        mIssueResponseModels = issueResponseModels;
    }

    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_issue, parent, false);
        IssueViewHolder issueViewHolder = new IssueViewHolder(view);
        return issueViewHolder;
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, int position) {
        final IssueResponseModel issueResponseModel = mIssueResponseModels.get(position);
        holder.mIssueTextView.setText(issueResponseModel.shortName);
        holder.mResultContainer.setVisibility(View.GONE);
        holder.mMainContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onIssueClicked(issueResponseModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIssueResponseModels.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void changeData(List<IssueResponseModel> issueResponseModels) {
        mIssueResponseModels = issueResponseModels;
        notifyDataSetChanged();
    }

    public static class IssueViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.issueTextView)
        TextView mIssueTextView;

        @Bind(R.id.ratingBar)
        RatingBar mRatingBar;

        @Bind(R.id.candidateBackgroundImageView)
        CircleImageView mCandidateBackgroundImageView;

        @Bind(R.id.candidateImageView)
        CircleImageView mCandidateImageView;

        @Bind(R.id.quoteTextView)
        TextView mQuoteTextView;

        @Bind(R.id.resultContainer)
        LinearLayout mResultContainer;

        @Bind(R.id.mainContainer)
        View mMainContainer;

        IssueViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
