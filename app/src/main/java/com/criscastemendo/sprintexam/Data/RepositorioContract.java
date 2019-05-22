package com.criscastemendo.sprintexam.Data;

import java.util.List;

public interface RepositorioContract {


    List<ListItem> getListItemList();

    void setListItemList(List<ListItem> listItemList);

    void nuevoContador();

    int getCliks();

    void setCliks(int cliks1);

    void derecha(int pos);

    void izquierda(int pos);
}
