package com.criscastemendo.sprintexam.Principal;

import com.criscastemendo.sprintexam.Data.ListItem;
import com.criscastemendo.sprintexam.Data.RepositorioContract;

import java.util.List;

public class PrincipalModel implements PrincipalContract.Model {

    public static String TAG = PrincipalModel.class.getSimpleName();

    private RepositorioContract repositorio;

    public PrincipalModel (RepositorioContract repositorio) {
        this.repositorio = repositorio;
    }

    public PrincipalModel() {

    }

    @Override
    public List<ListItem> fetchData() {
        // Log.e(TAG, "fetchData()");
        return repositorio.getListItemList();
    }

    @Override
    public void addContadorToList() {

        repositorio.nuevoContador();


    }
}
