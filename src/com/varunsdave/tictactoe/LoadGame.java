package com.varunsdave.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LoadGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.load_game, menu);
        return true;
    }
    
}
