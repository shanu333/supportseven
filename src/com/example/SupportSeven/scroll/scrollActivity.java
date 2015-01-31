package com.example.SupportSeven.scroll;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import com.example.SupportSeven.R;
import com.example.SupportSeven.sliding.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luffy on 1/31/2015.
 */
public class scrollActivity extends ActionBarActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    public List<MyItem> myItemList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_final);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        initialise();

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MySamplePagerAdapter());

        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setSelectedIndicatorColors(Color.CYAN, Color.BLACK, Color.BLUE);
        mSlidingTabLayout.setCustomTabView(R.layout.sliding_tab_custom_tab_view,0);
        mSlidingTabLayout.setViewPager(mViewPager);
    }
    public void initialise()
    {
        myItemList = new ArrayList<MyItem>();
        myItemList.add(new MyItem("shantanu"));
        myItemList.add(new MyItem("shantanu"));
        myItemList.add(new MyItem("shantanu"));
        myItemList.add(new MyItem("shantanu"));
        myItemList.add(new MyItem("shantanu"));
        myItemList.add(new MyItem("shantanu"));
        myItemList.add(new MyItem("shantanu"));
        myItemList.add(new MyItem("shantanu"));



    }
    public class MySamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return myItemList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return myItemList.get(position).text;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // Inflate a new layout from our resources
            View view = (View)getLayoutInflater().inflate(R.layout.sliding_pager_item, container, false);
            view.setTag("myview" + position);
            container.addView(view);
            return view;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
class MyItem
{
    String text;
    public MyItem(String text) {
        this.text = text;
    }
}
