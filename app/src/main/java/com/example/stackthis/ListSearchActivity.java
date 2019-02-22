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

public class ListSearchActivity extends AppCompatActivity {

    private ListSearch listSearch;
    private ArrayAdapter listAdapter;
    private ListView searchListView;
    private EditText searchEditText;
    private TextView searchingEditText;
    private TextView resultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_search);
        Toolbar toolbar = findViewById(R.id.listSearchToolbar);
        setSupportActionBar(toolbar);

        listSearch = new ListSearch();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSearch);

        searchEditText = findViewById(R.id.searchEditText);
        searchingEditText = findViewById(R.id.searchingEditText);
        resultEditText = findViewById(R.id.resultEditText);
        searchListView = findViewById(R.id.searchListView);
        searchListView.setAdapter(listAdapter);

        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.remove(listAdapter.getItem(position));
                listAdapter.notifyDataSetChanged();
            }
        });
    }

    public void autofill(View view) {
        listSearch.fillList();
        listAdapter.notifyDataSetChanged();
    }

    public void search(View view) {
        String message = searchEditText.getText().toString();
        searchingEditText.setText(message);

        if(listSearch.indexOf(message) >= 0) {
            String index = Integer.toString(listSearch.indexOf(message));
            resultEditText.setText(index);
        } else {
            Toast.makeText(this, "What you were searching for does not belong here", Toast.LENGTH_SHORT).show();
        }
        searchEditText.getText().clear();
    }


}
