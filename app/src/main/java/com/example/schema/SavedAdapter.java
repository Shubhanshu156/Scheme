package com.example.schema;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
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

import java.util.List;

public class SavedAdapter
        extends RecyclerView
        .Adapter<SavedAdapter.SavedViewHolder> {

    private static final String TAG = "adapter in";
    private List<ChildItem> ChildItemList;

    // Constructor
    SavedAdapter(List<ChildItem> childItemList)
    {
        Log.d(TAG, "SavedAdapter: "+"i am in adapter");
        this.ChildItemList = childItemList;
        Log.d(TAG, "SavedAdapter: "+ChildItemList.size());
    }

    @NonNull
    @Override
    public SavedViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup,
            int i)
    {

        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(
                        R.layout.sample_save,
                        viewGroup, false);

        return new SavedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull SavedViewHolder SavedViewHolder,
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
        SavedViewHolder.ChildItemTitle.setText(childItem.getChildItemTitle());
        SavedViewHolder.shcemep.setImageResource(childItem.getImageid());
        String ans=childItem.getInformation().substring(0,100);
        ans=ans+" ...more";
        SpannableString spannable = new SpannableString(ans);


        spannable.setSpan(new ForegroundColorSpan(Color.BLUE),100, 108, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);



        SavedViewHolder.info.setText(spannable);

//        SavedViewHolder.frameLayout.setOnClickListener(view->
//        {
//            String TAG="hi";
////            Log.d(TAG, "onBindViewHolder: ");
//            String msg=ChildItemList.get(position).getChildItemTitle();
//            Intent intent=new Intent(SavedViewHolder.frameLayout.getContext(), com.example.schema.SchemePage.class);
//            intent.putExtra("imageid",ChildItemList.get(position).getImageid());
//            intent.putExtra("name",ChildItemList.get(position).getChildItemTitle());
//            intent.putExtra("information",ChildItemList.get(position).getInformation());
//            intent.putExtra("application",ChildItemList.get(position).getApplication());
//            SavedViewHolder.frameLayout.getContext().startActivity(intent);
//            Toast.makeText(SavedViewHolder.frameLayout.getContext(),msg,Toast.LENGTH_LONG).show();
//
//        });

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
    static class SavedViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "dcl;kams";
        TextView ChildItemTitle;
        TextView info;
        ImageView shcemep;

        FrameLayout frameLayout;

        SavedViewHolder(View itemView)
        {
            super(itemView);

            ChildItemTitle
                    = itemView.findViewById(
                    R.id.savename);
            info=itemView.findViewById(R.id.savedinfo);
            frameLayout = itemView.findViewById(R.id.FrameLayoutSaved);
            shcemep=itemView.findViewById(R.id.savedimage);
            Log.d(TAG, "SavedViewHolder: "+frameLayout);
        }
    }


}

