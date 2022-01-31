package com.example.myfirstpiggybank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class parent extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button choreButton, transactionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        mAuth = FirebaseAuth.getInstance();
        choreButton = findViewById(R.id.choreButton);
        transactionButton = findViewById(R.id.transactionButton);
    }

    public void signOut(View v) {
        mAuth.getInstance().signOut();

        Intent welcomeIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(welcomeIntent);

    }

    public void toChildSignUp(View v) {
        setTitle("Sign Up Child");
        setContentView(R.layout.sign_up_child);
    }

    public void toSignUpChild(View v) {
        EditText emailSignUpC = findViewById(R.id.emailSignUpChild);
        EditText passSignUpC = findViewById(R.id.passSignUpPT);
        EditText conPassSignUpC = findViewById(R.id.confirmPassSignUpPT);
        EditText nameSignUpC = findViewById(R.id.nameSignUpChild);
        String signUpEmailC = emailSignUpC.getText().toString();
        String signUpPasswordC = passSignUpC.getText().toString();
        String confirmPasswordC = conPassSignUpC.getText().toString();
        String signUpNameC = nameSignUpC.getText().toString();
        if(confirmPasswordC.equals(signUpPasswordC)){
            signUpChild(signUpEmailC,signUpPasswordC, signUpNameC);
        }
    }

    public void signUpChild(String email, String password, String name) {
        if (email != null && password != null) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent homeIntent = new Intent(getApplicationContext(), parent.class);
                                startActivity(homeIntent);
                                MainActivity.firebaseHelper.addUser(email, false, name);
                            }

                            // add more specific error messages
                            else {
                                Toast.makeText(parent.this, "Sign Up Failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("LFRA", "Error signing up error: ", e);
                }
            });
        }
    }

    public void toParentChores(View v){
        Intent intent = new Intent(this, ParentChores.class);
        startActivity(intent);
    }

}