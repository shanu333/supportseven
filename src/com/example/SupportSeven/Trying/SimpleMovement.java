package com.example.SupportSeven.Trying;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.SupportSeven.R;

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
        setContentView(R.layout.simple_movement);
        simpleLayout = (LinearLayout)findViewById(R.id.simple_layout);
        toolbarOne = (Toolbar)findViewById(R.id.mySimpleToolBarOne);
        toolbarOne.inflateMenu(R.menu.actionbar_with_toolbar_tool_menu);
        toolbarTwo = (Toolbar)findViewById(R.id.mySimpleToolBarTWO);
        toolbarTwo.inflateMenu(R.menu.actionbar_with_toolbar_action_menu);
        final Button button = (Button)findViewById(R.id.button2);
        simpleLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return false;
            }
        });
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