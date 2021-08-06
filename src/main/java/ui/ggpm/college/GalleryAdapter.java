package ui.ggpm.college;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by hp on 22-09-2020.
 */

public class GalleryAdapter extends BaseAdapter {

    private Context mContext;
    public int[] imgArray={R.drawable.snap1,R.drawable.snap2,R.drawable.snap3,R.drawable.snap4,R.drawable.snap5,R.drawable.snap6};

    public GalleryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imgArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imgArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(mContext);
        imageView.setImageResource(imgArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340,350));


        return imageView;
    }
}
