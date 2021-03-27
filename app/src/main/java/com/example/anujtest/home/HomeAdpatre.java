package com.example.anujtest.home;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anujtest.R;
import com.example.anujtest.databinding.ModelViewDautmbinding;
import com.example.anujtest.networkingCalling.ModelData;

import java.util.List;

public class HomeAdpatre extends RecyclerView.Adapter<HomeAdpatre.NewHomeDesign> {
    private Context context;
    private List<ModelData.Datum> listdata;

    public HomeAdpatre(List<ModelData.Datum> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public NewHomeDesign onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewHomeDesign(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.design_adpater_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewHomeDesign holder, int position) {
        ModelData.Datum datum=listdata.get(position);
        holder.bind(datum);
    }

    @Override
    public int getItemCount() {
        if (listdata != null) {
            return listdata.size();
        } else {
            return 0;
        }
    }

    public class NewHomeDesign extends RecyclerView.ViewHolder {

        ModelViewDautmbinding modelViewDautmbinding;

        public NewHomeDesign(@NonNull ModelViewDautmbinding modelViewDautmbinding) {
            super(modelViewDautmbinding.getRoot());

            this.modelViewDautmbinding=modelViewDautmbinding;
        }
        public void bind(ModelData.Datum datum)
        { modelViewDautmbinding.setModelViewDautm(datum); }

    }
}
