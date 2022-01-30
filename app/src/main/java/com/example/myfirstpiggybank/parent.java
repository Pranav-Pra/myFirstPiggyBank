package com.example.myfirstpiggybank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class parent extends AppCompatActivity {

    private Button choreButton, transactionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        choreButton = findViewById(R.id.choreButton);
        transactionButton = findViewById(R.id.transactionButton);
    }

    public void toParentChores(View v){
        Intent intent = new Intent(this, ParentChores.class);
        startActivity(intent);
    }

}