package com.example.retrofitclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofitclass.R;
import com.example.retrofitclass.model.Design;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.ViewHolder> {

    private Context context;
    private List<Design> designs;

    public DesignAdapter(Context context, List<Design> designs) {
        this.context = context;
        this.designs = designs;
    }

    @NonNull
    @Override
    public DesignAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DesignAdapter.ViewHolder holder, int position) {


        Design design = designs.get(position);
        holder.textTV.setText(design.getText());
        holder.sceneryIV.setImageResource(design.getScenery());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTV;
        private ImageView sceneryIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTV = itemView.findViewById(R.id.textTV);
            sceneryIV =itemView.findViewById(R.id.sceneryIV);
        }
    }
}
