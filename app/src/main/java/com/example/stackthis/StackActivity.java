package com.example.stackthis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class StackActivity extends AppCompatActivity {

    private ListView stackListView;
    private Stack stack;
    private EditText enterVal;
    private TextView topTextView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        Toolbar toolbar = findViewById(R.id.stackToolbar);
        setSupportActionBar(toolbar);

        stack = new Stack();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stack);
        stackListView = (ListView) findViewById(R.id.stackListView);
        stackListView.setAdapter(listAdapter);

        //Set an event listener: what happens when an item on the listview is clicked.
        stackListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.remove(listAdapter.getItem(position));
                topVal(view);
            }
        });


    }

    /**
     * Adds a value to the end of the stack
     * @param view
     */
    public void pushVal(View view) {
        enterVal = (EditText) findViewById(R.id.stackEnterVal);
        String message = enterVal.getText().toString();
        listAdapter.add(message);
        enterVal.getText().clear();
        topVal(view);
    }

    /**
     * Removes the last value in the stack
     * @param view
     */
    public void popVal(View view) {
        if(stack.size() > 0) {
            stack.pop();
        } else {
            Toast.makeText(this, "Stack is empty", Toast.LENGTH_SHORT).show();
        }
        listAdapter.notifyDataSetChanged();
        topVal(view);
    }

    /**
     * Shows the value at the top of the stack in a textView
     * @param view
     */
    public void topVal(View view) {
        topTextView = (TextView) findViewById(R.id.topTextView);
        if(stack.size() > 0) {
            topTextView.setText(stack.peek().toString());
        } else {
            topTextView.setText("");
        }
        listAdapter.notifyDataSetChanged();
    }


    /**
     * Removes all objects from the stack
     * @param view
     */
    public void clearStack(View view) {
        stack.clear();
        listAdapter.notifyDataSetChanged();
        topVal(view);
    }



}
