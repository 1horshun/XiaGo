package com.example.xiago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

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

        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.featured1,"Xiamen Hongkeng Hakka Earth Building - Group Day Tour","Full Day Tour"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.featured2,"Xiamen Botanical Garden","Park"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.featured3,"Zhongsan Road Walking Street","Historic Walking Area"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
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
                            selectedFragment = new SettingsFragment();
                            break;
                    }
                    //begin
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,selectedFragment).commit();
                    return true;
                }
            };
}