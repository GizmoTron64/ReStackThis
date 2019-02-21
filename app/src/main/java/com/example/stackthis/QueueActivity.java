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
    private TextView headEditText;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
        Toolbar toolbar = findViewById(R.id.queueToolbar);
        setSupportActionBar(toolbar);

        headEditText = (TextView) findViewById(R.id.headEditText);
        tailEditText = (TextView) findViewById(R.id.tailEditText);
        queue = new Queue<String>();
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, queue.getList());
        queueListView = (ListView) findViewById(R.id.queueListView);
        queueListView.setAdapter(listAdapter);

        queueListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.remove(listAdapter.getItem(position));
                updateHeadTail(view);
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
        listAdapter.add(message);
        enterVal.getText().clear();
        updateHeadTail(view);
    }

    /**
     * Removes the first object in the queue
     * @param view
     */
    public void dequeue(View view) {
        if(queue.size() > 0) {
            queue.remove();
        } else {
            Toast.makeText(this, "Stack is empty", Toast.LENGTH_SHORT).show();
        }
        listAdapter.notifyDataSetChanged();
        updateHeadTail(view);
    }

    /**
     * Removes all objects from the queue
     * @param view
     */
    public void clearQueue(View view) {
        queue.clearQueue();
        listAdapter.notifyDataSetChanged();
        updateHeadTail(view);
    }

    /**
     * Shows the object at the end of the queue in a textView
     * @param view
     */
    public void tailVal(View view) {
        if(queue.size() > 0) {
            tailEditText.setText(queue.tail());
        } else {
            tailEditText.setText("");
        }
        listAdapter.notifyDataSetChanged();
    }

    /**
     * Shows the object at the front of the queue in a textView
     * @param view
     */
    public void headVal(View view) {
        if(queue.size() > 0) {
            headEditText.setText(queue.getList().get(0));
        } else {
            headEditText.setText("");
        }
        listAdapter.notifyDataSetChanged();
    }

    /**
     * Updates the head and tail textViews
     * @param view
     */
    public void updateHeadTail(View view) {
        headVal(view);
        tailVal(view);
    }

}
