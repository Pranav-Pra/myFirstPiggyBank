package com.example.myfirstpiggybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChildTransaction extends AppCompatActivity {

    private EditText itemET, costET, dateET;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_transaction);
        itemET = findViewById(R.id.itemET);
        costET = findViewById(R.id.costET);
        dateET = findViewById(R.id.dateET);
        submitBtn = findViewById(R.id.buyBtn);
    }

    public void submitTransaction(View v){
        
    }
}