package com.example.tokunaga.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EditItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String itemName = getIntent().getExtras().getString("itemName");

        EditText et = (EditText) findViewById(R.id.etItem);
        et.setText(itemName);
        et.setSelection(et.getText().length());
    }

    public void onSaveItem(View v) {
        String etItemText = getEtItem();
        if (etItemText != null && !etItemText.isEmpty()){
            Intent data = getIntent();
            data.putExtra("etItemName", etItemText);
            setResult(RESULT_OK, data);
            finish();
        } else {
            Toast.makeText(this, "please enter at least one character!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event){
        if(KeyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "item not saved", Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(KeyCode, event);
    }

    public String getEtItem(){
        EditText etItem = (EditText) findViewById(R.id.etItem);
        return etItem.getText().toString();
    }

}
