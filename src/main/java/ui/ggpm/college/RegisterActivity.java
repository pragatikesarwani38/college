package ui.ggpm.college;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
EditText password,email;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       password=(EditText) findViewById(R.id.password);
        email=findViewById(R.id.email);
        FirebaseApp.initializeApp(RegisterActivity.this);
        auth=FirebaseAuth.getInstance();
    }
    public void submit(View view)
    {
        if(email.getText().toString().isEmpty())
        {
            email.setError("Empty");
            email.requestFocus();
        }
        else
        {
            if(password.getText().toString().isEmpty())
            {
                password.setError("Empty");
                password.requestFocus();
            }
            else
            {
                String emailaddress=email.getText().toString().trim();
                String pass= password.getText().toString().trim();
                auth.createUserWithEmailAndPassword(emailaddress,pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this, "User Created!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this, "User not created", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }
    }
}
