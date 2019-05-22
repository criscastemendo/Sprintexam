package com.criscastemendo.sprintexam.Data;

import android.content.Context;
import android.util.Log;

import com.criscastemendo.sprintexam.Detalle.DetalleActivity;

import java.util.ArrayList;
import java.util.List;

public class Repositorio implements RepositorioContract{

  private List<ListItem> listItemList =new ArrayList<>();;

  private Context context;
  public static Repositorio INSTANCE;

  private int tamano = 0;
  private ListItem movi;
  private ListItem despla;

  public static String TAG = Repositorio.class.getSimpleName();

  public static Repositorio getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repositorio(context);
    }
    return INSTANCE;
  }

  public Repositorio(Context context) {this.context=context;
  }

  @Override
  public List<ListItem> getListItemList() {
    return listItemList;
  }

  @Override
  public void setListItemList(List<ListItem> listItemList) {
    this.listItemList = listItemList;
  }

  @Override
  public void nuevoContador(){

    listItemList.add(new ListItem(tamano,tamano));

    tamano++;

  }
  @Override
  public int getCliks() {
    return tamano;
  }

  @Override
  public void setCliks(int cliks1) {
    tamano = cliks1;
  }

  @Override
  public void derecha(int pos) {

    Log.e(TAG, String.valueOf(pos));
    Log.e(TAG, String.valueOf(listItemList.size()));
    if(pos<(listItemList.size()-1)) {

      movi = listItemList.get(pos);
      movi.setposition(pos+1);
      despla = listItemList.get(pos + 1);
      despla.setposition(pos);

      listItemList.set(pos,despla);
      listItemList.set(pos+1,movi);

    }
  }

  @Override
  public void izquierda(int pos) {

    if(pos>0) {

      movi = listItemList.get(pos);
      movi.setposition(pos-1);
      despla = listItemList.get(pos - 1);
      despla.setposition(pos);

      listItemList.set(pos,despla);
      listItemList.set(pos-1,movi);

    }

  }


}
