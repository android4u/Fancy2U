package com.meunicorn.fancy2u.UI.Activivty;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.meunicorn.fancy2u.Bean.Shots.Shot;
import com.meunicorn.fancy2u.R;
import com.meunicorn.fancy2u.UI.Adapter.ShotFragmentViewPagerAdapter;
import com.meunicorn.fancy2u.UI.Fragment.ShotFragment;
import com.meunicorn.fancy2u.Utils.ActivityStart;

/**
 * Created by Fancy on 2016/4/27.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ShotFragment.OnListFragmentInteractionListener {
    DrawerLayout drawer;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public void onListFragmentInteraction(Shot item) {
        ActivityStart.toDetail(this, item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_buckets:
                break;
            case R.id.nav_follwers:
                break;
            case R.id.nav_likes:
                break;
            case R.id.nav_projects:
                break;
            case R.id.nav_shots:
                break;
            case R.id.nav_teams:
                break;
            case R.id.nav_about:
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStart.toLogin(MainActivity.this);
            }
        });
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        viewPager= (ViewPager) findViewById(R.id.vp_main_display);
        tabLayout= (TabLayout) findViewById(R.id.tab_main_title);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initViewPager();
    }

    private void initViewPager() {
        ShotFragmentViewPagerAdapter adapter = new ShotFragmentViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ShotFragment().newInstance("popularity"), getResources().getString(R.string.popular));
        adapter.addFragment(new ShotFragment().newInstance("recent"), getResources().getString(R.string.recent));
        adapter.addFragment(new ShotFragment().newInstance("comments"), getResources().getString(R.string.comments));
        adapter.addFragment(new ShotFragment().newInstance("views"), getResources().getString(R.string.views));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = (MenuItem) findViewById(R.id.search_shot);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
