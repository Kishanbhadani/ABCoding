package com.example.abcoding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentContactMe extends Fragment {
    TextView Contact_call;
    TextView Contact_mail;

    public FragmentContactMe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_me, container, false);
        Contact_call = view.findViewById(R.id.Contact_call);
        Contact_mail = view.findViewById(R.id.Contact_mail);

        Contact_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "079-234 5567";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        });

        Contact_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("message/rfc822");
                mailIntent.putExtra(Intent.EXTRA_EMAIL, "abcodinginfo@gmail.com");
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "(subject query)");
                mailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Team, ............. " + "hello! Good Morning sir (write query...)");
                startActivity(Intent.createChooser(mailIntent,"mail send via"));
            }
        });

        return view;
    }
}