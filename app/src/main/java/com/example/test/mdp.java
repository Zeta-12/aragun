package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

        email = findViewById(R.id.email_mdp);

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
                            
                        }
                    })
                }
            }
        });
    }

    private void changePassword(String email, String password, String repassword) {
        Log.d(TAG, "signIn");
        if (!validateForm()) {
            return;
        }

        /*https://www.youtube.com/watch?v=0-DRdI_xpvQ&ab_channel=CodingCafe*/

        if(validateForm() && password.equals(repassword)) {
            mAuth.getCurrentUser().updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Password updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("Password Update", task.getException() + "");
                        Toast.makeText(getApplicationContext(), "Password update failed", Toast.LENGTH_SHORT).show();
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

        if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Required");
            result = false;
        } else {
            password.setError(null);
        }

        if (TextUtils.isEmpty(repassword.getText().toString())) {
            repassword.setError("Required");
            result = false;
        } else {
            repassword.setError(null);
        }

        return result;
    }
}