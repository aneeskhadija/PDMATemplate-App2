package com.anees.pdma.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.anees.pdma.R;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout L_covidReport, L_notification, L_call, L_weather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        L_covidReport = findViewById(R.id.id_btn_covid_report);
        L_notification = findViewById(R.id.id_btn_notification);
        L_call = findViewById(R.id.id_btn_call);
        L_weather = findViewById(R.id.id_btn_weather);

        L_covidReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Home.this, "Covid Report in progress!!!", Toast.LENGTH_SHORT).show();

                /*Intent intnt_weather = new Intent(Home.this, Weather.class);
                startActivity(intnt_weather);*/
            }
        });

        L_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Home.this, "Notification in progress!!!", Toast.LENGTH_SHORT).show();
                /*Intent intnt_weather = new Intent(Home.this, Weather.class);
                startActivity(intnt_weather);*/
            }
        });

        L_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Home.this, "Help Line calls in progress!!!", Toast.LENGTH_SHORT).show();
                /*Intent intnt_weather = new Intent(Home.this, Weather.class);
                startActivity(intnt_weather);*/
            }
        });

        L_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intnt_weather = new Intent(Home.this, Weather.class);
                startActivity(intnt_weather);
            }
        });

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.login_item:
                // do your code
                Intent intnt_login = new Intent(Home.this, Login.class);
                startActivity(intnt_login);

                return true;
            case R.id.refresh_item:
                // do your code
                Toast.makeText(this, "Refresh in progress!!!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about_item:
                // do your code
                Toast.makeText(this, "About in progress!!!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting_item:
                // do your code
                Toast.makeText(this, "Setting in progress!!!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tap again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int ids = item.getItemId();

        if (ids == R.id.nav_home) {
            // Handle the camera action
        } /*else if (ids == R.id.nav_privacy) {

        }*/ else if (ids == R.id.nav_feedback) {

            int  id = 4;

            /*Intent mIntent = new Intent(Home.this, WebActivity.class);
            mIntent.putExtra("position", id);
            Home.this.startActivity(mIntent);*/

        } else if (ids == R.id.nav_contact) {

            /*Intent mIntent = new Intent(MainActivity.this, ContactUs.class);
            MainActivity.this.startActivity(mIntent);*/

        } else if (ids == R.id.nav_about) {

            /*int  id = 0;

            Intent mIntent = new Intent(MainActivity.this, WebActivity.class);
            mIntent.putExtra("position", id);
            MainActivity.this.startActivity(mIntent);*/

        } else if (ids == R.id.nav_share) {

            shareLink();

        } else if (ids == R.id.nav_send) {

            sendEmail();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Dha Project Link share
    public void shareLink(){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Share Link";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }

    //  Send Email Address
    protected void sendEmail() {

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@pdma.govt.com"});
        //  email.putExtra(Intent.EXTRA_SUBJECT, "subject");
        //  email.putExtra(Intent.EXTRA_TEXT, "message");
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));

    }

}