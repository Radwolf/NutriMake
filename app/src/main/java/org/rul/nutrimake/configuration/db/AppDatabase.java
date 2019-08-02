package org.rul.nutrimake.configuration.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import org.rul.nutrimake.dao.AlimentacionDao;
import org.rul.nutrimake.dao.AlimentoDao;
import org.rul.nutrimake.dao.AnaliticaDao;
import org.rul.nutrimake.dao.BiotipoDao;
import org.rul.nutrimake.dao.ClienteCreenciaDao;
import org.rul.nutrimake.dao.ClienteDao;
import org.rul.nutrimake.dao.CreenciaDao;
import org.rul.nutrimake.model.Alimentacion;
import org.rul.nutrimake.model.Alimento;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Biotipo;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.model.ClienteCreencia;
import org.rul.nutrimake.model.Creencia;

/**
 * Created by Rul on 02/11/2017.
 */

@Database(entities = {Cliente.class, Analitica.class, Biotipo.class, Alimentacion.class,
        Creencia.class, ClienteCreencia.class, Alimento.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract AlimentacionDao getAlimentacionDao();
    public abstract AlimentoDao getAlimentoDao();
    public abstract AnaliticaDao getAnaliticaDao();
    public abstract BiotipoDao getBiotipoDao();
    public abstract ClienteDao getClienteDao();
    public abstract CreenciaDao getCreenciaDao();
    public abstract ClienteCreenciaDao getClienteCreenciaDao();

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