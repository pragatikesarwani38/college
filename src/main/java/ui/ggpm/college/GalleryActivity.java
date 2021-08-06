package ui.ggpm.college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GalleryActivity extends AppCompatActivity {
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        gridView=findViewById(R.id.gridview);
        gridView.setAdapter(new GalleryAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),FullGalleryImg.class);
                intent.putExtra("id",position);
                startActivity(intent);

            }
        });
    }
}
