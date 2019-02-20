package com.example.stackthis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class QueueActivity extends AppCompatActivity {

    private Queue queue;
    private ListView queueListView;
    private EditText enterVal;
    private TextView tailTextView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
        Toolbar toolbar = findViewById(R.id.queueToolbar);
        setSupportActionBar(toolbar);

        queue = new Queue();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) queue);
        queueListView.setAdapter(listAdapter);

        queueListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.remove(listAdapter.getItem(position));
            }
        });
    }

    public void enqueue(View view) {

    }

    public void dequeue(View view) {

    }

    public void clearQueue(View view) {
        queue.clearQueue();
        listAdapter.notifyDataSetChanged();
        tailVal(view);
    }

    public void tailVal(View view) {
        tailTextView = (TextView) findViewById(R.id.tailTextView);
        if(queue.size() > 0) {
            tailTextView.setText(queue.tail().toString());
        } else {
            tailTextView.setText("");
        }
        listAdapter.notifyDataSetChanged();
    }

}
