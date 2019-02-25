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
    /**
     * Activity for a linear search of a list
     */
    private ListSearch listSearch;
    private ArrayAdapter listAdapter;
    private ListView searchListView;
    private EditText searchEditText;
    private TextView searchingEditText;
    private TextView resultEditText;
    private TextView indexEditText;
    private int slowSearchIndex;

    /**
     * Initialises a full list
     * @param savedInstanceState
     */
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
        searchingEditText = findViewById(R.id.searchingEditText);
        indexEditText = findViewById(R.id.indexEditText);
        resultEditText = findViewById(R.id.resultEditText);
        searchListView = findViewById(R.id.searchListView);
        searchListView.setAdapter(listAdapter);
        slowSearchIndex = 0;

        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.remove(listAdapter.getItem(position));
                listAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * Getter for slowSearchIndex
     * @return current Index of slowSearch function
     */
    public int getSlowSearchIndex() {
        return slowSearchIndex;
    }

    /**
     * Setter for slowSearchIndex
     * @param slowSearchIndex current Index of slowSearch function
     */
    public void setSlowSearchIndex(int slowSearchIndex) {
        this.slowSearchIndex = slowSearchIndex;
    }

    /**
     * Fills the list with random numbers in ascending order when Autofill button is pressed
     * @param view
     */
    public void autofill(View view) {
        clearText();
        listSearch.clear();
        listSearch.fillList();
        listAdapter.notifyDataSetChanged();
    }

    /**
     * Searches list for first instance of match with input value when Search button is pressed
     * @param view
     */
    public void search(View view) {
        String input = searchEditText.getText().toString();
        clearText();

        if(!input.isEmpty()) {
            searchingEditText.setText(input);
            int searchInt = listSearch.indexOf(Integer.parseInt(input));

            if (searchInt >= 0) {
                String index = Integer.toString(searchInt);
                resultEditText.setText(index);

            } else {
                toast404();
            }
            searchEditText.getText().clear();
        } else {
            toastNoInput();
        }
    }

    /**
     * Searches list one index at a time when Slow Search button is pressed
     * @param view
     */
    public void slowSearch(View view) {
        resultEditText.setText("");
        String input = searchEditText.getText().toString();

        if(!input.isEmpty()) {
            searchingEditText.setText(input);
            int inputInt = Integer.parseInt(input);
            String index = Integer.toString(slowSearchIndex);
            indexEditText.setText(index);

            if ((int) listSearch.get(slowSearchIndex) == inputInt) {
                resultEditText.setText(index);
                searchEditText.getText().clear();
                indexEditText.setText("");
                slowSearchIndex = 0;
            } else if((slowSearchIndex >= listSearch.size() -1) || ((int) listSearch.get(slowSearchIndex) > inputInt)){
                toast404();
            } else {
                slowSearchIndex++;
            }
        } else {
            toastNoInput();
        }
    }

    /**
     * Clears all text boxes and resets the slowSearchIndex
     */
    public void clearText() {
        searchEditText.setText("");
        searchingEditText.setText("");
        indexEditText.setText("");
        resultEditText.setText("");
        slowSearchIndex = 0;
    }

    /**
     * Clears all text boxes and resets the slowSearchIndex when Clear button is pressed
     * @param view
     */
    public void clearText(View view) {
        clearText();
    }

    /**
     * Shows toast message when a match cannot be found
     */
    public void toast404() {
        Toast.makeText(this, "What you were searching for does not belong here", Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows toast message when no input value is entered
     */
    public void toastNoInput() {
        Toast.makeText(this, "Enter a value", Toast.LENGTH_SHORT).show();
    }

}
