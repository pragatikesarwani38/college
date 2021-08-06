package ui.ggpm.college;

import android.*;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class AdminActivity extends AppCompatActivity {
Button events;
Button gallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        events=findViewById(R.id.add_events);
        gallery=findViewById(R.id.add_gallery);
    }
    public void addgallery(View view)
    {
        Intent intent=new Intent(AdminActivity.this,newpost.class);
        startActivity(intent);
    }
    public void addevent(View view)
    {
        Intent intent=new Intent(AdminActivity.this,AddEventActivity.class);
        startActivity(intent);
    }
    public void addfaculty(View view)
    {
        Intent intent=new Intent(AdminActivity.this,AddFaculty.class);
        startActivity(intent);
    }
public void logout(View view)
{
    FirebaseAuth mauth=FirebaseAuth.getInstance();
    mauth.signOut();
    Intent i=new Intent(AdminActivity.this,LoginActivity.class);
    startActivity(i);
    finish();
}


}