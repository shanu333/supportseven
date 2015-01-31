package com.example.SupportSeven.Trying;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.SupportSeven.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luffy on 1/30/2015.
 */
public class SimpleMovement extends ActionBarActivity {
    Toolbar toolbarOne;
    Toolbar toolbarTwo;
    private GestureDetectorCompat mDetector;
    LinearLayout simpleLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // doOne();
        doTwo();

    }

    void doTwo()
    {
        setContentView(R.layout.new_test_xml);
        ListView lv = (ListView) findViewById(R.id.list);

        List<String> items = new ArrayList<String>();
        for(int i = 0; i < 100; i++) {
            items.add("" + i);
        }

        String[] itemArray = new String[items.size()];

        lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, items.toArray(itemArray)));
    }

    void doOne() {
        setContentView(R.layout.simple_movement);
        simpleLayout = (LinearLayout)findViewById(R.id.simple_layout);
        toolbarOne = (Toolbar)findViewById(R.id.mySimpleToolBarOne);
        toolbarOne.setScrollbarFadingEnabled(true);
        toolbarOne.inflateMenu(R.menu.actionbar_with_toolbar_tool_menu);
        toolbarTwo = (Toolbar)findViewById(R.id.mySimpleToolBarTWO);
        toolbarTwo.inflateMenu(R.menu.actionbar_with_toolbar_action_menu);
        final Button button = (Button)findViewById(R.id.button2);
//        simpleLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                //mDetector.onTouchEvent(event);
//                final int action = MotionEventCompat.getActionMasked(event);
//                identify(action);
//                return false;
//            }
//        });
        button.setOnTouchListener(new View.OnTouchListener() {
            int _moveBy = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)toolbarOne.getLayoutParams();
                _moveBy -= 10;
                params.setMargins(0, _moveBy, 0 , 0);
                toolbarOne.setLayoutParams(params);
                toolbarOne.invalidate();
                return false;
            }
        });
        mDetector = new GestureDetectorCompat(this, new MyGestureListenerOne());
    }
    public void identify(int action) {
//        switch (action) {
//            case MotionEvent.ACTION_DOWN: {
//                final int pointerIndex = MotionEventCompat.getActionIndex(ev);
//                final float x = MotionEventCompat.getX(ev, pointerIndex);
//                final float y = MotionEventCompat.getY(ev, pointerIndex);
//
//                // Remember where we started (for dragging)
//                mLastTouchX = x;
//                mLastTouchY = y;
//                // Save the ID of this pointer (for dragging)
//                mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
//                break;
//            } case MotionEvent.ACTION_MOVE: {
//                // Find the index of the active pointer and fetch its position
//                final int pointerIndex =
//                        MotionEventCompat.findPointerIndex(ev, mActivePointerId);
//
//                final float x = MotionEventCompat.getX(ev, pointerIndex);
//                final float y = MotionEventCompat.getY(ev, pointerIndex);
//
//                // Calculate the distance moved
//                final float dx = x - mLastTouchX;
//                final float dy = y - mLastTouchY;
//
//                mPosX += dx;
//                mPosY += dy;
//
//                invalidate();
//
//                // Remember this touch position for the next move event
//                mLastTouchX = x;
//                mLastTouchY = y;
//
//                break;
//            } case MotionEvent.ACTION_UP: {
//                mActivePointerId = INVALID_POINTER_ID;
//                break;
//            }
//
//            case MotionEvent.ACTION_CANCEL: {
//                mActivePointerId = INVALID_POINTER_ID;
//                break;
//            }
//
//            case MotionEvent.ACTION_POINTER_UP: {
//
//                final int pointerIndex = MotionEventCompat.getActionIndex(ev);
//                final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
//
//                if (pointerId == mActivePointerId) {
//                    // This was our active pointer going up. Choose a new
//                    // active pointer and adjust accordingly.
//                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
//                    mLastTouchX = MotionEventCompat.getX(ev, newPointerIndex);
//                    mLastTouchY = MotionEventCompat.getY(ev, newPointerIndex);
//                    mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
//                }
//                break;
//            }
//        }
    }
    class MyGestureListenerOne extends GestureDetector.SimpleOnGestureListener {

        int haha = 0;
        int _moveBy = 0;
        private void move() {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)toolbarOne.getLayoutParams();
            _moveBy -= 10;
            params.setMargins(0, _moveBy, 0 , 0);
            toolbarOne.setLayoutParams(params);
            toolbarOne.invalidate();
        }
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        public void onLongPress(MotionEvent e) {
            Log.d("mymy", "longPress " + haha++);
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d("mymy", "OnScroll"+ haha++);
            return false;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("mymy", "onFling"+ haha++);
            return false;
        }

        public void onShowPress(MotionEvent e) {
            Log.d("mymy", "onShowPress"+ haha++);
        }

        public boolean onDown(MotionEvent e) {
            Log.d("mymy", "onDown"+ haha++);
            return false;
        }

        public boolean onDoubleTap(MotionEvent e) {
            Log.d("mymy", "onDOubleTap"+ haha++);
            return false;
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("mymy", "onDoubleTapEvent"+ haha++);
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d("mymy", "singleTapConfirmed"+ haha++);
            return false;
        }


    }
}