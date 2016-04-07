package com.huayinghuang.navigationdrawertest;

/**
 * order of function:
 * 1.setActionBar();
 * 2.setActionBar2Icon(); / setActionBarRightIcon(); / setActionBarLeftIcon(); / setActionBarNoIcon();
 * (3.setActionBarTitle();)
 */

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by miahuang on 2016/1/30.
 */
public class ActionBarDrawer extends AppCompatActivity implements NavigationView.
                                                                  OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout = null;
    private ActionBar mActionBar = null;
    private Toolbar mToolbar = null;
    private NavigationView mNavigationView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Things you want to do when press items in drawer
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle() + " pressed", Toast.LENGTH_SHORT).show();

        item.setChecked(true);//remember the select item
        mDrawerLayout.closeDrawers();
        return true;
    }

    private View.OnClickListener onHamburgerClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
                mDrawerLayout.closeDrawer(GravityCompat.END);
            } else {
                mDrawerLayout.openDrawer(GravityCompat.END);
            }

        }
    };

    private View.OnClickListener onBackClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };

    public final void setupActionBar() {
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        mNavigationView = (NavigationView)findViewById(R.id.navigation_view);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();

        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        layoutParams.gravity = GravityCompat.END;

        View customView = getLayoutInflater().inflate(R.layout.action_bar_hamburger_icon, null);

        mActionBar.setDisplayShowCustomEnabled(true);
        mActionBar.setCustomView(customView, layoutParams);

        Toolbar parent = (Toolbar) customView.getParent();
        parent.setContentInsetsAbsolute(0,0);
    }

    //left side for back arrow and right side for hamburger icon
    public final void setActionBar2Icon() {
        ImageView actionBarHamburgerIcon = (ImageView) mToolbar.findViewById(R.id.hamburger);
        actionBarHamburgerIcon.setOnClickListener(onHamburgerClicked);

        ImageView actionBarBackIcon = (ImageView) mToolbar.findViewById(R.id.goBack);
        actionBarBackIcon.setOnClickListener(onBackClicked);

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    //right side for hamburger icon
    public final void setActionBarRightIcon() {
        ImageView actionBarHamburgerIcon = (ImageView) mToolbar.findViewById(R.id.hamburger);
        actionBarHamburgerIcon.setOnClickListener(onHamburgerClicked);

        ImageView actionBarBackIcon = (ImageView) mToolbar.findViewById(R.id.goBack);
        actionBarBackIcon.setVisibility(View.INVISIBLE);

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    //left side for back arrow icon
    public final void setActionBarLeftIcon() {
        mDrawerLayout.removeView(mNavigationView);

        ImageView actionBarHamburgerIcon = (ImageView) mToolbar.findViewById(R.id.hamburger);
        actionBarHamburgerIcon.setVisibility(View.INVISIBLE);

        ImageView actionBarBackIcon = (ImageView) mToolbar.findViewById(R.id.goBack);
        actionBarBackIcon.setOnClickListener(onBackClicked);
    }

    //show only title on action bar
    public final void setActionBarNoIcon() {
        mDrawerLayout.removeView(mNavigationView);

        ImageView actionBarHamburgerIcon = (ImageView) mToolbar.findViewById(R.id.hamburger);
        actionBarHamburgerIcon.setVisibility(View.INVISIBLE);

        ImageView actionBarBackIcon = (ImageView) mToolbar.findViewById(R.id.goBack);
        actionBarBackIcon.setVisibility(View.INVISIBLE);
    }

    public final void setActionBarTitle(String string) {
        mActionBar.setDisplayShowTitleEnabled(false);
        TextView title = (TextView) mToolbar.findViewById(R.id.actionBarTitle);
        title.setText(string);
    }
}
