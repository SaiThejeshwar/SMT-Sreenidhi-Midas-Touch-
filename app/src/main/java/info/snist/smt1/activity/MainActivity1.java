package info.snist.smt1.activity;

/**
 * Created by sai on 02-02-2016.
 */

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import info.snist.smt1.R;
import info.snist.smt1.frgments.MainFragment;
import info.snist.smt1.frgments.fragment_about;
import info.snist.smt1.frgments.fragment_contact;
import info.snist.smt1.frgments.fragment_home;
import info.snist.smt1.frgments.fragment_location;
import info.snist.smt1.frgments.fragment_notification;
import info.snist.smt1.frgments.fragment_partner;
import info.snist.smt1.frgments.fragment_renewal;

public class MainActivity1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Slide From Left", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        // Handle navigation view item clicks here.
        FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fm.beginTransaction().replace(R.id.content_frame, new fragment_home()).commit();
        } else if (id == R.id.nav_renewal) {
            fm.beginTransaction().replace(R.id.content_frame, new fragment_renewal()).commit();
        } else if (id == R.id.nav_about) {
            fm.beginTransaction().replace(R.id.content_frame, new fragment_about()).commit();
        }
        else if (id == R.id.nav_contact) {
            fm.beginTransaction().replace(R.id.content_frame, new fragment_contact()).commit();
        }
        else if (id == R.id.nav_location) {
            fm.beginTransaction().replace(R.id.content_frame, new fragment_location()).commit();

        }
        else if (id == R.id.nav_notification) {
            fm.beginTransaction().replace(R.id.content_frame, new fragment_notification()).commit();

        }
        else if (id == R.id.nav_partner) {
            fm.beginTransaction().replace(R.id.content_frame, new fragment_partner()).commit();

        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

