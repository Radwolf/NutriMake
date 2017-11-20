package org.rul.nutrimake.configuration.db.util;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import org.rul.nutrimake.configuration.db.AppDatabase;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Cliente;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Rul on 02/11/2017.
 */

public class DatabaseInitializer {

    // Simulate a blocking operation delaying each Loan insertion with a delay:
    private static final int DELAY_MILLIS = 500;

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static void addAnalitica(final AppDatabase db,
                                     final Cliente cliente, final Date fecha, final String descripcion) {
        Analitica analitica = new Analitica();
        analitica.descripcion = descripcion;
        analitica.fecha = fecha;
        analitica.clienteId = cliente.id;
        db.getAnaliticaDao().insert(analitica);
    }

    private static Cliente addCliente(final AppDatabase db, final String nombre,
                           final String apellidos, final Long edad) {
        Cliente cliente = new Cliente();
        cliente.nombre = nombre;
        cliente.apellidos = apellidos;
        cliente.edad = edad;
        db.getClienteDao().insert(cliente);
        return cliente;
    }

    private static void populateWithTestData(final AppDatabase db) {
        db.getClienteDao().deleteAll();
        db.getAnaliticaDao().deleteAll();

        Cliente cliente1 = addCliente(db, "Jason", "Seaver", (long) 40);
        Cliente cliente2 = addCliente(db, "Mike", "Seaver", (long) 12);

        try {
            // Loans are added with a delay, to have time for the UI to react to changes.

            Date today = getTodayPlusDays(0);
            Date yesterday = getTodayPlusDays(-1);
            Date twoDaysAgo = getTodayPlusDays(-2);
            Date lastWeek = getTodayPlusDays(-7);
            Date twoWeeksAgo = getTodayPlusDays(-14);

            addAnalitica(db, cliente1, today, "Primera analítica");
            Thread.sleep(DELAY_MILLIS);
            addAnalitica(db, cliente2, yesterday, "Primera analítica");
            Thread.sleep(DELAY_MILLIS);
            Log.d("DB", "Added loans");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private static Date getTodayPlusDays(int daysAgo) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, daysAgo);
        return calendar.getTime();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }

}
