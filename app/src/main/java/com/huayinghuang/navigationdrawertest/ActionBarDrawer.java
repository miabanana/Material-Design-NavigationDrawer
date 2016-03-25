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
public class ActionBarDrawer extends AppCompatActivity implements View.OnClickListener,NavigationView.
                                                                  OnNavigationItemSelectedListener {

    private DrawerLayout m_drawerLayout = null;
    private ActionBar m_actionBar = null;
    private Toolbar m_toolbar = null;
    private NavigationView m_navigationView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Things you want to do when press items in drawer
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle() + " pressed", Toast.LENGTH_SHORT).show();

        item.setChecked(true);//remember the select item
        m_drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onClick(View v) {
        int iViewId = v.getId();

        if (iViewId == R.id.ivHamburger) {

            if (m_drawerLayout.isDrawerOpen(GravityCompat.END)) {
                m_drawerLayout.closeDrawer(GravityCompat.END);
            } else {
                m_drawerLayout.openDrawer(GravityCompat.END);
            }

        } else if (iViewId == R.id.ivBack) {
            onBackPressed();
        }
    }

    protected void setupActionBar() {
        m_drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        m_navigationView = (NavigationView)findViewById(R.id.navigation_view);

        m_toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(m_toolbar);
        m_actionBar = getSupportActionBar();

        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        layoutParams.gravity = GravityCompat.END;

        View customView = getLayoutInflater().inflate(R.layout.action_bar_hamburger_icon, null);

        m_actionBar.setDisplayShowCustomEnabled(true);
        m_actionBar.setCustomView(customView, layoutParams);

        Toolbar parent = (Toolbar) customView.getParent();
        parent.setContentInsetsAbsolute(0,0);
    }

    //left side for back arrow and right side for hamburger icon
    protected void setActionBar2Icon() {
        ImageView ivActionBarRightIcon = (ImageView) m_toolbar.findViewById(R.id.ivHamburger);
        ivActionBarRightIcon.setOnClickListener(this);

        ImageView ivActionBarBackIcon = (ImageView) m_toolbar.findViewById(R.id.ivBack);
        ivActionBarBackIcon.setOnClickListener(this);

        m_navigationView.setNavigationItemSelectedListener(this);
    }

    //right side for hamburger icon
    protected void setActionBarRightIcon() {
        ImageView ivActionBarRightIcon = (ImageView) m_toolbar.findViewById(R.id.ivHamburger);
        ivActionBarRightIcon.setOnClickListener(this);

        ImageView ivActionBarBackIcon = (ImageView) m_toolbar.findViewById(R.id.ivBack);
        ivActionBarBackIcon.setVisibility(View.INVISIBLE);

        m_navigationView.setNavigationItemSelectedListener(this);
    }

    //left side for back arrow icon
    protected void setActionBarLeftIcon() {
        m_drawerLayout.removeView(m_navigationView);

        ImageView ivActionBarRightIcon = (ImageView) m_toolbar.findViewById(R.id.ivHamburger);
        ivActionBarRightIcon.setVisibility(View.INVISIBLE);

        ImageView ivActionBarBackIcon = (ImageView) m_toolbar.findViewById(R.id.ivBack);
        ivActionBarBackIcon.setOnClickListener(this);
    }

    //show only title on action bar
    protected void setActionBarNoIcon() {
        m_drawerLayout.removeView(m_navigationView);

        ImageView ivActionBarRightIcon = (ImageView) m_toolbar.findViewById(R.id.ivHamburger);
        ivActionBarRightIcon.setVisibility(View.INVISIBLE);

        ImageView ivActionBarBackIcon = (ImageView) m_toolbar.findViewById(R.id.ivBack);
        ivActionBarBackIcon.setVisibility(View.INVISIBLE);
    }

    protected void setActionBarTitle(String string) {
        m_actionBar.setDisplayShowTitleEnabled(false);
        TextView tvTitle = (TextView) m_toolbar.findViewById(R.id.tvActionBarTitle);
        tvTitle.setText(string);
    }
}
