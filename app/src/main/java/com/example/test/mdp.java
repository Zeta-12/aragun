package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class mdp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "Utilisateurs";

    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdp);
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.mail_mdp);

        Button valider = findViewById(R.id.valider);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resetemail = email.getText().toString();
                if(TextUtils.isEmpty(resetemail)){
                    Toast.makeText(mdp.this, "Please write your email adresse first...", Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.sendPasswordResetEmail(resetemail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(mdp.this, "Please check your email account !", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(mdp.this, login.class));
                            }
                            else {
                                String erreur = task.getException().getMessage();
                                Toast.makeText(mdp.this, "Erreur occured: " + erreur, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}