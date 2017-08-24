package com.example.tokunaga.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    private final int REQUEST_CODE = 20;    //tentative value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadList();
    }

    private void setupListViewListener() {
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapter, View item, int pos, long id) {
               String itemName = items.get(pos);

               Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
               intent.putExtra("pos", pos);
               intent.putExtra("itemName", itemName);

               startActivityForResult(intent, REQUEST_CODE);
            }
        });

        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                items.remove(pos);
                itemsAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        if (itemText != null && !itemText.isEmpty()) {
            itemsAdapter.add(itemText);
            etNewItem.setText("");
            writeItems();
        } else {
            Toast.makeText(this, "please enter at least one character!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            Bundle bundle = data.getExtras();
            String etItemName = bundle.getString("etItemName");
            int position = bundle.getInt("pos", -1);
            items.set(position, etItemName);
            writeItems();
            loadList();
        }
    }

    public void loadList(){
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<>();
        readItems();
        itemsAdapter = new ItemsAdapter(getApplicationContext());
        for (int i=0; i< items.size(); i++){
            itemsAdapter.add(items.get(i));
        }

        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
