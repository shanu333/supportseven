package com.example.SupportSeven.show;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/23/2015.
 */
public class ActionBarWithToolBar extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitonbar_with_toolbar);
        Toolbar toolbar =(Toolbar)findViewById(R.id.myAwesomeToolbar);

        toolbar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle the menu item
                return true;
            }
        });
        //toolbar.setBackgroundColor(Color.parseColor());
        //toolbar.inflateMenu(R.menu.actionbar_with_toolbar_tool_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_with_toolbar_action_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);

        // When using the support library, the setOnActionExpandListener() method is
        // static and accepts the MenuItem object as an argument
        MenuItemCompat.setOnActionExpandListener(menuItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                Toast.makeText(ActionBarWithToolBar.this, "collapsed ", Toast.LENGTH_SHORT).show();
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                Toast.makeText(ActionBarWithToolBar.this, "Expanded ", Toast.LENGTH_SHORT).show();
                return true;  // Return true to expand action view
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        Log.d("MYMY", "Something something");
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "action search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_compose:
                Toast.makeText(this, "compose message", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this, item.getItemId() + " selected", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }

}