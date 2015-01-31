package com.example.SupportSeven.sliding;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.*;
import android.widget.TextView;
import com.example.SupportSeven.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luffy on 1/28/2015.
 */
public class MainActivity extends ActionBarActivity {
    static final String LOG_TAG = "SlidingTabsBasicFragment";
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private GestureDetectorCompat mDetector;

    ActionBar actionBar;
    List<SamplePagerItem> mTabs;
    Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_fragment);
        toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        actionBar = getSupportActionBar();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        initializeItems();
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setSelectedIndicatorColors(Color.CYAN, Color.BLACK, Color.BLUE);
        mSlidingTabLayout.setCustomTabView(R.layout.sliding_tab_custom_tab_view,0);
        mSlidingTabLayout.setViewPager(mViewPager);

        //toolbar.animate().translationY(-toolbar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
//        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
//            @Override
//            public int getIndicatorColor(int position) {
//                return mTabs.get(position).indicativeColor;
//            }
//            @Override
//            public int getDividerColor(int position) {
//                return mTabs.get(position).dividerColor;
//            }
//        });

        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

    /*
     * FragmentTransaction transaction =
     * getSupportFragmentManager().beginTransaction();
     * SlidingTabsBasicFragment fragment = new SlidingTabsBasicFragment();
     * transaction.replace(R.id.sample_content_fragment, fragment);
     * transaction.commit();
     */
    }

    public void initializeItems()
    {
        mTabs = new ArrayList<SamplePagerItem>();
        mTabs.add(new SamplePagerItem("Local Train", Color.RED, Color.GREEN, R.drawable.search));
        mTabs.add(new SamplePagerItem("Local Train", Color.RED, Color.GREEN, R.drawable.search));
        mTabs.add(new SamplePagerItem("Metro", Color.BLUE, Color.GREEN, R.drawable.favorite));
//        mTabs.add(new SamplePagerItem("Mono Rail", Color.YELLOW, Color.GREEN, R.drawable.search));
//        mTabs.add(new SamplePagerItem("Bus", Color.RED, Color.GREEN, R.drawable.favorite));
//        mTabs.add(new SamplePagerItem("Items 5", Color.BLUE, Color.GREEN, R.drawable.search));
//        mTabs.add(new SamplePagerItem("Items 6", Color.YELLOW, Color.GREEN, R.drawable.search));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbar_with_toolbar_action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    public class SamplePagerAdapter extends PagerAdapter {

        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            //return 5;
            return mTabs.size();
        }

        /**
         * @return true if the value returned from
         *         {@link #instantiateItem(ViewGroup, int)} is the same object
         *         as the {@link View} added to the {@link ViewPager}.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)
        /**
         * Return the title of the item at {@code position}. This is important
         * as what this method returns is what is displayed in the
         * {@link SlidingTabLayout}.
         * <p>
         * Here we construct one using the position value, but for real
         * application the title should refer to the item's contents.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            //return "My pager Title " + (position + 1);
           // return mTabs.get(position).title;
            Drawable image = getResources().getDrawable(R.drawable.search);
            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
            SpannableString sb = new SpannableString(" " + mTabs.get(position).title);
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return sb;
        }

        public int getPageImage(int position)
        {
            return mTabs.get(position).image;

        }
        // END_INCLUDE (pageradapter_getpagetitle)

        /**
         * Instantiate the {@link View} which should be displayed at
         * {@code position}. Here we inflate a layout from the apps resources
         * and then change the text view to signify the position.
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // Inflate a new layout from our resources

            View view = (View)getLayoutInflater().inflate(R.layout.sliding_pager_item,
                    container, false);
            view.setLongClickable(true);
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    mDetector.onTouchEvent(event);

                    return false;
                }
            });

            // Add the newly created View to the ViewPager
            container.addView(view);

            // Retrieve a TextView from the inflated View, and update it's text
            TextView title = (TextView) view.findViewById(R.id.item_title);
            title.setText(String.valueOf(position + 1));

            Log.i(LOG_TAG, "instantiateItem() [position: " + position + "]");

            // Return the View
            return view;
        }

        /**
         * Destroy the item from the {@link ViewPager}. In our case this is
         * simply removing the {@link View}.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            Log.i(LOG_TAG, "destroyItem() [position: " + position + "]");
        }

    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";
        private VelocityTracker mVelocityTracker = null;
        static final int SWIPE_MIN_DISTANCE = 120;
        static final int SWIPE_MAX_OFF_PATH = 150;
        static final int SWIPE_THRESHOLD_VELOCITY = 100;

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d(DEBUG_TAG,"onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
//            if (actionBar.isShowing()) {
//                actionBar.hide();
//                toolbar.findViewById(R.id.toolbar_layout_containing_buttons).setVisibility(View.GONE);
//            } else {
//                actionBar.show();
//                toolbar.findViewById(R.id.toolbar_layout_containing_buttons).setVisibility(View.VISIBLE);
//            }
//            return true;
//            if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
//                if (Math.abs(event1.getX() - event2.getX()) > SWIPE_MAX_OFF_PATH
//                        || Math.abs(velocityY) < SWIPE_THRESHOLD_VELOCITY) {
//                    return false;
//                }
//                if (event1.getY() - event2.getY() > SWIPE_MIN_DISTANCE) {
//                   // listener.onBottomToTop();
//                    if (actionBar.isShowing()) {
//                        actionBar.hide();
//                        toolbar.findViewById(R.id.toolbar_layout_containing_buttons).setVisibility(View.GONE);
//                    }
//                } else if (event2.getY() - event1.getY() > SWIPE_MIN_DISTANCE) {
//                    //listener.onTopToBottom();
//                    if (!actionBar.isShowing()) {
//                        actionBar.show();
//                        toolbar.findViewById(R.id.toolbar_layout_containing_buttons).setVisibility(View.VISIBLE);
//                    }
//                }
//            } else {
//                if (Math.abs(velocityX) < SWIPE_THRESHOLD_VELOCITY) {
//                    return false;
//                }
//                if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE) {
//                    //listener.onRightToLeft();
//                } else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE) {
//                    //listener.onLeftToRight();
//                }
//            }
            return true;

        }

        @Override
        public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
            float _distanceScrolledInYDirection = event1.getY() - event2.getY();

            return super.onScroll(event1, event2, distanceX, distanceY);
        }
    }

}
class SamplePagerItem
{
    String title;
    int indicativeColor;
    int dividerColor;
    int image;
    public SamplePagerItem(String title, int indicativeColor, int dividerColor, int image) {
        this.dividerColor = dividerColor;
        this.indicativeColor = indicativeColor;
        this.title = title;
        this.image = image;
    }

}
