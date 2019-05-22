package com.criscastemendo.sprintexam.Detalle;

import android.content.Context;
import android.content.Intent;

import com.criscastemendo.sprintexam.Data.ListItem;
import com.criscastemendo.sprintexam.app.AppMediator;

public class DetalleRouter implements DetalleContract.Router {

    public static String TAG = DetalleRouter.class.getSimpleName();

    private AppMediator mediator;

    public DetalleRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, DetalleActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(DetalleState state) {
        mediator.setDetalleState(state);
    }

    @Override
    public ListItem getDataFromPreviousScreen() {
        ListItem listItem = mediator.getContador();
        return listItem;
    }
}
