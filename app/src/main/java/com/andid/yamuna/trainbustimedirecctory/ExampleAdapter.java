package com.andid.yamuna.trainbustimedirecctory;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.Exampleviewholder> {
    private  ArrayList<exampleitem>mexample;
    private onitemclickListener mlistener;

    public interface onitemclickListener{
        void onitemclick(int i);
    }

    public void setOnClickListener(onitemclickListener listener){
        mlistener=listener;
    }
    @NonNull
    @Override
    public Exampleviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item,viewGroup,false);
      Exampleviewholder evholder =new Exampleviewholder(v,mlistener);
      return evholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Exampleviewholder exampleviewholder, int i) {
        exampleitem currentitem=mexample.get(i);
        exampleviewholder.mimageview.setImageResource(currentitem.getImageloc());
        exampleviewholder.mtextview.setText(currentitem.getLocation());
    }

    @Override
    public int getItemCount() {
        return mexample.size();
    }

    public static class Exampleviewholder extends RecyclerView.ViewHolder{
        public ImageView mimageview;
        public TextView mtextview;

        public Exampleviewholder(@NonNull View itemView, final onitemclickListener listener) {
            super(itemView);
            mimageview=itemView.findViewById(R.id.imagev);
            mtextview=itemView.findViewById(R.id.location);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(listener!=null){
                        int position=getAdapterPosition();
                        if (position !=RecyclerView.NO_POSITION){
                            listener.onitemclick(position);
                        }
                    }
                }
            });
        }

    }

    public  ExampleAdapter(ArrayList<exampleitem> examplelist){
        mexample=examplelist;

    }

}
