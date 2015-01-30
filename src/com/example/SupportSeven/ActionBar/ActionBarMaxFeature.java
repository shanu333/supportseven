package com.example.SupportSeven.ActionBar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/24/2015.
 */
public class ActionBarMaxFeature extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smiley_main);
        //ActionBar actionBar = getActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//
//        // Spinner title navigation data
//        ArrayList<SpinnerNavItem> navSpinner = new ArrayList<SpinnerNavItem>();
//        navSpinner.add(new SpinnerNavItem("Local", R.drawable.ic_location));
//        navSpinner.add(new SpinnerNavItem("My Places", R.drawable.ic_my_places));
//        navSpinner.add(new SpinnerNavItem("Checkins", R.drawable.ic_checkin));
//        navSpinner.add(new SpinnerNavItem("Latitude", R.drawable.ic_latitude));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_max_feature, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        Toast.makeText(ActionBarMaxFeature.this, item.getTitle()+ "", Toast.LENGTH_LONG ).show();
        switch (item.getItemId()) {
            case R.id.action_search:
                // search action
                return true;
            case R.id.action_location_found:
                // location found

                return true;
            case R.id.action_refresh:
                // refresh
                return true;
            case R.id.action_help:
                // help action
                return true;
            case R.id.action_check_updates:
                // check for updates action
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}