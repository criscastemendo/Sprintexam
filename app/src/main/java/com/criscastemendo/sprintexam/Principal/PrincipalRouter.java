package com.criscastemendo.sprintexam.Principal;

import android.content.Context;
import android.content.Intent;

import com.criscastemendo.sprintexam.Data.ListItem;
import com.criscastemendo.sprintexam.Detalle.DetalleActivity;
import com.criscastemendo.sprintexam.app.AppMediator;

public class PrincipalRouter implements PrincipalContract.Router {

    public static String TAG = PrincipalRouter.class.getSimpleName();

    private AppMediator mediator;

    public PrincipalRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, PrincipalActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(PrincipalState state) {
        mediator.setPrincipalState(state);
    }

    @Override
    public PrincipalState getDataFromPreviousScreen() {
        PrincipalState state = mediator.getPrincipalState();
        return state;
    }

    @Override
    public void passDataToDetalleScreen(ListItem item) {
        mediator.getContadorItem(item);
    }

    @Override
    public void navigateToDetalleScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, DetalleActivity.class);
        context.startActivity(intent);

    }
}
