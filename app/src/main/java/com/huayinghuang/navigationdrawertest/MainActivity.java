package com.huayinghuang.navigationdrawertest;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();
        setActionBarNoIcon();
        setActionBarTitle("MainActivity1");
        initLayout();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int iViewId = v.getId();

        if (iViewId == R.id.button) {
            Intent intent = new Intent();
            intent.setClass(this,Main2Activity.class);
            startActivity(intent);
        } else {
            super.onClick(v);
        }
    }

    private void initLayout() {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        button.setPaintFlags(button.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}
