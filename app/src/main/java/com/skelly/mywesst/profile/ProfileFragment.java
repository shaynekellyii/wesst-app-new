package com.skelly.mywesst.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skelly.mywesst.R;
import com.squareup.picasso.Picasso;

/**
 * Created by skelly on 9/17/16.
 */

public class ProfileFragment extends Fragment {

    private static final String TAG = "ProfileFragment";

    User mUser;

    private TextView mName;
    private TextView mSchool;
    private TextView mPhone;
    private TextView mEmail;
    private TextView mDegree;
    private TextView mYear;
    private TextView mAge;
    private ImageView mImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_fragment, container, false);
        rootView.setTag(TAG);

        mName = (TextView)rootView.findViewById(R.id.profile_name);
        mSchool = (TextView)rootView.findViewById(R.id.profile_school);
        mPhone = (TextView)rootView.findViewById(R.id.profile_phone);
        mEmail = (TextView)rootView.findViewById(R.id.profile_email);
        mDegree = (TextView)rootView.findViewById(R.id.profile_degree);
        mYear = (TextView)rootView.findViewById(R.id.profile_year);
        mAge = (TextView)rootView.findViewById(R.id.profile_age);
        mImage = (ImageView)rootView.findViewById(R.id.profile_image);

        mUser = UserData.getUser();
        mName.setText(mUser.getName());
        mSchool.setText(mUser.getSchool());
        mPhone.setText(mUser.getPhone());
        mEmail.setText(mUser.getEmail());
        mDegree.setText(mUser.getDegree());
        mYear.setText(mUser.getYear());
        mAge.setText(mUser.getAge());
        Picasso.with(getActivity()).load("http://i.imgur.com/DvpvklR.png").into(mImage);

        return rootView;
    }
}
