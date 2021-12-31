package com.example.xiago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Bottom nav
        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        //Setting Home Fragment as main fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,new HomeFragment()).commit();
    }


    //Listener Nav
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()){
                        case R.id.item1:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.item2:
                            selectedFragment = new FavouritesFragment();
                            break;
                        case R.id.item3:
                            selectedFragment = new ProfileFragment();
                            break;
                    }
                    //begin
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selectedFragment).commit();
                    return true;
                }
            };
}