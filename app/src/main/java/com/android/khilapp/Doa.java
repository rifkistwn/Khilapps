package com.android.khilapp;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Doa extends Fragment {
    Button playButton1 , playButton2;


    public Doa() {

    }


    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setNama("Do'a");
        View view = inflater.inflate(R.layout.fragment_doa, container, false);


        final MediaPlayer mp1 = MediaPlayer.create( getActivity() , R.raw.musik);


        playButton1 = view.findViewById(R.id.playbutton1);
        playButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp1.isPlaying()) {
                    mp1.pause();

                    playButton1.setBackgroundResource(R.drawable.play);
                } else {
                    mp1.start();
                    playButton1.setBackgroundResource(R.drawable.pause);
                }

            }
        });

        final MediaPlayer mp2 = MediaPlayer.create( getActivity() , R.raw.acoustic);
        playButton2 = view.findViewById(R.id.playbutton2);
        playButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp2.isPlaying()) {
                    mp2.pause();

                    playButton2.setBackgroundResource(R.drawable.play);
                } else {
                    mp2.start();
                    playButton2.setBackgroundResource(R.drawable.pause);
                }

            }
        });











        return view;
    }




















}


