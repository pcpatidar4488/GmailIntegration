package com.example.pc.gmailintegration;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;

public class SignOutActivity extends AppCompatActivity {

    Button mSignOut;
    TextView mName;
    TextView mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);

        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mSignOut = (Button) findViewById(R.id.sign_out);
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        mName.setText(name);
        mEmail.setText(email);
        mSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    private void signOut() {
        SignInActivity.mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println(task);
                        task.getResult();
                        finish();
                    }
                });
    }

    private void revokeAccess() {
        SignInActivity.mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println(task);
                        task.getResult();
                    }
                });
    }
}
