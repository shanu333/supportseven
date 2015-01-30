package com.example.SupportSeven.show;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/27/2015.
 */
public class ToolCardBar extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool_card_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.card_toolbar);
        toolbar.setTitle("Card Toolbar");
        if (toolbar != null) {
            // inflate your menu
            toolbar.inflateMenu(R.menu.actionbar_with_toolbar_tool_menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    return true;
                }
            });
        }

        Toolbar maintoolbar = (Toolbar) findViewById(R.id.toolbar_main);
        if (toolbar != null) {
            // inflate your menu
            maintoolbar.inflateMenu(R.menu.smiley_custom_menu);
            maintoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    return true;
                }
            });
        }
    }
}