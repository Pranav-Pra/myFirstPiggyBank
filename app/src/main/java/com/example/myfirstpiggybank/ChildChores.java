package com.example.myfirstpiggybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ChildChores extends AppCompatActivity {

    ArrayList<Chore> chores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_chores);

        Chore choreOne = new Chore("sweep", "use broom on floor", 5);
        Chore choreTwo = new Chore("brush", "brush brush", 10);
        chores.add(choreOne);
        chores.add(choreTwo);
    }
}