package com.example.abcoding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class FragmentHelpCenter extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    LinearLayout helpcenter_Raj,helpcenter_Sur,helpcenter_Ahm;

    public FragmentHelpCenter() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHelpCenter.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHelpCenter newInstance(String param1, String param2) {
        FragmentHelpCenter fragment = new FragmentHelpCenter();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help_center, container, false);
        helpcenter_Raj = view.findViewById(R.id.helpcenter_Raj);
        helpcenter_Sur = view.findViewById(R.id.helpcenter_Sur);
        helpcenter_Ahm = view.findViewById(R.id.helpcenter_Ahm);

//        helpcenter_Sur.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String geoLocation = "geo:21.1,72.8";
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(geoLocation));
//                startActivity(intent);
//            }
//        });
        helpcenter_Sur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),mapLocation.class);
                double lat = 21.1702;
                double log = 72.8311;
                intent.putExtra("Latitude", lat);
                intent.putExtra("Logtitude", log);
                getContext().startActivity(intent);
            }
        });

//        helpcenter_Raj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String geoLocation = "geo:22.3,70.8";
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(geoLocation));
//                startActivity(intent);
//            }
//        });
        helpcenter_Raj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),mapLocation.class);
                intent.putExtra("Latitude", 22.3039);
                intent.putExtra("Logtitude", 70.8022);
                getContext().startActivity(intent);
            }
        });

        helpcenter_Ahm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String geoLocation = "geo:23.0,72.5";
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(geoLocation));
//                startActivity(intent);
                Intent intent = new Intent(getContext(),mapLocation.class);
                intent.putExtra("Latitude", 23.0225);
                intent.putExtra("Logtitude", 72.5714);
                getContext().startActivity(intent);
            }
        });
        return  view;
    }
}