package com.skelly.mywesst.messages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skelly.mywesst.R;
import com.skelly.mywesst.conversation.ConversationFragment;
import com.skelly.mywesst.helpers.ItemClickSupport;

import java.util.List;

/**
 * Created by skelly on 9/17/16.
 */

public class MessagesFragment extends Fragment {

    private static final String TAG = "MessagesFragment";

    protected RecyclerView mRecyclerView;
    protected MessagesAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<MessageThread> mMessageThreadList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMessageThreadList = MessagesData.getMessageThreadList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.messages_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.messages_recycler);

        // LinearLayoutManager lays out elements like a ListView
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MessagesAdapter(getActivity(), mMessageThreadList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);

        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ConversationFragment conversationFragment = new ConversationFragment();
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                fragmentTransaction.replace(R.id.fragment_container, conversationFragment, "ConversationFragment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
