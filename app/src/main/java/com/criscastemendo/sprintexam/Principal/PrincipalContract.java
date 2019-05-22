package com.criscastemendo.sprintexam.Principal;

import com.criscastemendo.sprintexam.Data.ListItem;

import java.lang.ref.WeakReference;
import java.util.List;

interface PrincipalContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(PrincipalViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void addContadorToList();

        void selectContadorListData(ListItem item);
    }

    interface Model {
        List<ListItem> fetchData();

        void addContadorToList();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(PrincipalState state);

        PrincipalState getDataFromPreviousScreen();

        void passDataToDetalleScreen(ListItem item);

        void navigateToDetalleScreen();
    }
}
