package org.rul.nutrimake.ui;

import android.arch.lifecycle.ViewModel;

import org.rul.nutrimake.datasource.AppDataSource;
import org.rul.nutrimake.model.Cliente;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Rul on 27/11/2017.
 */

public class AppViewModel extends ViewModel {

    private final AppDataSource mAppDataSource;

    private List<Cliente> mClientes;

    public AppViewModel(AppDataSource mAppDataSource) {
        this.mAppDataSource = mAppDataSource;
    }

    public Flowable<List<Cliente>> getClientes(){
        return mAppDataSource.getClientes()
                .map(clientes -> {
                    mClientes = clientes;
                    return clientes;
                });
    }
}
