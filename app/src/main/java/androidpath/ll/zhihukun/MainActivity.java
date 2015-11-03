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

import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import androidpath.ll.zhihukun.adapters.SimpleAdapter;
import androidpath.ll.zhihukun.interfaces.ZhihuService;
import androidpath.ll.zhihukun.models.Stories;
import androidpath.ll.zhihukun.models.Story;
import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final String TAG = getClass().getSimpleName();

    private ActionBarDrawerToggle mDrawerToggle;
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

        SimpleAdapter adapter = new SimpleAdapter(list);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        //request feeds, set them into adapter.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://news-at.zhihu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ZhihuService mZhihuService = retrofit.create(ZhihuService.class);
        Call<Stories> stories = mZhihuService.listStories();
        stories.enqueue(new Callback<Stories>() {
            @Override
            public void onResponse(Response<Stories> response, Retrofit retrofit) {
                List<Story> list = response.body().getStories();
                for (Story s : list) {
                    Log.v(TAG, s.toString());
                }
            }
            @Override
            public void onFailure(Throwable t) {

            }
        });

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
