package com.criscastemendo.sprintexam.Principal;

import com.criscastemendo.sprintexam.Data.ListItem;
import com.criscastemendo.sprintexam.app.AppMediator;

import java.lang.ref.WeakReference;

public class PrincipalPresenter implements PrincipalContract.Presenter {

    public static String TAG = PrincipalPresenter.class.getSimpleName();

    private WeakReference<PrincipalContract.View> view;
    private PrincipalViewModel viewModel;
    private PrincipalContract.Model model;
    private PrincipalContract.Router router;
    private AppMediator mediator;

    public PrincipalPresenter(PrincipalState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<PrincipalContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(PrincipalContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(PrincipalContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        viewModel.listItemList =model.fetchData();
        PrincipalState state= router.getDataFromPreviousScreen();
        state.listItemList =viewModel.listItemList;
        router.passDataToNextScreen(state);
        // update the view
        view.get().displayData(viewModel);

    }

    @Override
    public void addContadorToList(){


        model.addContadorToList();
        fetchData();

    }

    @Override
    public void selectContadorListData(ListItem item) {
        router.passDataToDetalleScreen(item);
        router.navigateToDetalleScreen();
    }

}
