package ui.ggpm.college;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
EditText login_pw;
EditText login_email;
Button signin;
TextView signup;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        login_email=findViewById(R.id.login_email);
        login_pw=findViewById(R.id.login_pw);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        FirebaseApp.initializeApp(LoginActivity.this);
        auth=FirebaseAuth.getInstance();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_email.getText().toString().isEmpty()) {
                    login_email.setError("Empty");
                    login_email.requestFocus();
                } else {
                    if (login_pw.getText().toString().isEmpty()) {
                        login_pw.setError("Empty");
                        login_pw.requestFocus();
                    }

                    else {
                        final String uid = login_email.getText().toString().trim();
                        final String pwd = login_pw.getText().toString().trim();
                        auth.signInWithEmailAndPassword(uid, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    if (uid.equals("admin@gmail.com") && pwd.equals("admin@123"))
                                    {
                                        Intent intent=new Intent(LoginActivity.this,AdminActivity.class);
                                        startActivity(intent);
                                        finish();
                                        //Toast.makeText(LoginActivity.this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                        //Toast.makeText(LoginActivity.this, "Valid user", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Toast.makeText(LoginActivity.this, "Invalid User", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}

