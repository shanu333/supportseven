package com.example.SupportSeven.Trying;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/23/2015.
 */
public class SmileyActivity extends Activity {
    private TextView mCounter;
    private int count=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smiley_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (mCounter!=null) {
                    count++;
                    mCounter.setText("+"+Integer.toString(count));
                }
            }});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smiley_custom_menu, menu);
        RelativeLayout badgeLayout = (RelativeLayout) menu.findItem(R.id.badge).getActionView();
        mCounter = (TextView) badgeLayout.findViewById(R.id.counter);
        return true;
    }
}