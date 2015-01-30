package com.example.SupportSeven.Trying;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.*;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/27/2015.
 */
public class TryToMakeItLikeVersionTwo extends ActionBarActivity implements ActionBar.TabListener{
    Toolbar toolbar;
    ActionBar actionbar;
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;
    ViewPager mViewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.try_to_make_it_two);
        initialiseActionBar();
        setUpTabs();
        initialiseToolbarSecond();
    }

    public void setUpTabs() {
        // Create the adapter that will return a fragment for each of the three
        // primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(
                getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager, attaching the adapter and setting up a listener
        // for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.myViewPager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between different app sections, select
                        // the corresponding tab.
                        // We can also use ActionBar.Tab#select() to do this if
                        // we have a reference to the
                        // Tab.
                        actionBar.setSelectedNavigationItem(position);
                    }
                });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter.
            // Also specify this Activity object, which implements the
            // TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(actionBar.newTab()
                    .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                    .setTabListener(this));
        }
    }

    public void initialiseToolbarSecond()
    {
        toolbar = (Toolbar)findViewById(R.id.tryingToolbar);
    }
    public void initialiseActionBar()
    {
        actionbar = getSupportActionBar();
        if(actionbar!= null) {
            actionbar.setHomeButtonEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setDisplayShowTitleEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //  setSupportActionBar(toolbar);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_with_toolbar_action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
        Log.d("MYMY", "Selected tab number " + tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    /**
    * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
    * one of the primary sections of the app.
    */
    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new MyFragment();
                default:
                    Fragment fragment = new MyFragment();
                    return fragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section " + (position + 1);
        }
    }


}
class MyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
