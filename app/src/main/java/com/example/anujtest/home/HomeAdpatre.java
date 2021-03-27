package com.example.anujtest.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anujtest.R;
import com.example.anujtest.networkingCalling.ModelData;

import java.util.List;

public class HomeAdpatre extends RecyclerView.Adapter<HomeAdpatre.NewHomeDesign> {
    private Context context;
    private List<ModelData.Datum> listdata ;

    public HomeAdpatre(List<ModelData.Datum> listdata,Context context) {
        this.listdata=listdata;
        this.context=context;
    }


    @NonNull
    @Override
    public NewHomeDesign onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewHomeDesign(LayoutInflater.from(parent.getContext()).inflate(R.layout.design_adpater_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewHomeDesign holder, int position) {
        holder.tv_adpter_textview.setText(listdata.get(position).getUsername() +  "    "+listdata.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class NewHomeDesign extends RecyclerView.ViewHolder {
        private TextView tv_adpter_textview;

        public NewHomeDesign(@NonNull View itemView) {
            super(itemView);
            tv_adpter_textview = itemView.findViewById(R.id.tv_adpter_textview);
        }
    }
}
