package com.rxjava.jan.helloreactiveworld;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.rxjava.jan.helloreactiveworld.example1.FirstExampleFragment;
import com.rxjava.jan.helloreactiveworld.example2.SecondExampleFragment;
import com.rxjava.jan.helloreactiveworld.navigation_drawer.NavigationDrawerCallbacks;
import com.rxjava.jan.helloreactiveworld.navigation_drawer.NavigationDrawerFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jan on 18/12/2015.
 */
public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

    @Bind(R.id.toolbar_actionbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer)
    DrawerLayout mDrawerLayout;

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, mDrawerLayout, mToolbar);

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        switch (position) {
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new FirstExampleFragment())
                        .commit();
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new SecondExampleFragment())
                        .commit();
                break;
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new ThirdExampleFragment())
                        .commit();
                break;
//            case 3:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new FilterExampleFragment())
//                        .commit();
//                break;
//            case 4:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new TakeExampleFragment())
//                        .commit();
//                break;
//            case 5:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new DistinctExampleFragment())
//                        .commit();
//                break;
//            case 6:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new MapExampleFragment())
//                        .commit();
//                break;
//            case 7:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new ScanExampleFragment())
//                        .commit();
//                break;
//            case 8:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new GroupByExampleFragment())
//                        .commit();
//                break;
//            case 9:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new MergeExampleFragment())
//                        .commit();
//                break;
//            case 10:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new ZipExampleFragment())
//                        .commit();
//                break;
//            case 11:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new JoinExampleFragment())
//                        .commit();
//                break;
//            case 12:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new CombineLatestExampleFragment())
//                        .commit();
//                break;
//            case 13:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new AndThenWhenExampleFragment())
//                        .commit();
//                break;
//            case 14:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new SharedPreferencesListFragment())
//                        .commit();
//                break;
//            case 15:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new LongTaskFragment())
//                        .commit();
//                break;
//            case 16:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new NetworkTaskFragment())
//                        .commit();
//                break;
//            case 17:
//                startActivity(new Intent(this, SoActivity.class));
//                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen()) {
            mNavigationDrawerFragment.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
