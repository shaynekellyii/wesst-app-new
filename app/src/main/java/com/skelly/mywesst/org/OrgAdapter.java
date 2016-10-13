package com.skelly.mywesst.org;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skelly.mywesst.R;
import com.skelly.mywesst.profile.User;

import java.util.List;

/**
 * Created by skelly on 9/17/16.
 */

public class OrgAdapter extends RecyclerView.Adapter<OrgAdapter.ViewHolder> {

    private List<User> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mName;
        protected TextView mTitle;

        public ViewHolder(View v) {
            super(v);
            mName = (TextView)v.findViewById(R.id.user_card_name);
            mTitle = (TextView)v.findViewById(R.id.user_card_title);
        }
    }

    public OrgAdapter(List<User> users) {
        mDataSet = users;
    }

    // Create new views (invoked by the LayoutManager)
    @Override
    public OrgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.org_cardview, parent, false);

        OrgAdapter.ViewHolder vh = new OrgAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(OrgAdapter.ViewHolder holder, int position) {
        holder.mName.setText(mDataSet.get(position).getName());
        holder.mTitle.setText(mDataSet.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
