package com.example.xiago;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

        view.findViewById(R.id.call1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:(+86)5928385888");
                Intent intent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.website1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri website = Uri.parse("https://www.shangri-la.com/xiamen/shangrila/");
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.call2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:(+86)5925078888");
                Intent intent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(intent);
            }
        });


        view.findViewById(R.id.call3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:(+86)5925091888");
                Intent intent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.website3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri website = Uri.parse("https://www.marcopolohotels.com/hotels/china/xiamen/marco_polo_xiamen/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.call4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:(+86)5926016038");
                Intent intent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.website4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri website = Uri.parse("https://www.facebook.com/JACKYANGELASTEAKHOUSE/");
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                startActivity(intent);
            }
        });


        return view;

    }
}