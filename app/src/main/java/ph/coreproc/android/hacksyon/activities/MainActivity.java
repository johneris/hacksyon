package ph.coreproc.android.hacksyon.activities;

import android.content.Intent;
import android.os.Bundle;

import ph.coreproc.android.hacksyon.R;

/**
 * Created by johneris on 6/1/2015.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = HomeActivity.newIntent(mContext);
        startActivity(intent);
        finish();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

}
