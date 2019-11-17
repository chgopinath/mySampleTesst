package com.drivetests.androidtask2.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drivetests.androidtask2.R;
import com.drivetests.androidtask2.click_listener.Counter;
import com.drivetests.androidtask2.model.ObjectModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {

    Context context;
    ArrayList<ObjectModel> listModelArrayList;
    ArrayList<Integer> countList;
    Counter counter;
    int count = 0;

    public TitleAdapter(Context context, ArrayList<ObjectModel> listModelArrayList,ArrayList<Integer> countList,Counter counter){

        this.context = context;
        this.listModelArrayList = listModelArrayList;
        this.countList = countList;
        this.counter = counter;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_adapter_layout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {


        //Title Binding
        if(listModelArrayList.get(i).getTitle() != null){
            holder.tv_title.setText(listModelArrayList.get(i).getTitle());
        }


        //Date Binding
        if(listModelArrayList.get(i).getCreated_at() != null){

            SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy hh:mm a");

            Date d = null;
            try
            {
                d = input.parse(listModelArrayList.get(i).getCreated_at());
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            String formatted = output.format(d);
            Log.i("DATE", "" + formatted);
            holder.tv_date.setText(formatted);
        }

        // Selected count

        holder.switch_count.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                context = buttonView.getContext();
                if(isChecked){
                    count = count+1;
                   //countList.add(count);
                   counter.setCounter(count);
                   // Log.d("dd0 plus",""+countList.size());
                   notifyDataSetChanged();
                }else{
                    count = count-1;
                   // countList.remove(count);
                    counter.setCounter(count);
                    //Log.d("dd0 minus",""+countList.size());
                    notifyDataSetChanged();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listModelArrayList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        Switch switch_count;
        TextView tv_title;
        TextView tv_date;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            switch_count = itemView.findViewById(R.id.switch_count);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }


}
