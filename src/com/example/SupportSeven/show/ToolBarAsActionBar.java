package com.example.SupportSeven.show;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/23/2015.
 */
public class ToolBarAsActionBar extends ActionBarActivity {
    Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.acitonbar_with_toolbar);
        setContentView(R.layout.tool_bar_as_action_bar);
        initialiseToolbar();
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_with_toolbar_tool_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void initialiseToolbar()
    {
        toolbar = (Toolbar)findViewById(R.id.myAwesomeToolbar);
        toolbar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle the menu item
                Toast.makeText(ToolBarAsActionBar.this, "you clicked a toolbar item", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        toolbar.setTitle("Toolbar");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageView imageView = (ImageView)toolbar.findViewById(R.id.myAwesomeToolbarFav);
        if(imageView == null){
            Log.d("MYMY", "oh god not now");
        } else {
            imageView.setImageResource(R.drawable.icon);
        }
       // toolbar.getMenu().getItem(R.id.Book).setActionView(android.support.v7.widget.SearchView);

    }
}