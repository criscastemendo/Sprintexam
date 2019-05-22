package com.criscastemendo.sprintexam.Principal;

import android.support.v4.app.FragmentActivity;

import com.criscastemendo.sprintexam.Data.Repositorio;
import com.criscastemendo.sprintexam.Data.RepositorioContract;
import com.criscastemendo.sprintexam.app.AppMediator;

import java.lang.ref.WeakReference;

public class PrincipalScreen {

    public static void configure(PrincipalContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        PrincipalState state = mediator.getPrincipalState();
        RepositorioContract repositorioContract = Repositorio.getInstance(context.get());

        PrincipalContract.Router router = new PrincipalRouter(mediator);
        PrincipalContract.Presenter presenter = new PrincipalPresenter(state);
        PrincipalContract.Model model = new PrincipalModel(repositorioContract);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
