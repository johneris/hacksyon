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
public class ChatbotRegisterActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ChatbotRegisterActivity.class);
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

    private boolean willShowOkButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
//                discuss();
            }
        });
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
