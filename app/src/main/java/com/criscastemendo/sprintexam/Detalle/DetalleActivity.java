package com.criscastemendo.sprintexam.Detalle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.criscastemendo.sprintexam.R;

public class DetalleActivity
        extends AppCompatActivity implements DetalleContract.View {

    public static String TAG = DetalleActivity.class.getSimpleName();

    private DetalleContract.Presenter presenter;
    private Button derechabutton;
    private Button izquierdabutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        derechabutton= findViewById(R.id.derecha);

        derechabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.desplazarderecha();
            }
        });

        izquierdabutton= findViewById(R.id.izquierda);

        izquierdabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.desplazarizquierda();
            }
        });



        // do the setup
        DetalleScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(DetalleContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(DetalleViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.contador)).setText(String.valueOf(viewModel.contador));
        ((TextView) findViewById(R.id.clicks)).setText(String.valueOf(viewModel.clicks));
    }
}
