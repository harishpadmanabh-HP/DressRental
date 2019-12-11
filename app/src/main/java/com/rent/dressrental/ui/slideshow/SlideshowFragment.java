package com.rent.dressrental.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rent.dressrental.R;
import com.rent.dressrental.adapter.MyAdapter;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    RecyclerView recyclerView;
    int img[]={
            R.drawable.m1,
            R.drawable.m2,
            R.drawable.m3,
            R.drawable.m4

    };
    ArrayList<String> rate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        recyclerView=root.findViewById(R.id.menRV);
        rate=new ArrayList<>();
        rate.add("Rs.1290");
        rate.add("Rs.350");
        rate.add("Rs.1300");
        rate.add("Rs.450");
        // addRates(rate);
        setupRV(recyclerView);
        recyclerView.setAdapter(new MyAdapter(img,rate,getContext()));
        return root;
    }
    private void setupRV(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }
}