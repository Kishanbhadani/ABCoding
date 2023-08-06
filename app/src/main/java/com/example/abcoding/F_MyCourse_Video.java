package com.example.abcoding;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

public class F_MyCourse_Video extends Fragment {

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer1.stop();
        mediaPlayer1.release();
        Updateseek.interrupt();
    }

    SeekBar seekBar;
    SurfaceView Banervideo,surfaceView;
    MediaPlayer mediaPlayer, mediaPlayer1;
    Thread Updateseek;
    ImageView play;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public F_MyCourse_Video() {
        // Required empty public constructor
    }


    public static F_MyCourse_Video newInstance(String param1, String param2) {
        F_MyCourse_Video fragment = new F_MyCourse_Video();
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
        View view = inflater.inflate(R.layout.fragment_f__my_course__video, container, false);
        play = view.findViewById(R.id.Mycourse_img_play);
        seekBar = view.findViewById(R.id.seekBar);
        Banervideo = view.findViewById(R.id.Banervideo);
        surfaceView = view.findViewById(R.id.surfaceView);


        mediaPlayer = MediaPlayer.create(getContext(), R.raw.mycourse_web_baner);
        mediaPlayer1 = MediaPlayer.create(getContext(), R.raw.web_course1);
        Banervideo.setKeepScreenOn(true);
        surfaceView.setKeepScreenOn(true);
        SurfaceHolder surfaceHolder = Banervideo.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

        SurfaceHolder surfaceHolder1 = surfaceView.getHolder();
        surfaceHolder1.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaPlayer1.setDisplay(surfaceHolder1);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

        seekBar.setMax(mediaPlayer1.getDuration());
        seekBar.setProgress(mediaPlayer1.getCurrentPosition());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer1.seekTo((seekBar.getProgress()));
            }
        });

        Updateseek = new Thread(){
            @Override
            public void run() {
                int curntPosition = 0;
                try{
                    while (curntPosition<mediaPlayer1.getDuration()){
                        curntPosition = mediaPlayer1.getCurrentPosition();
                        seekBar.setProgress(curntPosition);
                        sleep(800);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        Updateseek.start();

        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        mediaPlayer1.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer1.isPlaying()) {
                    mediaPlayer1.pause();
                    play.setImageResource(R.drawable.play);
                }
                else {
                    mediaPlayer1.start();
                    play.setImageResource(R.drawable.pause);
                }
            }
        });


        return view;
    }
}