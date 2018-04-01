package com.monsh.octocats;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.monsh.octocats.Model.Series;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {

    private List<Series> items;

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.series_card, parent,false);
        return new SeriesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        holder.imagen.setImageResource(items.get(position).getImagen());
        holder.nombre.setText(items.get(position).getNombre());
        holder.visitas.setText("Visitas: "+
        String.valueOf(items.get(position).getVisitas()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static  class SeriesViewHolder extends RecyclerView.ViewHolder{

        //Campos de un renglon
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;

        public SeriesViewHolder(View view){
            super(view);

            imagen = (ImageView) view.findViewById(R.id.imagen);
            nombre = (TextView) view.findViewById(R.id.nombre);
            visitas = (TextView) view.findViewById(R.id.visitas);
        }
    }

    public SeriesAdapter (List<Series> items){
        this.items = items;
    }

}
