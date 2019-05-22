package com.criscastemendo.sprintexam.Principal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.criscastemendo.sprintexam.Data.ListItem;
import com.criscastemendo.sprintexam.R;

public class PrincipalActivity
        extends AppCompatActivity implements PrincipalContract.View {

    public static String TAG = PrincipalActivity.class.getSimpleName();

    private PrincipalContract.Presenter presenter;
    private PrincipalAdapter listAdapter;
    private Button addbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        addbutton= findViewById(R.id.button);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addContadorToList();
            }
        });

        listAdapter = new PrincipalAdapter(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ListItem item = (ListItem) view.getTag();
                presenter.selectContadorListData(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.contador_list);
        recyclerView.setAdapter(listAdapter);
        // do the setup
        PrincipalScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(PrincipalContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(PrincipalViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        listAdapter.setItems(viewModel.listItemList);
        // deal with the data
        //((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
