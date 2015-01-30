package com.example.SupportSeven.Trying;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/24/2015.
 */
public class NewLayoutActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);
        Toolbar toolbar = (Toolbar)findViewById(R.id.newToolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_with_toolbar_tool_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}