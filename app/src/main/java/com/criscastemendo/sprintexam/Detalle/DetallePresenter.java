package com.criscastemendo.sprintexam.Detalle;

import com.criscastemendo.sprintexam.Data.ListItem;

import java.lang.ref.WeakReference;

public class DetallePresenter implements DetalleContract.Presenter {

    public static String TAG = DetallePresenter.class.getSimpleName();

    private WeakReference<DetalleContract.View> view;
    private DetalleViewModel viewModel;
    private DetalleContract.Model model;
    private DetalleContract.Router router;

    public DetallePresenter(DetalleState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<DetalleContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(DetalleContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(DetalleContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        ListItem listItem = router.getDataFromPreviousScreen();
        viewModel.contador= listItem.getId();
        viewModel.clicks=listItem.getposition();;
        view.get().displayData(viewModel);

    }

    @Override
    public void desplazarderecha(){

        model.desplazarderecha(router.getDataFromPreviousScreen());
        fetchData();

    }

    @Override
    public void desplazarizquierda(){

        model.desplazarizquierda(router.getDataFromPreviousScreen());
        fetchData();

    }

}
