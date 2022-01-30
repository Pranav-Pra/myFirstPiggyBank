package com.example.myfirstpiggybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ChildChores extends AppCompatActivity {

    ArrayList<Chore> chores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_chores);
//
//        Chore choreOne = new Chore("sweep", "use broom on floor", 5);
//        Chore choreTwo = new Chore("brush", "brush brush", 10);
//        chores.add(choreOne);
//        chores.add(choreTwo);

        LinearLayout root = (LinearLayout) findViewById(R.id.root);

        LinearLayout chore = new LinearLayout(this);
        chore.setOrientation(LinearLayout.HORIZONTAL);

//      for (int i = 0; i < chores.size(); i++) {
//
//            LinearLayout chore = new LinearLayout(this);
//            chore.setOrientation(LinearLayout.HORIZONTAL);
//
//            TextView choreName = new TextView(this);
//            choreName.setText("peepers");
//
//            TextView choreDesc = new TextView(this);
//            choreDesc.setText(chores.get(i).getDesc());
//
//            TextView choreValue = new TextView(this);
//            choreValue.setText(chores.get(i).getValue());
//
//            Button completeTaskButton = new Button(this);
//            completeTaskButton.setText("Finished Chore!");
//
//            chore.addView(choreName);
//            chore.addView(choreDesc);
//            chore.addView(choreValue);
//            chore.addView(completeTaskButton);
//
//            root.addView(chore);
//        }

    }
}