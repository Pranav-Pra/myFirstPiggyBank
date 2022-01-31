package com.example.myfirstpiggybank;

import static com.example.myfirstpiggybank.MainActivity.firebaseHelper;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public void addUser(String username, boolean isParent, String name) {
        if(isParent) {
            Map<String, Object> userData = new HashMap<>();
            userData.put("email", username);
            db.collection("parents").document(username).set(userData)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Log.i(TAG, username + " Parent has been added");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, "Failed to sign up " + username);
                }
            });
        } else {
            FirebaseUser user = mAuth.getCurrentUser();
            Log.d("LFRA", "Current user: " + user.getUid());
            Map<String, Object> userData = new HashMap<>();
            userData.put("email", username);
            userData.put("name", name);
            db.collection("kids").document(user.getUid()).set(userData)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Log.i(TAG, username + " Child has been added");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, "Failed to sign up " + username);
                }
            });
        }
    }
}