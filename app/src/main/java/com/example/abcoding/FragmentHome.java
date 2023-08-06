package com.example.abcoding;

import static android.content.Context.NOTIFICATION_SERVICE;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Objects;


public class FragmentHome extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button Home_JoinCourse;
    ImageView Home_notify;
    ImageView home_WebDev,home_AppDev,home_GraDev,home_DatDev;
    LinearLayout Home_notification;

    public FragmentHome() {
        // Required empty public constructor
    }


    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Home_JoinCourse = view.findViewById(R.id.Home_JoinCourse);
        Home_JoinCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Swipe Course section", Toast.LENGTH_SHORT).show();
                FragmentManager fm = getParentFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.Contanier, new FragmentMyCourse());
                ft.commit();
            }
        });

        home_WebDev = view.findViewById(R.id.home_WebDev);
        home_AppDev = view.findViewById(R.id.homw_AppDev);
        home_GraDev = view.findViewById(R.id.home_GraDev);
        home_DatDev = view.findViewById(R.id.home_DatDev);
        home_WebDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = "https://youtu.be/l1EssrLxt7E";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(file));
                startActivity(intent);
            }
        });

        home_AppDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = "https://youtu.be/u0kmgolU09g";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(file));
                startActivity(intent);
            }
        });

        home_GraDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = "https://youtu.be/cVkLEAilqzI";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(file));
                startActivity(intent);
            }
        });

        home_DatDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = "https://youtu.be/f1oV46r69YM";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(file));
                startActivity(intent);
            }
        });

        Home_notification = view.findViewById(R.id.Home_notification);
        Home_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), HNotification.class);
                startActivity(i);
            }
        });

        return view;
    }
}