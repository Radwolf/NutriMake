package org.rul.nutrimake.configuration.db.util;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import org.rul.nutrimake.configuration.db.AppDatabase;
import org.rul.nutrimake.model.Alimentacion;
import org.rul.nutrimake.model.Alimento;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Biotipo;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.model.ClienteCreencia;
import org.rul.nutrimake.model.Creencia;

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

    private static void addClienteCreencia(final AppDatabase db, final Cliente cliente, final Creencia creencia){
        ClienteCreencia clienteCreencia = new ClienteCreencia();
        clienteCreencia.clienteId = cliente.id;
        clienteCreencia.creenciaId = creencia.id;
        db.getClienteCreenciaDao().insert(clienteCreencia);
    }

    private static void addCreencia(final AppDatabase db, final String nombre){
        Creencia creencia = new Creencia();
        creencia.nombre = nombre;
        db.getCreenciaDao().insert(creencia);
    }

    private static void addAlimentacion(final AppDatabase db,
                                   final Cliente cliente, final String descripcion, final boolean activa,
                                   final Date fechaInicio, final Date fechaFin) {
        Alimentacion alimentacion = new Alimentacion();
        alimentacion.activa = activa;
        alimentacion.clienteId = cliente.id;
        alimentacion.descripcion = descripcion;
        alimentacion.fechaInicio = fechaInicio;
        alimentacion.fechaFin = fechaFin;
        db.getAlimentacionDao().insert(alimentacion);
    }

    private static Cliente addCliente(final AppDatabase db, final Long id, final String nombre,
                                 final String apellidos, final String telefono,
                                 final String email, final String documentoIdentidad,
                                 final String sexo, final Long edad, final Long peso,
                                 final Long altura, final Long imc, final Long benedite,
                                 final boolean ejercicio, final String tipoEjercicio,
                                 final Long frecuenciaEjercicio, final Biotipo biotipo) {
        Cliente cliente = new Cliente(id);
        cliente.nombre = nombre;
        cliente.apellidos = apellidos;
        cliente.telefono = telefono;
        cliente.email = email;
        cliente.documentoIdentidad = documentoIdentidad;
        cliente.sexo = sexo;
        cliente.edad = edad;
        cliente.peso = peso;
        cliente.altura = altura;
        cliente.imc = imc;
        cliente.benedite = benedite;
        cliente.ejercicio = ejercicio;
        cliente.tipoEjercicio = tipoEjercicio;
        cliente.frecuenciaEjercicio = frecuenciaEjercicio;
        cliente.biotipoId = biotipo.id;
        cliente.fechaAlta = new Date();
        db.getClienteDao().insert(cliente);
        return db.getClienteDao().findByNameAndLastName(nombre, apellidos).get(0);
    }

    private static Biotipo addBiotipo(final AppDatabase db, final Long id, final String descripcion,
                                 final Long pesoCorporal, final Long indiceEnergia, final Long energiaTotal,
                                 final Long proteinas, final Long lipidos, final Long grasasSaturadas,
                                 final Long grasasMonoin, final Long grasasPoliin, final Long colesterol,
                                 final Long glucidos, final Long fibra, final Long potasio,
                                 final Long sodio, final Long calcio, final Long fosforo,
                                 final Long magnesio, final Long hierro, final Long yodo,
                                 final Long vitaminaA, final Long vitaminaD, final Long vitaminaE,
                                 final Long vitaminaB1, final Long vitaminaB2, final Long niacina,
                                 final Long acidoFolico, final Long vitaminaB12, final Long vitaminaC) {
        Biotipo biotipo = new Biotipo();
        biotipo.id = id;
        biotipo.descripcion = descripcion;
        biotipo.pesoCorporal = pesoCorporal;
        biotipo.indiceEnergia = indiceEnergia;
        biotipo.energiaTotal = energiaTotal;
        biotipo.proteinas = proteinas;
        biotipo.lipidos = lipidos;
        biotipo.grasasSaturadas = grasasSaturadas;
        biotipo.grasasMonoin = grasasMonoin;
        biotipo.grasasPoliin = grasasPoliin;
        biotipo.colesterol = colesterol;
        biotipo.glucidos = glucidos;
        biotipo.fibra = fibra;
        biotipo.potasio = potasio;
        biotipo.sodio = sodio;
        biotipo.calcio = calcio;
        biotipo.fosforo = fosforo;
        biotipo.magnesio = magnesio;
        biotipo.hierro = hierro;
        biotipo.yodo = yodo;
        biotipo.vitaminaA = vitaminaA;
        biotipo.vitaminaD = vitaminaD;
        biotipo.vitaminaE = vitaminaE;
        biotipo.vitaminaB1 = vitaminaB1;
        biotipo.vitaminaB2 = vitaminaB2;
        biotipo.niacina = niacina;
        biotipo.acidoFolico = acidoFolico;
        biotipo.vitaminaB12 = vitaminaB12;
        biotipo.vitaminaC = vitaminaC;
        db.getBiotipoDao().insert(biotipo);
        return db.getBiotipoDao().findById(id);
    }

    private static Alimento addAlimento(final AppDatabase db, final Long id, final String nombre){
        Alimento alimento =  new Alimento();
        alimento.id = id;
        alimento.nombre = nombre;
        db.getAlimentoDao().insert(alimento);
        return alimento;
    }

    private static void populateWithTestData(final AppDatabase db) {
        db.getAnaliticaDao().deleteAll();
        db.getClienteDao().deleteAll();

        Biotipo biotipo = addBiotipo(db, 1L, "Mayores 35 Hombres", 1L,
                1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L);
        Cliente cliente1 = addCliente(db, 1L, "Jason", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 40, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, biotipo);
        Cliente cliente2 = addCliente(db, 2L, "Mike", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 12, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, biotipo);

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
