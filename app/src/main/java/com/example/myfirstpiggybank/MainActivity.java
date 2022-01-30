package com.example.myfirstpiggybank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

            //add if statement to determine if parent or child
            Intent homeIntent = new Intent(getApplicationContext(), parent.class);
            startActivity(homeIntent);
        }
    }
    public void toLogin(View v){
        setTitle("Log In");
        setContentView(R.layout.sign_in);
    }

    public void toSignUp(View V){
        setTitle("Sign Up");
        setContentView(R.layout.sign_up);

    }
    public void accessAccount(View v){
        switch(v.getId()){
            case R.id.parentSignUpButton:
                EditText emailSignUpP = findViewById(R.id.emailSignUpPT);
                EditText passSignUpP = findViewById(R.id.passSignUpPT);
                EditText conPassSignUpP = findViewById(R.id.confirmPassSignUpPT);

                String signUpEmailP = emailSignUpP.getText().toString();
                String signUpPasswordP = passSignUpP.getText().toString();
                String confirmPasswordP = conPassSignUpP.getText().toString();
                if(confirmPasswordP.equals(signUpPasswordP)) {
                    signUpParent(signUpEmailP, signUpPasswordP);
                }
                break;
            case R.id.childSignUpButton:
                EditText emailSignUpC = findViewById(R.id.emailSignUpPT);
                EditText passSignUpC = findViewById(R.id.passSignUpPT);
                EditText conPassSignUpC = findViewById(R.id.confirmPassSignUpPT);

                String signUpEmailC = emailSignUpC.getText().toString();
                String signUpPasswordC = passSignUpC.getText().toString();
                String confirmPasswordC = conPassSignUpC.getText().toString();
                if(confirmPasswordC.equals(signUpPasswordC)){
                    signUpChild(signUpEmailC,signUpPasswordC);
                }
                break;
            case R.id.signInButton:
                EditText emailSignIn = findViewById(R.id.emailSignInPT);
                EditText passSignIn = findViewById(R.id.passSignInPT);
                String loginEmail = emailSignIn.getText().toString();
                String loginPassword = passSignIn.getText().toString();
                signIn(loginEmail,loginPassword);
                break;
        }
    }

    public void signUpParent(String email, String password) {

        if (email != null && password != null) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent homeIntent = new Intent(getApplicationContext(), parent.class);
                                startActivity(homeIntent);
                            }

                            // add more specific error messages
                            else {
                                Toast.makeText(MainActivity.this, "Sign Up Failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
    public void signUpChild(String email, String password) {

        if (email != null && password != null) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent homeIntent = new Intent(getApplicationContext(), child.class);
                                startActivity(homeIntent);
                            }

                            // add more specific error messages
                            else {
                                Toast.makeText(MainActivity.this, "Sign Up Failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //add if statement to determine if parent or child
                            Intent homeIntent = new Intent(getApplicationContext(), parent.class);
                            startActivity(homeIntent);

                        }
                        // add more specific error messages
                        else {
                            Toast.makeText(MainActivity.this, "Login Failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}