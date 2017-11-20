package org.rul.nutrimake;

import org.rul.nutrimake.configuration.db.AppDatabase;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Cliente;

import java.util.Date;

/**
 * Created by Rul on 18/11/2017.
 */

class DaoTest {

    protected void addAnalitica(final AppDatabase db,
                                     final Cliente cliente, final Date fecha, final String descripcion) {
        Analitica analitica = new Analitica();
        analitica.descripcion = descripcion;
        analitica.fecha = fecha;
        analitica.clienteId = cliente.id;
        db.getAnaliticaDao().insert(analitica);
    }

    protected Cliente addCliente(final AppDatabase db, final String nombre,
                                      final String apellidos, final Long edad) {
        Cliente cliente = new Cliente();
        cliente.nombre = nombre;
        cliente.apellidos = apellidos;
        cliente.edad = edad;
        db.getClienteDao().insert(cliente);
        return db.getClienteDao().findByNameAndLastName(nombre, apellidos).get(0);
    }
}
