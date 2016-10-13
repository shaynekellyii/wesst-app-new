package com.skelly.mywesst.schools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skelly.mywesst.R;

import java.util.List;

/**
 * Created by skelly on 9/17/16.
 */

public class SchoolsFragment extends Fragment {

    private static final String TAG = "SchoolsFragment";

    protected RecyclerView mRecyclerView;
    protected SchoolsAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<School> mSchoolList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSchoolList = SchoolsData.getSchoolList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.schools_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.schools_recycler);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SchoolsAdapter(mSchoolList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);

        return rootView;
    }
}
