package com.example.xiago;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        view.findViewById(R.id.restaurant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment next_fragment = new RestaurantFragment();
                Bundle bundle = new Bundle();
                bundle.putString("categoryName", "restaurant");
                next_fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,next_fragment).commit();
            }
        });

        return view;

    }



}