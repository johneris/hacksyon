package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.Bind;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.models.Candidate;

/**
 * Created by johneris on 4/16/16.
 */
public class CandidateDetailsActivity extends BaseActivity {

    public static Intent newIntent(Context context, Candidate candidate) {
        Intent intent = new Intent(context, CandidateDetailsActivity.class);
        return intent;
    }

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.collapsingToolbar)
    CollapsingToolbarLayout mCollapsingToolbar;

    @Bind(R.id.appbar)
    AppBarLayout mAppbar;

    @Bind(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_candidate_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
    }

    private void initUI() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        mCollapsingToolbar.setTitle(getResources().getString(R.string.app_name));
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
