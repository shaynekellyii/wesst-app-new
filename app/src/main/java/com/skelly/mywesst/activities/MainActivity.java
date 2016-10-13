package com.skelly.mywesst.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.skelly.mywesst.R;
import com.skelly.mywesst.messages.MessagesFragment;
import com.skelly.mywesst.org.OrgFragment;
import com.skelly.mywesst.profile.ProfileFragment;
import com.skelly.mywesst.schools.SchoolsFragment;
import com.skelly.mywesst.stream.StreamFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StreamFragment streamFragment = new StreamFragment();
        fragmentTransaction.add(R.id.fragment_container, streamFragment);
        fragmentTransaction.commit();

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setImageResource(R.drawable.ic_fab_send);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            int count = getFragmentManager().getBackStackEntryCount();
            if (count == 0) {
                super.onBackPressed();
            }
            else {
                getFragmentManager().popBackStack();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle bundle = new Bundle();

        switch (id) {
            case R.id.nav_stream:
                fragment = new StreamFragment();
                mFab.setVisibility(View.VISIBLE);
                break;
            case R.id.nav_events:
                // TODO: Implement this
                fragment = new OrgFragment();
                bundle.putString("orgType", "school");
                fragment.setArguments(bundle);
                mFab.setVisibility(View.GONE);
                break;
            case R.id.nav_org:
                fragment = new OrgFragment();
                bundle.putString("orgType", "org");
                fragment.setArguments(bundle);
                mFab.setVisibility(View.GONE);
                break;
            case R.id.nav_schools:
                fragment = new SchoolsFragment();
                mFab.setVisibility(View.GONE);
                break;
            case R.id.nav_profile:
                fragment = new ProfileFragment();
                mFab.setVisibility(View.GONE);
                break;
            case R.id.nav_messages:
                fragment = new MessagesFragment();
                mFab.setVisibility(View.VISIBLE);
                break;
            default:
                fragment = new StreamFragment();
                break;
        }

        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.getTag());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
