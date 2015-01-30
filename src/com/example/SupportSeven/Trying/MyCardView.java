package com.example.SupportSeven.Trying;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/28/2015.
 */
public class MyCardView extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_cardview_layout);
        Button button = (Button)findViewById(R.id.cardViewButtonOne);
//        ViewCompat.setElevation(button, 10);
    }

}