package ui.ggpm.college;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class FacultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void elexDep(View v)
    {
       // Toast.makeText(this, "Electronics", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(FacultyActivity.this,Elex_Department.class);
        startActivity(i);

    }
    public  void  cseDep(View v)
    {
        //Toast.makeText(this, "CSE", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(FacultyActivity.this,cse_department.class);
        startActivity(i);
    }
    public  void Applied(View v)
    {
        Intent i=new Intent(FacultyActivity.this,Applieddep.class);
        startActivity(i);
    }


    public  void nontech(View view)
    {

        Intent i=new Intent(FacultyActivity.this,nonteching.class);
        startActivity(i);


    }
}
