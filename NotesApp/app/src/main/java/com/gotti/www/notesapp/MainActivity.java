package com.gotti.www.notesapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView mTextMessage;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        */

        setupNavigationView();
    }
    private void setupNavigationView(){

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        if (bottomNavigationView != null) {

            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                   selectFragment(menuItem);
                    return false;
                }
            });
        }


    }
    private void selectFragment (MenuItem item){
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.navigation_mic:
                break;
            case R.id.navigation_camera:
               break;
            case R.id.navigation_notes:
                pushFragment(new NotesFragment());
                break;
        }



    }

    private void pushFragment(Fragment fragment) {
        if (fragment == null){
            System.out.println("Fragment is empty");
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (fragmentTransaction != null) {

                fragmentTransaction.replace(R.id.main_frame_layout, fragment);
                fragmentTransaction.commit();
            }


        }


    }
}
