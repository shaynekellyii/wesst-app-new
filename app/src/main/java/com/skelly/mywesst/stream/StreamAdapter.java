package com.skelly.mywesst.stream;

import android.app.Activity;
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
    private Activity mActivityContext;

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

    public StreamAdapter(Activity context, List<Post> posts) {
        mDataSet = posts;
        mActivityContext = context;
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
        holder.mAuthor.setText(mDataSet.get(position).getAuthor());
        holder.mOrg.setText(mDataSet.get(position).getOrganization());
        holder.mContent.setText(mDataSet.get(position).getContent());
        holder.mTime.setText(mDataSet.get(position).getTime());

        Picasso.with(mActivityContext).load("http://i.imgur.com/DvpvklR.png")
                .into(holder.mImage);
        holder.mImage.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}