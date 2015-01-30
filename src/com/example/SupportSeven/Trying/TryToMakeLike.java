package com.example.SupportSeven.Trying;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import com.example.SupportSeven.R;

/**
 * Created by Luffy on 1/24/2015.
 */
public class TryToMakeLike extends ActionBarActivity {
    Toolbar toolbar;
    ActionBar actionbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.try_to_make_it);
        actionbar = getSupportActionBar();
        if(actionbar!= null) {
            actionbar.setHomeButtonEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setDisplayShowTitleEnabled(true);
        }
        initialiseToolbarSecond();
    }

    public void initialiseToolbarSecond()
    {
        toolbar = (Toolbar)findViewById(R.id.tryingToolbar);

    }
    public void initialiseToolbar()
    {
        toolbar = (Toolbar)findViewById(R.id.tryingToolbar);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                // Handle the menu item
//                // Toast.makeText(ToolBarAsActionBar.this, "you clicked a toolbar item", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//        toolbar.inflateMenu(R.menu.actionbar_with_toolbar_tool_menu);

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View v) {
//                // Handle your drawable state here
//               // materialMenu.animatePressedState(newState);
//            }
//        });
        //toolbar.setNavigationIcon(R.drawable.smiley);
       // materialMenu = new MaterialMenuDrawable(this, Color.WHITE, Stroke.THIN);
        //toolbar.setNavigationIcon(materialMenu);
       // materialMenu.setNeverDrawTouch(true);
       // toolbar.setTitle("Activity");
        //toolbar.setLogo(R.drawable.icon);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  setSupportActionBar(toolbar);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_with_toolbar_action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}