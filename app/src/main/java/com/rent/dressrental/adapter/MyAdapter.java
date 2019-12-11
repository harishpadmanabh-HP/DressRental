package com.rent.dressrental.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.harishpadmanabh.apppreferences.AppPreferences;
import com.rent.dressrental.Checkout;
import com.rent.dressrental.Home;
import com.rent.dressrental.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH>{

    int img[]={
            R.drawable.splashbg,
            R.drawable.bridaimage3,
            R.drawable.brideimage1,
            R.drawable.brideimage2

    };
    ArrayList<String> rate;
    Context context;
    String TAG;
    AppPreferences appPreferences;

    public MyAdapter(int[] img, ArrayList<String> rate, Context context, String TAG) {
        this.img = img;
        this.rate = rate;
        this.context = context;
        this.TAG = TAG;
    }

    public MyAdapter(int[] img, ArrayList<String> rate, Context context) {
        this.img = img;
        this.rate = rate;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shr_product_card, parent, false);
        appPreferences = AppPreferences.getInstance(context, context.getResources().getString(R.string.app_name));

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, final int position) {

        holder.imageView.setImageResource(img[position]);
        holder.textView.setText(rate.get(position));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appPreferences.saveData("TAG",TAG);
                appPreferences.saveInt("position",position);

                context.startActivity(new Intent(context, Checkout.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return rate.size();
    }

    class VH extends RecyclerView.ViewHolder{
          ImageView imageView;
          TextView textView;
          View mView;
        public VH(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
            textView=mView.findViewById(R.id.product_rate);
            imageView=mView.findViewById(R.id.product_image);

        }
    }
}
