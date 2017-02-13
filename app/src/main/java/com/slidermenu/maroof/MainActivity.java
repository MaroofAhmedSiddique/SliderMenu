package com.slidermenu.maroof;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends Activity implements View.OnClickListener {

    private SlidingMenu menu;
    private ImageView menuToggle;
    private Context ct = null;
    private RelativeLayout Item1;
    private RelativeLayout Item2;
    private RelativeLayout Item3;
    private RelativeLayout Item4;
    private RelativeLayout Item5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ct = this;
        menuToggle = (ImageView) findViewById(R.id.menu_toggle);

        try {
            menu = new SlidingMenu(this);
            menu.setMode(SlidingMenu.LEFT);
            menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
            menu.setShadowWidthRes(R.dimen.shadow_width);
            menu.setShadowDrawable(R.drawable.shadow);
            menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
            menu.setFadeDegree(0.8f);
            menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
            menu.setMenu(R.layout.leftmenu);
            menu.setSlidingEnabled(true);

            menuToggle.setOnClickListener(this);

            if (menuToggle != null) {
                menuToggle.setOnClickListener(MainActivity.this);
                menuToggle.setImageResource(R.drawable.ic_menu);
                menuToggle.setTag(0);
            }

            View leftView = menu.getMenu();
            initLeftMenu(leftView);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_toggle:
                menu.toggle();
                break;

            default:
                break;
        }
    }


    private void initLeftMenu(View leftView) {

        Item1 = (RelativeLayout) leftView.findViewById(R.id.item_one);
        Item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
                Toast.makeText(ct, "Item1", Toast.LENGTH_SHORT).show();
            }
        });

        Item2 = (RelativeLayout) leftView.findViewById(R.id.item_two);
        Item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
                Toast.makeText(ct, "Item2", Toast.LENGTH_SHORT).show();

            }
        });
        Item3 = (RelativeLayout) leftView.findViewById(R.id.item_three);
        Item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
                Toast.makeText(ct, "Item3", Toast.LENGTH_SHORT).show();
            }
        });

        Item4 = (RelativeLayout) leftView.findViewById(R.id.item_four);
        Item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
                Toast.makeText(ct, "Item4", Toast.LENGTH_SHORT).show();
            }
        });


        Item5 = (RelativeLayout) leftView.findViewById(R.id.item_five);
        Item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
                Toast.makeText(ct, "Item5", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
