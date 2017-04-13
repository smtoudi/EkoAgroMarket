package com.example.slawomirmakurat.ekoagromarket;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.slawomirmakurat.ekoagromarket.drawer.DrawerAddAd;
import com.example.slawomirmakurat.ekoagromarket.drawer.Profile_user;
import com.example.slawomirmakurat.ekoagromarket.user.LoginActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FloatingActionButton fab;
    private AppBarLayout appBarLayout;
    private ShareActionProvider mShareActionProvider;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ThreeTwoImageView threeTwoImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        threeTwoImageView = (ThreeTwoImageView) findViewById(R.id.thereTwoImage);

        viewPager = (ViewPager) findViewById(R.id.content_main);
        viewPager.setAdapter(new com.example.slawomirmakurat.ekoagromarket.PagerAdapter(this, getSupportFragmentManager()));

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        fab = (FloatingActionButton) findViewById(R.id.fab_msg_user);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DrawerAddAd.class);
                startActivity(i);

            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_open, R.string.nav_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Bitmap bitmap = ((BitmapDrawable) getDrawable(R.drawable.avatar_default)).getBitmap();

        RoundedBitmapDrawable avatar = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        avatar.setCircular(true);

        ImageView avatarView = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.avatar);
        avatarView.setImageDrawable(avatar);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
//            case R.id.action_settings:
//                Snackbar.make(drawer, string.some_settings, Snackbar.LENGTH_SHORT).show();
//               return true;
            case R.id.action_create_account:
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                return true;
//            case R.id.search:
//                Intent search = new Intent(this, SearchView.class);
//                startActivity(search);
//            return true;
//            case R.id.action_share:
//                Intent action_share = new Intent(this, ShareActionProvider.class);
//                startActivity(action_share);

        }
        return super.onOptionsItemSelected(item);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_toolbar, menu);

//        https://developer.android.com/reference/android/support/v7/widget/ShareActionProvider.html
//        MenuItem shareItem = menu.findItem(R.id.action_share);
//        ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

//        Intent myShareIntent = new Intent(Intent.ACTION_SEND);
//        myShareIntent.setType("image/*");
//        myShareIntent.putExtra(Intent.EXTRA_STREAM, myImageUri);
//        myShareActionProvider.setShareIntent(myShareIntent);
//        myShareIntent.putExtra(Intent.EXTRA_STREAM, myNewImageUri);
//        myShareActionProvider.setShareIntent(myShareIntent);
//
//        https://coderwall.com/p/zpwrsg/add-search-function-to-list-view-in-android
//        https://github.com/erangaeb/dev-notes/tree/master/android-search-list
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
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
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_home) {
            Intent i = new Intent(this, Profile_user.class);
            startActivity(i);
        }

//        if (id == R.id.action_navig) {
//            Intent i = new Intent(this, DrawerNavig.class);
//            startActivity(i);
//        }
//
//        if (id == R.id.nav_add_frend) {
//            Intent i = new Intent(this, DrawerAddFrend.class);
//            startActivity(i);
//        }
//        if (id == R.id.action_message) {
//            Intent i = new Intent(this, DrawerNavig.class);
//            startActivity(i);
//        }
//
//        if (id == R.id.action_my_ads) {
//            Intent i = new Intent(this, DrawerMyAds.class);
//            startActivity(i);
//        }
//
//        if (id == R.id.action_my_favprite) {
//            Intent i = new Intent(this, DrawerMyFavorite.class);
//            startActivity(i);
//        }
//
//        if (id == R.id.action_lav) {
//            Intent i = new Intent(this, DrawerLav.class);
//            startActivity(i);
//        }
//
//        if (id == R.id.action_add_ad) {
//            Intent i = new Intent(this, DrawerAddAd.class);
//            startActivity(i);
//        }
//
//        if (id == R.id.nav_settings) {
//            Intent i = new Intent(this, DrawerSettings.class);
//            startActivity(i);
//        }
//
//
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

}
