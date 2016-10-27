package com.skelly.mywesst.stream;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skelly.mywesst.R;

import java.util.ArrayList;
import java.util.List;

/* https://developer.android.com/samples/RecyclerView/src/com.example.android.recyclerview/
 *      RecyclerViewFragment.html
 */

public class StreamFragment extends Fragment {

    private static final String TAG = "StreamFragment";

    protected RecyclerView mRecyclerView;
    protected static StreamAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected static List<Post> mPostList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPostList = new ArrayList<>();
        StreamData.getPostList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.stream_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.stream_recycler);

        // LinearLayoutManager lays out elements like a ListView
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new StreamAdapter(mPostList);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    public static void onPostLoad(List<Post> posts) {
        List<Post> newPostList = posts;
        mPostList.addAll(newPostList);
        mAdapter.notifyDataSetChanged();
    }
}
