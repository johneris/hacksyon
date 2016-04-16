package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.solovyev.android.views.llm.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.adapters.ChatMessageRecyclerViewAdapter;
import ph.coreproc.android.hacksyon.models.MessageModel;
import ph.coreproc.android.hacksyon.models.MessageSenderEnum;

/**
 * Created by johneris on 4/16/16.
 */
public class ChatbotDiscussActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ChatbotDiscussActivity.class);
        intent.putExtra(ARGS_IS_FOR_TOPIC_DISCUSSION, false);
        return intent;
    }

    private static String ARGS_IS_FOR_TOPIC_DISCUSSION = "ARGS_IS_FOR_TOPIC_DISCUSSION";

    private static String ARGS_TOPIC = "ARGS_TOPIC";
    private static String ARGS_DETAILS = "ARGS_DETAILS";

    public static Intent newIntent(Context context, String topic, List<String> details) {
        Intent intent = new Intent(context, ChatbotDiscussActivity.class);
        intent.putExtra(ARGS_IS_FOR_TOPIC_DISCUSSION, true);
        intent.putExtra(ARGS_TOPIC, topic);
        CharSequence[] detailsToPass = new CharSequence[details.size()];
        for (int i = 0; i < details.size(); i++) {
            detailsToPass[i] = details.get(i);
        }
        intent.putExtra(ARGS_DETAILS, detailsToPass);
        return intent;
    }

    @Bind(R.id.messageRecyclerView)
    RecyclerView mMessageRecyclerView;

    @Bind(R.id.okButton)
    Button mOkButton;

    ChatMessageRecyclerViewAdapter mChatMessageRecyclerViewAdapter;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_chatbot;
    }

    private boolean mIsForTopicDiscussion;
    private String mTopic = "";
    private List<String> mDetails = new ArrayList<>();

    private boolean willShowOkButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        mIsForTopicDiscussion = bundle.getBoolean(ARGS_IS_FOR_TOPIC_DISCUSSION);
        if (mIsForTopicDiscussion) {
            mTopic = bundle.getString(ARGS_TOPIC);
            CharSequence[] details = bundle.getCharSequenceArray(ARGS_DETAILS);
            for (CharSequence detail : details) {
                mDetails.add(detail.toString());
            }
        }

        initUI();
    }

    private void initUI() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mMessageRecyclerView.setLayoutManager(linearLayoutManager);

        mMessageRecyclerView.setNestedScrollingEnabled(false);
        mMessageRecyclerView.setHasFixedSize(false);

        List<MessageModel> messageModels = new ArrayList<>();

        mChatMessageRecyclerViewAdapter = new ChatMessageRecyclerViewAdapter(mContext, messageModels) {
            @Override
            public void allLoadingFinished() {
                if (willShowOkButton) {
                    mOkButton.setVisibility(View.VISIBLE);
                }
                willShowOkButton = false;
            }
        };
        mMessageRecyclerView.setAdapter(mChatMessageRecyclerViewAdapter);

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOkButton.setVisibility(View.INVISIBLE);
                addMessage(new MessageModel(MessageSenderEnum.USER, "OK"));
                discuss();
            }
        });

        if (mIsForTopicDiscussion) {
            addMessage(new MessageModel(MessageSenderEnum.BOT, "Hi, Let's talk about " + mTopic));
            showOkButton();
        }
    }

    private void discuss() {
        if (mDetails.isEmpty()) {
            addMessage(new MessageModel(MessageSenderEnum.BOT, "I hope you learned something. Thanks for your time! :)"));
            return;
        }
        String message = mDetails.get(0);
        mDetails.remove(0);
        addMessage(new MessageModel(MessageSenderEnum.BOT, message));
        showOkButton();
    }

    private void showOkButton() {
        willShowOkButton = true;
    }

    private void addMessage(MessageModel messageModel) {
        mChatMessageRecyclerViewAdapter.add(messageModel);
        mMessageRecyclerView.smoothScrollToPosition(mChatMessageRecyclerViewAdapter.getItemCount()-1);
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
