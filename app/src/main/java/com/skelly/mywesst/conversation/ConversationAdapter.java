package com.skelly.mywesst.conversation;

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

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ViewHolder> {

private List<Message> mDataSet;

public static class ViewHolder extends RecyclerView.ViewHolder {
    protected TextView mAuthor;
    protected TextView mTime;
    protected TextView mContent;

    public ViewHolder(View v) {
        super(v);
        mAuthor = (TextView)v.findViewById(R.id.card_msg_user);
        mTime = (TextView)v.findViewById(R.id.card_msg_time);
        mContent = (TextView)v.findViewById(R.id.card_msg_content);
    }
}

    public ConversationAdapter(List<Message> messages) {
        mDataSet = messages;
    }

    // Create new views (invoked by the LayoutManager)
    @Override
    public ConversationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_cardview, parent, false);

        ConversationAdapter.ViewHolder vh = new ConversationAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ConversationAdapter.ViewHolder holder, int position) {
        holder.mAuthor.setText(mDataSet.get(position).getSender());
        holder.mTime.setText(mDataSet.get(position).getTime());
        holder.mContent.setText(mDataSet.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}