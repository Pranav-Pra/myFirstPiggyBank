package com.example.myfirstpiggybank;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class FirebaseHelper {
    public final String TAG = "MEGAN";
    private static String uid = null;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private ArrayList<Chore> chores = new ArrayList<>();

    public FirebaseHelper(){
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }


}
