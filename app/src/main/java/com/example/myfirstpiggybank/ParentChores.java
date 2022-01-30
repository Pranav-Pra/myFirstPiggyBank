package com.example.myfirstpiggybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ParentChores extends AppCompatActivity {

    private EditText choreET, descET, valueET;
    private String chore, desc;
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_chores);
        choreET = findViewById(R.id.choreET);
        descET = findViewById(R.id.descET);
        valueET = findViewById(R.id.valueET);
    }

    public void addChore(View v){
        chore = choreET.getText().toString();
        desc = descET.getText().toString();
        value = Integer.parseInt(valueET.getText().toString());
        Chore choreTask = new Chore(chore, desc, value);

    }
}