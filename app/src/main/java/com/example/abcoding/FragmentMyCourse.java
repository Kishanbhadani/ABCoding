package com.example.abcoding;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.google.android.material.tabs.TabLayout;


public class FragmentMyCourse extends Fragment {

    TabLayout Tab;
    ViewPager viewPager;

    public FragmentMyCourse() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_course, container, false);
        Tab = view.findViewById(R.id.Tab);
        viewPager = view.findViewById(R.id.ViewPager);

        ViewPagerMyCourseAdapter ad = new ViewPagerMyCourseAdapter(getChildFragmentManager());
        viewPager.setAdapter(ad);

        Tab.setupWithViewPager(viewPager);

        return view;
    }
}