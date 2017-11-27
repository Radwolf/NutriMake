package org.rul.nutrimake.configuration.db;

import org.rul.nutrimake.datasource.AppDataSource;
import org.rul.nutrimake.model.Cliente;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Rul on 27/11/2017.
 */

public class LocalAppDataSource implements AppDataSource {

    private final AppDatabase db;

    public LocalAppDataSource(AppDatabase database) {
        db = database;
    }

    @Override
    public Flowable<List<Cliente>> getClientes() {
        return db.getClienteDao().fFindAll();
    }
}
