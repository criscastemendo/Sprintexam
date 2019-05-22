package com.criscastemendo.sprintexam.Detalle;

import android.util.Log;

import com.criscastemendo.sprintexam.Data.ListItem;
import com.criscastemendo.sprintexam.Data.Repositorio;

import java.util.List;

public class DetalleModel implements DetalleContract.Model {

    public static String TAG = DetalleModel.class.getSimpleName();

    public Repositorio repositorio;

    public DetalleModel(Repositorio repositorio) {
        this.repositorio= repositorio;
    }

    @Override
    public List<ListItem> fetchData() {
        // Log.e(TAG, "fetchData()");

        return repositorio.getListItemList();

    }
    @Override
    public int getClick(){

        return repositorio.getCliks();

    }

    @Override
    public void desplazarderecha(ListItem i){
        Log.e(TAG, String.valueOf(i.getposition()));
        repositorio.derecha(i.getposition());

    }

    @Override
    public void desplazarizquierda(ListItem i){
        Log.e(TAG, String.valueOf(i.getposition()));
        repositorio.izquierda(i.getposition());

    }


}
