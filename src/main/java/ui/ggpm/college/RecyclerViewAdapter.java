package ui.ggpm.college;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hp on 04-02-2020.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Exampleviewholder> {
    public List<ImageUploadInfo> mExamplelist;
    public Context mContext;
    public static class Exampleviewholder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
    public TextView imageNameTextView;





        public Exampleviewholder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            imageNameTextView = (TextView) itemView.findViewById(R.id.head);
            //Desc=(TextView) itemView.findViewById(R.id.desc);
        }
    }

    public RecyclerViewAdapter(Context context, List<ImageUploadInfo> examplelist )
    {
        mContext=context;
        mExamplelist=examplelist;
    }

    @Override
    public Exampleviewholder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_items,viewGroup,false);
        Exampleviewholder exampleviewholder=new Exampleviewholder(view);
        return exampleviewholder;
    }

    @Override
    public void onBindViewHolder(Exampleviewholder exampleviewholder, int i)
    {
        final ImageUploadInfo currentitem=mExamplelist.get(i);
        exampleviewholder.imageNameTextView.setText(currentitem.getImageName());
        //exampleviewholder.Desc.setText(currentitem.getImageDesc());
        Picasso.get().load(currentitem.getImageURL()).into(exampleviewholder.imageView);


    }

    @Override
    public int getItemCount() {
        return mExamplelist.size();
    }


}
