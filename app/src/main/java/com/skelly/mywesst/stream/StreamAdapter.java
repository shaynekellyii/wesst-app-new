package com.skelly.mywesst.stream;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skelly.mywesst.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by skelly on 9/14/16.
 */

public class StreamAdapter extends RecyclerView.Adapter<StreamAdapter.ViewHolder> {

    private List<Post> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mAuthor;
        protected TextView mOrg;
        protected TextView mContent;
        protected TextView mTime;
        protected ImageView mImage;

        public ViewHolder(View v) {
            super(v);
            mAuthor = (TextView) v.findViewById(R.id.card_post_author);
            mOrg = (TextView) v.findViewById(R.id.card_post_org);
            mContent = (TextView) v.findViewById(R.id.card_post_content);
            mTime = (TextView) v.findViewById(R.id.card_post_time);
            mImage = (ImageView) v.findViewById(R.id.card_image);
        }
    }

    public StreamAdapter(List<Post> posts) {
        mDataSet = posts;
    }

    // Create new views (invoked by the LayoutManager)
    @Override
    public StreamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stream_cardview, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // TODO: Change username to full name, force user to add full name when signing up
        holder.mAuthor.setText(mDataSet.get(position).getUsername());

        Picasso.with(holder.mImage.getContext()).load("http://i.imgur.com/DvpvklR.png")
                .into(holder.mImage);
        holder.mImage.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}