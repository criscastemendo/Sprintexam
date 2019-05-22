package com.criscastemendo.sprintexam.app;

import android.app.Application;

import com.criscastemendo.sprintexam.Data.ListItem;
import com.criscastemendo.sprintexam.Detalle.DetalleState;
import com.criscastemendo.sprintexam.Principal.PrincipalState;

public class AppMediator extends Application {


  private PrincipalState principalState;
  private DetalleState detalleState;

  private ListItem contador;

  public AppMediator() {
    principalState = new PrincipalState();
    detalleState = new DetalleState();
  }

  public PrincipalState getPrincipalState() {
    return principalState;
  }

  public void setPrincipalState(PrincipalState principalState) {
    this.principalState = principalState;
  }

  public DetalleState getDetalleState () {
    return detalleState;
  }

  public void setDetalleState(DetalleState detalleState) {
    this.detalleState = detalleState;
  }

  public ListItem getContador() {
    return contador;
  }

  public void getContadorItem (ListItem contador) {
    this.contador= contador;
  }
}