package org.rul.nutrimake.configuration.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import org.rul.nutrimake.dao.AnaliticaDao;
import org.rul.nutrimake.dao.ClienteDao;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Cliente;

/**
 * Created by Rul on 02/11/2017.
 */

@Database(entities = {Cliente.class, Analitica.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ClienteDao clienteModel();
    public abstract AnaliticaDao analiticaModel();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // To simplify the codelab, allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}