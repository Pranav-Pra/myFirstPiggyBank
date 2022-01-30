package com.example.myfirstpiggybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ParentChores extends AppCompatActivity {

    private EditText choreET, descET, valueET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_chores);
        choreET = findViewById(R.id.choreET);
        descET = findViewById(R.id.descET);
        valueET = findViewById(R.id.valueET);
    }

    public void addChore(View v){

    }
}