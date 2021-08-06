package ui.ggpm.college;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref=db.getReference();
    private DatabaseReference first=ref.child("User Data");
    String current_user_id;
    FirebaseAuth mauth;
    TextView myusername;
    //DatabaseReference dbref;

    CircleImageView myprofileimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mauth = FirebaseAuth.getInstance();
        current_user_id = mauth.getCurrentUser().getUid();

        ref = FirebaseDatabase.getInstance().getReference().child("User Data").child(current_user_id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        myusername=findViewById(R.id.myusername);
        myprofileimg=findViewById(R.id.myprofileimg);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    //ref= FirebaseDatabase.getInstance().getReference().child("User Profile Image");
                    String myuser=dataSnapshot.child("Name").getValue().toString();
                    String mypic=dataSnapshot.child("Profileimg").getValue().toString();
                    myusername.setText("Welcome to GGP MEJA "+myuser);

                    //   Picasso.get().load(mypic).placeholder(R.drawable.imagepl).error(R.drawable.imgnotfo).into(myprofileimg);
                    //Picasso.get().load(mypic).into(myprofileimg);
                    //Picasso.get().load(getIntent().getStringExtra("Profileimg")).into(myprofileimg);
               // myprofileimg.setImageURI();

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void gallery(View view)
    {
        Intent intent=new Intent(MainActivity.this,Newsfeed.class);
    startActivity(intent);
    }
public void events(View view)
{
    Intent intent=new Intent(MainActivity.this,GalleryActivity.class);
    startActivity(intent);
}
    public void career(View view)
    {
        Intent intent=new Intent(MainActivity.this,CareerDevelopment.class);
        startActivity(intent);
    }

    public void faculty(View view)
    {
        Intent intent=new Intent(MainActivity.this,FacultyActivity.class);
        startActivity(intent);
    }
    public void facilities(View view)
    {
        Intent intent=new Intent(MainActivity.this,Facilites.class);
        startActivity(intent);
    }

    public void about(View view)
    {
        Intent intent=new Intent(MainActivity.this,aboutus.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            FirebaseAuth mauth=FirebaseAuth.getInstance();
            mauth.signOut();
            Intent i=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent=new Intent(MainActivity.this,userregistration.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.admission) {
            Intent intent=new Intent(MainActivity.this,Admission.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {

        }
        else if (id == R.id.nav_video) {
            Intent intent=new Intent(MainActivity.this,achivment.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
