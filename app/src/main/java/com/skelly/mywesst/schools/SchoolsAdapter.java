package com.skelly.mywesst.schools;

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

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.ViewHolder> {

    private List<School> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mName;

        public ViewHolder(View v) {
            super(v);
            mName = (TextView)v.findViewById(R.id.school_card_name);
        }
    }

    public SchoolsAdapter(List<School> schools) {
        mDataSet = schools;
    }

    // Create new views (invoked by the LayoutManager)
    @Override
    public SchoolsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.school_cardview, parent, false);

        SchoolsAdapter.ViewHolder vh = new SchoolsAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SchoolsAdapter.ViewHolder holder, int position) {
        holder.mName.setText(mDataSet.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
