package com.example.SupportSeven.sliding;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by Luffy on 1/29/2015.
 */
public class MySlidingTabLayout extends SlidingTabLayout {
    SlidingTabStrip mTabStrip;
    MainActivity.SamplePagerAdapter adapter;
    public MySlidingTabLayout(Context context) {
        super(context);
    }

    public MySlidingTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySlidingTabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    public void setViewPager(ViewPager viewPager) {
        super.setViewPager(viewPager);
//        mTabStrip = getmTabStrip();
//        TextView textView;
//
//        adapter = (MainActivity.SamplePagerAdapter)viewPager.getAdapter();
//        for (int i = 0; i < adapter.getCount(); i++) {
//            textView = (TextView)mTabStrip.getChildAt(i);
//            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(adapter.getPageImage(i), 0, 0, 0);
//        }
//        viewPager.setOnPageChangeListener(new InternalViewPagerListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                int tabStripChildCount = mTabStrip.getChildCount();
//                if ((tabStripChildCount == 0) || (position < 0) || (position >= tabStripChildCount)) {
//                    return;
//                }
//                mTabStrip.onViewPagerPageChanged(position, positionOffset);
//                View selectedTitle = mTabStrip.getChildAt(position);
//                int extraOffset = (selectedTitle != null)
//                        ? (int) (positionOffset * selectedTitle.getWidth())
//                        : 0;
//                scrollToTab(position, extraOffset);
//                if (mViewPagerPageChangeListener != null) {
//                    mViewPagerPageChangeListener.onPageScrolled(position, positionOffset,
//                            positionOffsetPixels);
//                }
//                TextView textView;
//                for (int i = 0; i < adapter.getCount(); i++) {
//                    textView = (TextView)mTabStrip.getChildAt(i);
//                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.favorite, 0, 0, 0);
//                }
//                textView = (TextView)mTabStrip.getChildAt(position);
//                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.favorite1, 0, 0, 0);
//            }
//
//        });
    }
}
