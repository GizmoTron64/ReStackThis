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

public class QueueActivity extends AppCompatActivity {

    private Queue<String> queue;
    private ListView queueListView;
    private EditText enterVal;
    private TextView tailEditText;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
        Toolbar toolbar = findViewById(R.id.queueToolbar);
        setSupportActionBar(toolbar);

        tailEditText = (TextView) findViewById(R.id.tailEditText);
        queue = new Queue<String>();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, queue);
        queueListView = (ListView) findViewById(R.id.queueListView);
        queueListView.setAdapter(listAdapter);
        updateTail();

        queueListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.remove(listAdapter.getItem(position));
                updateTail();
                listAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * Adds an object to the end of the queue
     * @param view
     */
    public void enqueue(View view) {
        enterVal = (EditText) findViewById(R.id.queueEnterVal);
        String message = enterVal.getText().toString();

        if(!message.isEmpty()) {
            listAdapter.add(message);
            enterVal.getText().clear();
            updateTail();
            listAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Enter a value", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Removes the first object in the queue
     * @param view
     */
    public void dequeue(View view) {
        if(!queue.isEmpty()) {
            queue.dequeue();
            listAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Stack is empty", Toast.LENGTH_SHORT).show();
        }
        updateTail();
    }

    /**
     * Removes all objects from the queue
     * @param view
     */
    public void clearQueue(View view) {
        if(!queue.isEmpty()) {
            queue.clear();
            listAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Stack is empty", Toast.LENGTH_SHORT).show();
        }
        updateTail();
    }

    /**
     * Shows the object at the end of the queue in a textView
     */
    public void updateTail() {
        tailEditText.setText(queue.tail());

    }


}
