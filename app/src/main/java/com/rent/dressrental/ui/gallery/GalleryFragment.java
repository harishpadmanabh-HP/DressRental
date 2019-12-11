package com.rent.dressrental.ui.gallery;

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

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    RecyclerView recyclerView;
    int img[]={
            R.drawable.splashbg,
            R.drawable.bridaimage3,
            R.drawable.brideimage1,
            R.drawable.brideimage2

    };
    ArrayList<String> rate;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView=root.findViewById(R.id.bridalRV);
        rate=new ArrayList<>();
        rate.add("Rs.290");
        rate.add("Rs.350");
        rate.add("Rs.300");
        rate.add("Rs.450");
       // addRates(rate);
        setupRV(recyclerView);
        recyclerView.setAdapter(new MyAdapter(img,rate,getContext()));
        return root;
    }

     void addRates(ArrayList<String> rate) {


    }

    private void setupRV(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }
}