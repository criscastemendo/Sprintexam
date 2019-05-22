package com.criscastemendo.sprintexam.Detalle;

import com.criscastemendo.sprintexam.Data.ListItem;

import java.lang.ref.WeakReference;
import java.util.List;

interface DetalleContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(DetalleViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void desplazarderecha();

        void desplazarizquierda();
    }

    interface Model {
        List<ListItem> fetchData();

        int getClick();

        void desplazarderecha(ListItem i);

        void desplazarizquierda(ListItem i);
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(DetalleState state);

        ListItem getDataFromPreviousScreen();
    }
}
