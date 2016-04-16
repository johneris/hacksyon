package ph.coreproc.android.hacksyon.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import butterknife.Bind;
import ph.coreproc.android.hacksyon.R;
import ph.coreproc.android.hacksyon.adapters.CandidatesViewPagerAdapter;
import ph.coreproc.android.hacksyon.fragments.PresidentiablesFragment;
import ph.coreproc.android.hacksyon.fragments.VicePresidentiablesFragment;

/**
 * Created by johneris on 4/16/16.
 */
public class CandidatesActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, CandidatesActivity.class);
        return intent;
    }

    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;

    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private PresidentiablesFragment mPresidentiablesFragment;
    private VicePresidentiablesFragment mVicePresidentiablesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_candidates;
    }

    private void initUI() {
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        setUpTabIcons(mTabLayout);
    }

    private void setUpViewPager(final ViewPager viewPager) {
        mPresidentiablesFragment = PresidentiablesFragment.newInstance();
        mVicePresidentiablesFragment = VicePresidentiablesFragment.newInstance();

        CandidatesViewPagerAdapter viewPagerAdapter = new CandidatesViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(mPresidentiablesFragment, "Presidentiables");
        viewPagerAdapter.addFragment(mVicePresidentiablesFragment, "Vice Presidentiables");
        viewPager.setAdapter(viewPagerAdapter);

    }

    private void setUpTabIcons(TabLayout tabLayout) {
        tabLayout.setSelectedTabIndicatorHeight(8);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
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
