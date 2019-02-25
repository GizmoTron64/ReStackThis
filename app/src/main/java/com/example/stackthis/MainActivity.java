package com.example.stackthis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    /**
     * Home page of app with links to the three functions
     * @param savedInstanceState
     */

    /**
     * Initialises Home page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Links to Stack Activity
     * @param view
     */
    public void startStack(View view) {
        Intent stack = new Intent(this, StackActivity.class);
        startActivity(stack);
    }

    /**
     * Links to Queue Activity
     * @param view
     */
    public void startQueue(View view) {
        Intent queue = new Intent(this, QueueActivity.class);
        startActivity(queue);
    }

    /**
     * Links to Search Activity
     * @param view
     */
    public void startSearch(View view) {
        Intent intent = new Intent(this, ListSearchActivity.class);
        startActivity(intent);
    }
}



