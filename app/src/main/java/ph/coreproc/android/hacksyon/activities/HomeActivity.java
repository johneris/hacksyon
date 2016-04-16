package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import ph.coreproc.android.hacksyon.R;

/**
 * Created by johneris on 4/16/16.
 */
public class HomeActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.collapsingToolbar)
    CollapsingToolbarLayout mCollapsingToolbar;

    @Bind(R.id.sunImageView)
    ImageView mSunImageView;

    @Bind(R.id.appbar)
    AppBarLayout mAppbar;

    @Bind(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;



    // include_home_content

    @Bind(R.id.candidatesButton)
    LinearLayout mCandidatesButton;

    @Bind(R.id.findMyMatchButton)
    LinearLayout mFindMyMatchButton;

    @Bind(R.id.chatbotButton)
    LinearLayout mChatbotButton;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
    }

    private void initUI() {
        mSunImageView.setColorFilter(ContextCompat.getColor(mContext, R.color.independent_light));
        mCollapsingToolbar.setTitle(getResources().getString(R.string.app_name));

        mCandidatesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = CandidatesActivity.newIntent(mContext);
                startActivity(intent);
            }
        });

        mFindMyMatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FindMyMatchActivity.newIntent(mContext);
                startActivity(intent);
            }
        });
    }


}
