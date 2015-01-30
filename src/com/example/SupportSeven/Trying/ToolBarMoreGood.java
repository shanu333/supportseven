package com.example.SupportSeven.Trying;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/27/2015.
 */
public class ToolBarMoreGood extends ActionBarActivity {
    Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.toolbar_more_good);

        toolbar = (Toolbar)findViewById(R.id.moreGoodToolBar);
        setSupportActionBar(toolbar);

        //toolbar.showOverflowMenu();
       // LinearLayout linearLayout = new LinearLayout(this);
       // linearLayout.setOrientation(LinearLayout.VERTICAL);
      //  toolbar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50));
//        //toolbar.set

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_with_toolbar_tool_menu, menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);



//        View logo = getLayoutInflater().inflate(R.layout.smiley_layout, null);
//        toolbar.addView(logo);
//        toolbar.setNavigationIcon(R.drawable.search);
//        toolbar.setLogoDescription("Shantanu");
//        toolbar.setTitle("Hello From tool bar");
//        toolbar.setSubtitle("Hello this is my subttitle");
//        toolbar.setBackgroundColor(Color.parseColor("#689f38"));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout mToolbarLayout = (LinearLayout)getLayoutInflater().inflate(R.layout.smiley_layout, null);
        toolbar.addView(mToolbarLayout, layoutParams);
        toolbar.setLogoDescription("Shantanu");
        toolbar.setTitle("Hello From tool bar");
        toolbar.setTitleTextColor(Color.parseColor("#000000"));
        toolbar.setSubtitle("Hello this is my subttitle");
        toolbar.setBackgroundColor(Color.parseColor("#689f38"));
    }
}