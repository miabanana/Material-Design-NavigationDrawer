package com.huayinghuang.navigationdrawertest;

import android.os.Bundle;
import android.view.MenuItem;

public class Main2Activity extends ActionBarDrawer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setupActionBar();
        setActionBar2Icon();
        setActionBarTitle("MainActivity2");

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

}
