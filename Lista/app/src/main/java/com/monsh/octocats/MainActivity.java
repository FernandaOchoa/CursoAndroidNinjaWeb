package com.monsh.octocats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.monsh.octocats.Model.Series;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar Serie
        List items = new ArrayList();

        items.add(new Series(R.drawable.femalecodertocat,"Female Coder to Cat", 450));
        items.add(new Series(R.drawable.linktocat,"Link to Cat", 680));
        items.add(new Series(R.drawable.monalovelace,"Mona Lovelace", 190));
        items.add(new Series(R.drawable.octoliberty,"Octoliberty", 870));
        items.add(new Series(R.drawable.skatetocat,"Skate to Cat", 240));
        items.add(new Series(R.drawable.labtocat,"Lab to Cat", 980));

        //Obtenemos el recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);


        //Usar un administrador para linearLayout
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        //Crear un nuevo adaptador
        adapter = new SeriesAdapter(items);
        recycler.setAdapter(adapter);
    }
}
