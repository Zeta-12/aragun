package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class inscription extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "Utilisateurs";

    EditText email = findViewById(R.id.mail);
    EditText pseudo = findViewById(R.id.pseudo);
    EditText password = findViewById(R.id.pwd);
    EditText passwordConf = findViewById(R.id.pwdConf);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        Button inscription = findViewById(R.id.button);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(email.getText().toString(), pseudo.getText().toString(),
                        password.getText().toString(), passwordConf.getText().toString());
            }
        });

    }
    /*
    @Override
    public void onStart() {
        super.onStart();

        // Check auth on Activity start
        if (mAuth.getCurrentUser() != null) {
            reload();
        }
    }*/

    private void createAccount(String email, String pseudo, String password, String passwordConf) {
        Log.d(TAG, "signIn");
        if (!validateForm()) {
            return;
        }

        if(validateForm() && password.equals(passwordConf)){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "createUser:onComplete:" + task.isSuccessful());

                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent appel = new Intent(inscription.this, login.class);
                                startActivity(appel);
                            } else {
                                Toast.makeText(inscription.this, "Sign Up Failed",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                    });
        }
    }

    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(email.getText().toString())) {
            email.setError("Required");
            result = false;
        } else {
            email.setError(null);
        }

        if (TextUtils.isEmpty(pseudo.getText().toString())) {
            pseudo.setError("Required");
            result = false;
        } else {
            pseudo.setError(null);
        }

        if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Required");
            result = false;
        } else {
            password.setError(null);
        }

        if (TextUtils.isEmpty(passwordConf.getText().toString())) {
            passwordConf.setError("Required");
            result = false;
        } else {
            passwordConf.setError(null);
        }

        return result;
    }
    private void reload() { }

    private void updateUI(FirebaseUser user) {

    }
}