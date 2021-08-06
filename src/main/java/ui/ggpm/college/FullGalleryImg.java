package ui.ggpm.college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullGalleryImg extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_gallery_img);
        imageView=findViewById(R.id.imageview);

        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Full Image");

        Intent i=getIntent();
        int position=i.getExtras().getInt("id");
        GalleryAdapter adapter=new GalleryAdapter(this);
        imageView.setImageResource(adapter.imgArray[position]);
        

    }
}
