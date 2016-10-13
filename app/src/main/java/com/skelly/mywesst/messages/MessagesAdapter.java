package com.skelly.mywesst.messages;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skelly.mywesst.R;

import java.util.List;

/**
 * Created by skelly on 9/17/16.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    private List<MessageThread> mDataSet;
    private Activity mActivity;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mName;
        protected TextView mLastMsg;
        protected TextView mTime;
        //protected ImageView mImage;

        public ViewHolder(View v) {
            super(v);
            mName = (TextView)v.findViewById(R.id.card_msg_user);
            mLastMsg = (TextView)v.findViewById(R.id.card_msg_content);
            mTime = (TextView)v.findViewById(R.id.card_msg_time);
            //mImage = (ImageView)v.findViewById(R.id.card_msg_photo);
        }
    }

    public MessagesAdapter(Activity activity, List<MessageThread> messageThreads) {
        mDataSet = messageThreads;
        mActivity = activity;
    }

    // Create new views (invoked by the LayoutManager)
    @Override
    public MessagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_cardview, parent, false);

        MessagesAdapter.ViewHolder vh = new MessagesAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MessagesAdapter.ViewHolder holder, int position) {
        holder.mName.setText(mDataSet.get(position).getName());
        holder.mLastMsg.setText(mDataSet.get(position).getLastMsg());
        holder.mTime.setText(mDataSet.get(position).getTime());

        //Picasso.with(mActivity).load("http://i.imgur.com/DvpvklR.png").into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
