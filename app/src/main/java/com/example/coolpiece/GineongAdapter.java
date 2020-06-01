package com.example.coolpiece;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GineongAdapter extends RecyclerView.Adapter {
    private ArrayList<Gineongsa> mData=null;
    static Context context;
    public GineongAdapter(ArrayList<Gineongsa> mData){
        this.mData=mData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView each_certicate;
        public Button certificate_explain;
        public Button certificate_academy;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            each_certicate=itemView.findViewById(R.id.each_certificate);
            certificate_explain=(Button)itemView.findViewById(R.id.certificate_explain);
            certificate_academy=(Button)itemView.findViewById(R.id.certificate_academy);
            context=itemView.getContext();
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.certificate_itemlist, parent, false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder=(MyViewHolder)holder;
        myViewHolder.each_certicate.setText(mData.get(position).getName());
        myViewHolder.certificate_explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cat="gineong";
                Intent intent= new Intent(context, CertificateDetail.class);
                intent.putExtra("detail", mData.get(position));
                intent.putExtra("cat", cat);
                context.startActivity(intent);
            }
        });
        myViewHolder.certificate_academy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cat="gineong";
                Intent intent=new Intent(context, EachCertificate.class);
                intent.putExtra("academy", mData.get(position));
                intent.putExtra("cat", cat);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }
}
