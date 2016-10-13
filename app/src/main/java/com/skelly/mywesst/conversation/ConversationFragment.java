package com.skelly.mywesst.conversation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skelly.mywesst.R;
import com.skelly.mywesst.messages.MessagesData;

import java.util.List;

/**
 * Created by skelly on 9/17/16.
 */

public class ConversationFragment extends Fragment {

    private static final String TAG = "ConversationFragment";

    protected RecyclerView mRecyclerView;
    protected ConversationAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<Message> mMessageList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMessageList = MessagesData.getConversation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container != null) {
            container.removeAllViews();
        }

        View rootView = inflater.inflate(R.layout.conversation_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.conversation_recycler);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ConversationAdapter(mMessageList);
        mRecyclerView.setAdapter(mAdapter);

        getActivity().findViewById(R.id.fab).setVisibility(View.GONE);

        return rootView;
    }
}
