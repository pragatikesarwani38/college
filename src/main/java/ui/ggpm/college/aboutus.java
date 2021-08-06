package ui.ggpm.college;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//import androidx.appcompat.app.AppCompatActivity;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
