package androidpath.ll.zhihukun;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import androidpath.ll.zhihukun.adapters.StoryAdapter;
import androidpath.ll.zhihukun.models.APIManager;
import androidpath.ll.zhihukun.models.Story;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final String TAG = getClass().getSimpleName();
    private ActionBarDrawerToggle mDrawerToggle;
    private StoryAdapter storyAdapter;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.navigation_drawer)
    NavigationView mDrawer;
    @Bind(R.id.list)
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpLayout();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(linearLayoutManager);
        storyAdapter = new StoryAdapter(this);

        APIManager mAPIManager = new APIManager();
        mAPIManager.getStoriesList()
                .subscribe(list -> {
                    storyAdapter.updateItems(list.size());
                    storyAdapter.setDataSet(list);
                    for (Story item : list) {
                        Log.v(TAG, item.toString());
                    }
                });
        list.setAdapter(storyAdapter);

    }

    private void setUpLayout() {
        setSupportActionBar(mToolbar);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        Log.v(TAG, menuItem.getTitle().toString());
        return true;
    }

}
