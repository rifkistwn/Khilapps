package com.android.khilapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.buttom_nav);

        final Sholat sholat = new Sholat();
        final Doa doa = new Doa();
        final Hadits hadits = new Hadits();
        final Inspirasi inspirasi = new Inspirasi();
        final Matsurat matsurat = new Matsurat();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.sholat) {
                    setFragment(sholat);
                    return true;
                } else if (id == R.id.doa) {
                    setFragment(doa);
                    return true;
                } else if (id == R.id.inspirasi) {
                    setFragment(inspirasi);
                    return true;
                } else if (id == R.id.hadits) {
                    setFragment(hadits);
                    return true;
                } else if (id == R.id.matsurat) {
                    setFragment(matsurat);
                    return true;
                }
                return false;
            }
        });

        navigationView.setSelectedItemId(R.id.doa);

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tentang) {
            startActivity(new Intent(this, Tentang.class));
        }

        return true;
    }


    public void setNama(String title) {

        getSupportActionBar().setTitle(title);
    }
}