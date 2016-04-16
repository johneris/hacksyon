package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class CandidateDetailsActivity extends BaseActivity {

    private static String ARGS_ID = "ARGS_ID";
    private static String ARGS_IMAGE = "ARGS_IMAGE";
    private static String ARGS_COLOR = "ARGS_COLOR";
    private static String ARGS_COLOR_LIGHT = "ARGS_COLOR_LIGHT";
    private static String ARGS_NAME = "ARGS_NAME";
    private static String ARGS_DESCRIPTION = "ARGS_DESCRIPTION";

    private static String ARGS_PROFILE = "ARGS_PROFILE";
    private static String ARGS_ACCOMPLISHMENTS = "ARGS_ACCOMPLISHMENTS";
    private static String ARGS_CRITIZIZED_FOR = "ARGS_CRITIZIZED_FOR";

    public static Intent newIntent(Context context, Candidate candidate) {
        Intent intent = new Intent(context, CandidateDetailsActivity.class);
        intent.putExtra(ARGS_ID, candidate.getId());
        intent.putExtra(ARGS_IMAGE, candidate.getImage());
        intent.putExtra(ARGS_COLOR, candidate.getColor());
        intent.putExtra(ARGS_COLOR_LIGHT, candidate.getColorLight());
        intent.putExtra(ARGS_NAME, candidate.getName());
        intent.putExtra(ARGS_DESCRIPTION, candidate.getDescription());
        intent.putExtra(ARGS_PROFILE, candidate.getProfile());
        intent.putExtra(ARGS_ACCOMPLISHMENTS, candidate.getAccomplishments());
        intent.putExtra(ARGS_CRITIZIZED_FOR, candidate.getCritizizedFor());
        return intent;
    }

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

    @Bind(R.id.candidateDescriptionTextView)
    TextView mCandidateDescriptionTextView;

    @Bind(R.id.profileDescriptionTextView)
    TextView mProfileDescriptionTextView;

    @Bind(R.id.accomplishmentsDescriptionTextView)
    TextView mAccomplishmentsDescriptionTextView;

    @Bind(R.id.critizedForDescriptionTextView)
    TextView mCritizedForDescriptionTextView;


    @Bind(R.id.candidateBackgroundImageView)
    CircleImageView mCandidateBackgroundImageView;

    @Bind(R.id.candidateImageView)
    CircleImageView mCandidateImageView;

    private int mCandidateId;
    private int mCandidateImage;
    private int mCandidateColor;
    private int mCandidateColorLight;
    private String mCandidateName;
    private String mCandidateDescription;
    private String mCandidateProfile;
    private String mCandidateAccomplishments;
    private String mCandidateCritizizedFor;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_candidate_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        mCandidateId = bundle.getInt(ARGS_ID);
        mCandidateImage = bundle.getInt(ARGS_IMAGE);
        mCandidateColor = bundle.getInt(ARGS_COLOR);
        mCandidateColorLight = bundle.getInt(ARGS_COLOR_LIGHT);
        mCandidateName = bundle.getString(ARGS_NAME);
        mCandidateDescription = bundle.getString(ARGS_DESCRIPTION);
        mCandidateProfile = bundle.getString(ARGS_PROFILE);
        mCandidateAccomplishments = bundle.getString(ARGS_ACCOMPLISHMENTS);
        mCandidateCritizizedFor = bundle.getString(ARGS_CRITIZIZED_FOR);

        initUI();
    }

    private void initUI() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        mCollapsingToolbar.setContentScrimColor(ContextCompat.getColor(mContext, mCandidateColor));
        mCollapsingToolbar.setTitle(mCandidateName);
        mCollapsingToolbar.setBackgroundResource(mCandidateColor);
        mCandidateDescriptionTextView.setText(mCandidateDescription);
        mCandidateImageView.setImageResource(mCandidateImage);
        mCandidateBackgroundImageView.setImageResource(mCandidateColor);
        mSunImageView.setColorFilter(ContextCompat.getColor(mContext, mCandidateColorLight));

        mProfileDescriptionTextView.setText(Html.fromHtml(mCandidateProfile));
        mAccomplishmentsDescriptionTextView.setText(mCandidateAccomplishments);
        mCritizedForDescriptionTextView.setText(mCandidateCritizizedFor);
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
