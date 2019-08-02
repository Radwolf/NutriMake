package org.rul.nutrimake.datasource;

import org.rul.nutrimake.model.Cliente;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Rul on 27/11/2017.
 */

public interface AppDataSource {

    Flowable<List<Cliente>> getClientes();

}
