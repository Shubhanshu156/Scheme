package com.example.schema;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schema.ChildItem;
import com.example.schema.R;

import java.util.ArrayList;
import java.util.List;

public class DiscoverAdapter
        extends RecyclerView
        .Adapter<DiscoverAdapter.DiscoverViewHolder> {
    public void updateList(List<ChildItem> list) {
        ArrayList<ChildItem> mt=new ArrayList<ChildItem>();
        ChildItemList.clear();
        ChildItemList.addAll(list);
        notifyDataSetChanged();
    }
    private List<ChildItem> ChildItemList;

    // Constructor
    DiscoverAdapter(List<ChildItem> childItemList)
    {
        this.ChildItemList = childItemList;
    }

    @NonNull
    @Override
    public DiscoverViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup,
            int i)
    {

        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(
                        R.layout.discover_item,
                        viewGroup, false);

        return new DiscoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull DiscoverViewHolder Discoverviewholder,
            int position)
    {

        // Create an instance of the ChildItem
        // class for the given position
        ChildItem childItem
                = ChildItemList.get(position);

        // For the created instance, set title.
        // No need to set the image for
        // the ImageViews because we have
        // provided the source for the images
        // in the layout file itself
        Discoverviewholder.ChildItemTitle.setText(childItem.getChildItemTitle());
        Discoverviewholder.image.setImageResource(childItem.getImageid());
        Discoverviewholder.frameLayout.setOnClickListener(view->
        {
            String TAG="hi";
//            Log.d(TAG, "onBindViewHolder: ");
            String msg=ChildItemList.get(position).getChildItemTitle();

            Intent intent=new Intent(Discoverviewholder.frameLayout.getContext(), com.example.schema.SchemePage.class);
            intent.putExtra("imageid",ChildItemList.get(position).getImageid());
            intent.putExtra("name",ChildItemList.get(position).getChildItemTitle());
            intent.putExtra("information",ChildItemList.get(position).getInformation());
            intent.putExtra("application",ChildItemList.get(position).getApplication());
            Discoverviewholder.frameLayout.getContext().startActivity(intent);
//            Toast.makeText(Discoverviewholder.frameLayout.getContext(),msg,Toast.LENGTH_LONG).show();

        });

    }

    @Override
    public int getItemCount()
    {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
        return ChildItemList.size();
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    static class DiscoverViewHolder extends RecyclerView.ViewHolder {

        TextView ChildItemTitle;
        ImageView image;
        FrameLayout frameLayout;

        DiscoverViewHolder(View itemView)
        {
            super(itemView);

            ChildItemTitle
                    = itemView.findViewById(
                    R.id.discover_title);
            image =itemView.findViewById(R.id.discover_item);

            frameLayout = itemView.findViewById(R.id.discoverFrameLAyout);
        }
    }



}


