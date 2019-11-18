package com.android.khilapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Hadits extends Fragment {
    Intent intent;
    ListView listview;
    String x[] = {
            "Hati", "Hari Kiamat", "Dajjal", "Larangan Marah", "Mengingat Kemaatian", "Berbuat Dosa Terang-Terangan",
            "Pahala Mati Syahid", "Berharap", "Kriteria Perempuan Idaman", "Berkata Baik atau Diam", "Nikmat Sehat dan Waktu Luang", "Perintah Istiqomah", "Apaibla Merasa Ragu", "Mencari Ilmu", "Berbakti Kepada Kedua Orang Tua", "Sholat Tepat Waktu"
    };

    public Hadits() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).setNama("Hadits");
        View rootView = inflater.inflate(R.layout.fragment_hadits, container, false);

        listview = rootView.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, x);


        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    intent = new Intent(getActivity(), Tentang.class);
                    startActivity(intent);
                } else if (position == 1) {
                    intent = new Intent(getActivity(), IsiHadits.class);
                    startActivity(intent);
                } else if (position == 2) {
                    intent = new Intent(getActivity(), Matsurat.class);
                    startActivity(intent);
                } else {
                    Toast t = Toast.makeText(getActivity(), x[position], Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                    t.show();
                }
            }
        });

        return rootView;
    }
}