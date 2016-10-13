package com.skelly.mywesst.org;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skelly.mywesst.R;
import com.skelly.mywesst.profile.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by skelly on 9/17/16.
 */

public class OrgFragment extends Fragment {

    private static final String TAG = "OrgFragment";
    private Org org;

    protected RecyclerView mRecyclerView;
    protected OrgAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected List<User> mUserList;

    private TextView mOrgInfo;
    private TextView mOrgPhone;
    private TextView mOrgAddress;
    private TextView mOrgWebsite;
    private TextView mOrgEmail;
    private TextView mOrgTitle;
    private ImageView mOrgImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.org_fragment, container, false);
        rootView.setTag(TAG);

        String orgType = getArguments().getString("orgType");

        mUserList = OrgData.getOrgUsers();

        mOrgAddress = (TextView)rootView.findViewById(R.id.org_address);
        mOrgInfo = (TextView)rootView.findViewById(R.id.org_info);
        mOrgPhone = (TextView)rootView.findViewById(R.id.org_phone);
        mOrgWebsite = (TextView)rootView.findViewById(R.id.org_website);
        mOrgEmail = (TextView)rootView.findViewById(R.id.org_email);
        mOrgTitle = (TextView)rootView.findViewById(R.id.org_title);
        mOrgImage = (ImageView)rootView.findViewById(R.id.org_image);

        org = OrgData.getOrgData(orgType);
        mOrgAddress.setText(org.getAddress());
        mOrgInfo.setText(org.getInfo());
        mOrgPhone.setText(org.getPhone());
        mOrgWebsite.setText(org.getWebsite());
        mOrgEmail.setText(org.getEmail());
        mOrgTitle.setText(org.getName());

        Picasso.with(getActivity()).load("http://i.imgur.com/DvpvklR.png").into(mOrgImage);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.org_recycler);

        // LinearLayoutManager lays out elements like a ListView
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new OrgAdapter(mUserList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);

        return rootView;
    }
}
