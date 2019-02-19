package com.example.stackthis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Stack;

public class StackActivity extends AppCompatActivity {

    private ListView myListView;
    private Stack stack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        //Store data field object.
        myListView = (ListView)findViewById(R.id.my_list_view);

//        //An arraylist that contains the items to be displayed.
//        ArrayList<String> myListItems = new ArrayList<String>();
//        myListItems.add("Hello");
//        myListItems.add("world");
//        myListItems.add("!!");


        stack = new Stack();
        stack.push(5);

        //Create an arrayadapter. The listview needs this.
        final ArrayAdapter myArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stack);

        //Set the adapter for the listview.
        myListView.setAdapter(myArrayAdapter);

        //Set an event listener: what happens when an item on the listview is clicked.
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }



}
