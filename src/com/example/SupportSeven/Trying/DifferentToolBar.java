package com.example.SupportSeven.Trying;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/24/2015.
 */
public class DifferentToolBar extends ActionBarActivity {
    Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitonbar_with_toolbar);
         toolbar = (Toolbar)findViewById(R.id.myAwesomeToolbar);
        //toolbar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 400));
       // toolbar.inflateMenu(R.menu.actionbar_with_toolbar_tool_menu);
        //setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater menuInflater = getMenuInflater();
        //menuInflater.inflate(R.menu.actionbar_with_toolbar_tool_menu, menu);
        setSupportActionBar(toolbar);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}