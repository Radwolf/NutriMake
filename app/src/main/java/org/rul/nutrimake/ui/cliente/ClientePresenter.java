package org.rul.nutrimake.ui.cliente;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import org.rul.nutrimake.R;
import org.rul.nutrimake.injection.Injection;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.ui.AppViewModel;
import org.rul.nutrimake.ui.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lucas on 04/01/2017.
 */

public class ClientePresenter extends LifecycleActivity implements ClienteContract.Presenter {

    private static final String TAG = ClientePresenter.class.getSimpleName();

    private Context context;
    private ClienteContract.View view;
    private ClienteContract.Navigator navigator;

    private List<Cliente> clientesList;
    private List<String> names;

    private ViewModelFactory mViewModelFactory;

    private AppViewModel mViewModel;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Inject
    public ClientePresenter(Context context, ClienteContract.Navigator navigator) {
        this.navigator = navigator;
        this.context = context;

        mViewModelFactory = Injection.provideViewModelFactory(context);
        mViewModel = ViewModelProviders.of((FragmentActivity) context, mViewModelFactory).get(AppViewModel.class);

        names = new ArrayList<>();
        names.add("Nolan Mcfetridge");
        names.add("Nick Blackford");
        names.add("Carlee Mucci");
        names.add("Tianna Henricksen");
        names.add("Julie Rathburn");
        names.add("Silvana Stiner");
        names.add("Rudolf Grate");
        names.add("Saran Seaman");
        names.add("Carol Pavao");
        names.add("Karey Shatley");
        names.add("Carlita Frye");
        names.add("Sharita Ekberg");
        names.add("Elvia Huitt");
        names.add("Kesha Liebel");
        names.add("Aleida Vincelette");
        names.add("Stormy Rossiter");
        names.add("Carolina Degner");
        names.add("Ruth Slavin");
        names.add("Delilah Hermosillo");
        names.add("Willow Haley");

    }

    @Override
    public void attachView(ClienteContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    private String getRandomName() {
        Random r = new Random();
        return names.get(r.nextInt(names.size()));
    }

    @Override
    public void getCliente() {
        mDisposable.add(mViewModel.getClientes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(clientes -> {
                    clientesList = clientes;
                    if (view != null) {
                        view.showClienteList(clientesList);
                    }
                },throwable -> Log.e(TAG, "Unable to update username", throwable)));

    }

    @Override
    public void clickCliente(Cliente cliente) {
        navigator.goToClienteDetails(cliente);
    }

    @Override
    public void clickClienteAction(Cliente cliente) {
        view.showToast("Action clicked: " + cliente.nombre);
    }

    @Override
    public void loadMoreCliente() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (view != null) {
                    view.hideLoading();
                    Cliente cliente = new Cliente(Long.valueOf(UUID.randomUUID().toString()));
                    cliente.nombre = getRandomName();
                    cliente.documentoIdentidad = context.getString(R.string.fragment_people__lorem_ipsum);
                    clientesList.add(0, cliente);
                    view.showClienteList(clientesList);
                }
            }
        }, 2000);
    }
}
