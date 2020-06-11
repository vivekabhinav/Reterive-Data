package com.abhinav.retrivedata;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {
    View view;
    public Holder(@NonNull View itemView) {
        super(itemView);

        view=itemView;


    }
    public void setView(Context context , String name,String phone,String symptoms){

        TextView nametv = view.findViewById(R.id.name_tv);
        TextView phonetv = view.findViewById(R.id.name_phone);
        TextView symptomstv = view.findViewById(R.id.name_symptoms);

        nametv.setText(name);
        phonetv.setText(phone);
        symptomstv.setText(symptoms);


    }
}
