package com.rent.dressrental;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.harishpadmanabh.apppreferences.AppPreferences;

import java.util.ArrayList;
import java.util.Calendar;

public class Checkout extends AppCompatActivity {

    private ImageView displayimage;
    private TextView rate;
    private EditText from;
    private EditText to;
    ArrayList<String> ratebridal;
    ArrayList<String> ratebridewomen;
    ArrayList<String> ratebridemen;
    int imgbridal[]={R.drawable.splashbg, R.drawable.bridaimage3, R.drawable.brideimage1, R.drawable.brideimage2};
    int imgbridewomen[]={R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4};
    int imgbridemen[]={R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4};
    AppPreferences appPreferences;
    Spinner spins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        initView();
        spins=(Spinner)findViewById(R.id.spinner_states);
        ArrayList<String> states = new ArrayList<>();
        states.add("Location");
        states.add("Kerala");
        states.add("Tamilnadu");
        states.add("Karnataka");

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,states);
        spins.setAdapter(adapt);

        appPreferences = AppPreferences.getInstance(getApplicationContext(), getApplicationContext().getResources().getString(R.string.app_name));

        ratebridal=new ArrayList<>();
        ratebridal.add("Rs.290");
        ratebridal.add("Rs.350");
        ratebridal.add("Rs.300");
        ratebridal.add("Rs.450");

        ratebridewomen=new ArrayList<>();
        ratebridewomen.add("Rs.1290");
        ratebridewomen.add("Rs.350");
        ratebridewomen.add("Rs.1300");
        ratebridewomen.add("Rs.450");

        ratebridemen=new ArrayList<>();
        ratebridemen.add("Rs.1290");
        ratebridemen.add("Rs.350");
        ratebridemen.add("Rs.1300");
        ratebridemen.add("Rs.450");
      String input= appPreferences.getData("TAG");
      int data=appPreferences.getInt("position");
      if(input.equals("bridal")){
          rate.setText(ratebridal.get(data));
          displayimage.setImageResource(imgbridal[data]);
      }
      else if(input.equals("women")){
          rate.setText(ratebridewomen.get(data));
          displayimage.setImageResource(imgbridewomen[data]);
      }
      else if(input.equals("men")){
          rate.setText(ratebridemen.get(data));
          displayimage.setImageResource(imgbridemen[data]);
      }


        final Calendar c = Calendar.getInstance();
         final int mYear = c.get(Calendar.YEAR);
         final int mMonth = c.get(Calendar.MONTH);
         final int mDay = c.get(Calendar.DAY_OF_MONTH);

         from.setOnFocusChangeListener(new View.OnFocusChangeListener() {
             @RequiresApi(api = Build.VERSION_CODES.N)
             @Override
             public void onFocusChange(View view, boolean b) {
                 if(b){
                     DatePickerDialog datePickerDialog = new DatePickerDialog(Checkout.this,
                             new DatePickerDialog.OnDateSetListener() {

                                 @Override
                                 public void onDateSet(DatePicker view, int year,
                                                       int monthOfYear, int dayOfMonth) {
//set date to editext
                                     from.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                 }
                             }, mYear, mMonth, mDay);
                     datePickerDialog.show();
                 }

             }

         });


         to.setOnFocusChangeListener(new View.OnFocusChangeListener() {
             @Override
             public void onFocusChange(View view, boolean b) {
                 if(b){
                     DatePickerDialog datePickerDialog = new DatePickerDialog(Checkout.this,
                             new DatePickerDialog.OnDateSetListener() {

                                 @Override
                                 public void onDateSet(DatePicker view, int year,
                                                       int monthOfYear, int dayOfMonth) {
//set date to editext
                                     to.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                 }
                             }, mYear, mMonth, mDay);
                     datePickerDialog.show();
                 }

             }

         });

    }

    private void initView() {
        displayimage = (ImageView) findViewById(R.id.displayimage);
        rate = (TextView) findViewById(R.id.rate);
        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);


    }

    public void checkout(View view) {
        Toast.makeText(this, "Item has been placed for checkout", Toast.LENGTH_SHORT).show();
    }
}
