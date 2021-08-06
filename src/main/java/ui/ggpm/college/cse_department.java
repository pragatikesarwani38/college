package ui.ggpm.college;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

public class cse_department extends AppCompatActivity {
    private RecyclerView myrecyclerView;
    FirebaseDatabase mdb= FirebaseDatabase.getInstance();
    DatabaseReference mpostref;
    private List<techersData> mexamplelist =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_department);
        myrecyclerView=findViewById(R.id.cse_teachers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mpostref=mdb.getReference().child("Department").child("CSE");;
        myrecyclerView.setHasFixedSize(true);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataMethod();
    }



    private void DataMethod() {

        mpostref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot newssnapshot : dataSnapshot.getChildren() )
                {
                   techersData  data=newssnapshot.getValue(techersData.class);
                    mexamplelist.add(data);
                }
               TechersAdapter adpter=new TechersAdapter(cse_department.this,mexamplelist);
                myrecyclerView.setAdapter(adpter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(cse_department.this, "Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


}

