package ph.coreproc.android.hacksyon.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.MessageModel;
import ph.coreproc.android.hacksyon.models.MessageSenderEnum;

/**
 * Created by johneris on 6/8/2015.
 */
public abstract class ChatMessageRecyclerViewAdapter extends RecyclerView.Adapter<ChatMessageRecyclerViewAdapter.MessageViewHolder> {

    List<MessageModel> mMessageModels;
    List<Boolean> mIsMessageLoaded;
    private Context mContext;

    public abstract void allLoadingFinished();

    public ChatMessageRecyclerViewAdapter(Context context, List<MessageModel> messageModels) {
        mContext = context;
        mMessageModels = messageModels;
        mIsMessageLoaded = new ArrayList<>();
        for (int i = 0; i < messageModels.size(); i++) {
            mIsMessageLoaded.add(false);
        }
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutRes = 0;
        if (viewType == MessageSenderEnum.BOT.ordinal()) {
            layoutRes = R.layout.list_item_chat_left;
        } else if (viewType == MessageSenderEnum.USER.ordinal()) {
            layoutRes = R.layout.list_item_chat_right;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
        MessageViewHolder messageViewHolder = new MessageViewHolder(view);
        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(final MessageViewHolder holder, final int position) {
        holder.mMessageTextView.setMovementMethod(LinkMovementMethod.getInstance());
        final MessageModel messageModel = mMessageModels.get(position);
        if (mIsMessageLoaded.get(position) || messageModel.messageSenderEnum == MessageSenderEnum.USER) {
            holder.mMessageTextView.setText(Html.fromHtml(messageModel.message));
            mIsMessageLoaded.set(position, true);
        } else {
            holder.mMessageTextView.setText(". . .");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    holder.mMessageTextView.setText(Html.fromHtml(messageModel.message));
                    mIsMessageLoaded.set(position, true);
                    int counter = 0;
                    for (boolean b : mIsMessageLoaded) {
                        if (b) {
                            counter++;
                        }
                    }
                    if (counter == mIsMessageLoaded.size()) {
                        allLoadingFinished();
                    }
                }
            }, 2000);
        }

        if (position > 0 && messageModel.messageSenderEnum == mMessageModels.get(position-1).messageSenderEnum) {
            holder.mPersonImageView.setVisibility(View.INVISIBLE);
            holder.mPersonBackgroundImageView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mMessageModels.get(position).messageSenderEnum.ordinal();
    }

    @Override
    public int getItemCount() {
        return mMessageModels.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void add(MessageModel messageModel) {
        mMessageModels.add(messageModel);
        mIsMessageLoaded.add(false);

        notifyDataSetChanged();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.personBackgroundImageView)
        CircleImageView mPersonBackgroundImageView;

        @Bind(R.id.personImageView)
        CircleImageView mPersonImageView;

        @Bind(R.id.messageTextView)
        TextView mMessageTextView;

        MessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
