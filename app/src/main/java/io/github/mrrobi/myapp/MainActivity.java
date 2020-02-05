package io.github.mrrobi.myapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    public void chrome(View view) {
        if (!openApp(MainActivity.this, "com.android.chrome")) {
            launchPlayStoreWithAppPackage(MainActivity.this, "com.android.chrome");
        }
        //startActivity(getPackageManager().getLaunchIntentForPackage("com.android.chrome"));
    }

    public void messenger(View view) {
        if (!openApp(MainActivity.this, "com.facebook.orca")) {
            launchPlayStoreWithAppPackage(MainActivity.this, "com.facebook.orca");
        }
        //startActivity(getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
    }

    public void go(View view) {
        if (!openApp(MainActivity.this, "com.facebook.katana")) {
            launchPlayStoreWithAppPackage(MainActivity.this, "com.facebook.katana");
        }
        //startActivity(getPackageManager().getLaunchIntentForPackage("com.facebook.katana"));
    }
    public void WA(View view) {
        if (!openApp(MainActivity.this, "com.whatsapp")) {
            launchPlayStoreWithAppPackage(MainActivity.this, "com.whatsapp");
        }
        //startActivity(getPackageManager().getLaunchIntentForPackage("com.whatsapp"));
    }
    public void insta(View view) {
        if (!openApp(MainActivity.this, "com.instagram.android")) {
            launchPlayStoreWithAppPackage(MainActivity.this, "com.instagram.android");
        }
        //startActivity(getPackageManager().getLaunchIntentForPackage("com.instagram.android"));
    }
    public void youtube(View view) {
        if (!openApp(MainActivity.this, "com.google.android.youtube")) {
            launchPlayStoreWithAppPackage(MainActivity.this, "com.google.android.youtube");
        }
        //startActivity(getPackageManager().getLaunchIntentForPackage("com.google.android.youtube"));
    }

    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        try {
            Intent i = manager.getLaunchIntentForPackage(packageName);
            if (i == null) {
                return false;
                //throw new ActivityNotFoundException();
            }
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /**
     * Open another app.
     *
     * @param context     current Context, like Activity, App, or Service
     * @param packageName the full package name of the app to open
     */
    public static void launchPlayStoreWithAppPackage(Context context, String packageName) {
        Intent i = new Intent(android.content.Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
        context.startActivity(i);
    }
    public  void check(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode()
                ==AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //check();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Send email", "");
                String[] TO = {""};
                String[] CC = {""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:mrrobi040@hotmail.com"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Log.i("Finished sending email", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            if (!openApp(MainActivity.this, "com.moodle.moodlemobile")) {
                launchPlayStoreWithAppPackage(MainActivity.this, "com.moodle.moodlemobile");
            }
            //startActivity(getPackageManager().getLaunchIntentForPackage("com.moodle.moodlemobile"));
        } else if (id == R.id.nav_gallery) {
            if (!openApp(MainActivity.this, "com.android.gallery3d")) {
                launchPlayStoreWithAppPackage(MainActivity.this, "com.android.gallery3d");
            }
            //startActivity(getPackageManager().getLaunchIntentForPackage("com.android.gallery3d"));
        } else if (id == R.id.nav_slideshow) {
            if (!openApp(MainActivity.this, "com.google.android.keep")) {
                launchPlayStoreWithAppPackage(MainActivity.this, "com.google.android.keep");
            }
            //startActivity(getPackageManager().getLaunchIntentForPackage("com.google.android.keep"));
        } else if (id == R.id.nav_manage) {
            if (!openApp(MainActivity.this, "com.android.settings")) {
                launchPlayStoreWithAppPackage(MainActivity.this, "com.android.settings");
            }
            //startActivity(getPackageManager().getLaunchIntentForPackage("com.android.settings"));
        } else if (id == R.id.nav_share) {
            if (!openApp(MainActivity.this, "com.duokan.phone.remotecontroller")) {
                launchPlayStoreWithAppPackage(MainActivity.this, "com.duokan.phone.remotecontroller");
            }
            //startActivity(getPackageManager().getLaunchIntentForPackage("com.duokan.phone.remotecontroller"));
        } else if (id == R.id.nav_send) {
            if (!openApp(MainActivity.this, "com.android.messaging")) {
                launchPlayStoreWithAppPackage(MainActivity.this, "com.android.messaging");
            }
            //startActivity(getPackageManager().getLaunchIntentForPackage("com.android.messaging"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
