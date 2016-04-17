package ph.coreproc.android.hacksyon.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.StandOnIssueResponseModel;

/**
 * Created by johneris on 6/8/2015.
 */
public abstract class CandidateStandRecyclerViewAdapter extends RecyclerView.Adapter<CandidateStandRecyclerViewAdapter.StandOnIssueViewHolder> {

    List<StandOnIssueResponseModel> mStandOnIssueResponseModels;
    private Context mContext;

    private int selection = -1;

    public abstract void onStandOnIssueClicked(StandOnIssueResponseModel standOnIssueResponseModel);

    public CandidateStandRecyclerViewAdapter(Context context, List<StandOnIssueResponseModel> standOnIssueResponseModels) {
        mContext = context;
        mStandOnIssueResponseModels = standOnIssueResponseModels;
    }

    @Override
    public StandOnIssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_candidate_stand, parent, false);
        StandOnIssueViewHolder standOnIssueViewHolder = new StandOnIssueViewHolder(view);
        return standOnIssueViewHolder;
    }

    @Override
    public void onBindViewHolder(final StandOnIssueViewHolder holder, final int position) {
        final StandOnIssueResponseModel standOnIssueResponseModel = mStandOnIssueResponseModels.get(position);
        int summaryBackgroundRes;
        if (standOnIssueResponseModel.summary.equalsIgnoreCase("yes")) {
            summaryBackgroundRes = R.drawable.bg_yes;
        } else if (standOnIssueResponseModel.summary.equalsIgnoreCase("no")) {
            summaryBackgroundRes = R.drawable.bg_no;
        } else {
            summaryBackgroundRes = R.drawable.bg_undetermined;
        }
        holder.mSummaryContainer.setBackgroundResource(summaryBackgroundRes);
        holder.mSummaryTextView.setText(standOnIssueResponseModel.summary);
        holder.mTextViewMessage.setText(standOnIssueResponseModel.quote);
        holder.mOkImageView.setVisibility(position == selection ? View.VISIBLE : View.GONE);
        if (position == selection) {
            holder.mMainContainer.setBackgroundColor(ContextCompat.getColor(mContext, R.color.independent_light));
        } else {
            holder.mMainContainer.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
        }
        holder.mMainContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection = position;
                onStandOnIssueClicked(standOnIssueResponseModel);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStandOnIssueResponseModels.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void changeData(List<StandOnIssueResponseModel> standOnIssueResponseModels) {
        selection = -1;
        mStandOnIssueResponseModels = standOnIssueResponseModels;
        notifyDataSetChanged();
    }

    public static class StandOnIssueViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.okImageView)
        ImageView mOkImageView;

        @Bind(R.id.summaryTextView)
        TextView mSummaryTextView;

        @Bind(R.id.summaryContainer)
        FrameLayout mSummaryContainer;

        @Bind(R.id.textViewMessage)
        TextView mTextViewMessage;

        @Bind(R.id.mainContainer)
        LinearLayout mMainContainer;

        StandOnIssueViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
