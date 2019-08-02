package org.rul.nutrimake;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rul.nutrimake.configuration.db.AppDatabase;
import org.rul.nutrimake.dao.AlimentacionDao;
import org.rul.nutrimake.dao.AnaliticaDao;
import org.rul.nutrimake.dao.ClienteDao;
import org.rul.nutrimake.model.Alimentacion;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Biotipo;
import org.rul.nutrimake.model.Cliente;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Rul on 12/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AlimentacionDaoTest extends DaoTest {

    private ClienteDao clienteDao;
    private AlimentacionDao alimentacionDao;
    private AppDatabase db;

    @Before
    public void setUp() throws Exception{
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        clienteDao = db.getClienteDao();
        alimentacionDao = db.getAlimentacionDao();
    }

    @After
    public void tearDown() throws Exception{
        db.close();
    }

    @Test
    public void shouldCreateDatabase(){
        assertNotNull(db);
    }

    @Test
    public void shouldCreateDao(){
        assertNotNull(clienteDao);
        assertNotNull(alimentacionDao);
    }

    @Test
    public void shouldInsertClient(){
        Cliente cliente = addCliente(db, 1L, "Jason", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 40, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, new Biotipo());
        addAlimentacion(db, cliente, "Alimentacion sana", true, new Date(), null);
        List<Alimentacion> alimentaciones = alimentacionDao.findByCliente(cliente.id);
        assertEquals(1, alimentaciones.size());

    }

    @Test
    public void shouldFindUltimaAlimentacion(){
        String descripcionDieta = "Alimentacion sana 1";
        String descripcionDieta2 = "Alimentacion sana 2";
        Cliente cliente = addCliente(db, 1L,"Jason", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 40, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, new Biotipo());
        addAlimentacion(db, cliente, descripcionDieta, true, new Date(), new Date());
        addAlimentacion(db, cliente, descripcionDieta2, true, new Date(), null);
        Alimentacion alimentacion = alimentacionDao.findByClienteLastAlimentacion(cliente.id);
        assertTrue(alimentacion.activa);
        assertNull(alimentacion.fechaFin);
        assertEquals(descripcionDieta2, alimentacion.descripcion);
    }

    @Test
    public void shoulUpdateAlimentacion(){
        String descripcionDieta = "Alimentacion sana";
        Cliente cliente = addCliente(db, 1L, "Jason", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 40, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, new Biotipo());
        addAlimentacion(db, cliente, descripcionDieta, true, new Date(), null);
        Alimentacion alimentacion = alimentacionDao.findByClienteLastAlimentacion(cliente.id);
        alimentacion.activa = false;
        alimentacion.fechaFin = new Date();
        //Updateamos REMPLAZANDO en el insert
        db.getAlimentacionDao().insert(alimentacion);
        //Ya no tenemos ultima alimentación activa
        Alimentacion alimentacionUpdate = alimentacionDao.findByClienteLastAlimentacion(cliente.id);
        assertNull(alimentacionUpdate);
        //Comprobamos que la alimentación siguen en la base de datos y que los cambios se han realizado
        alimentacionUpdate = alimentacionDao.findById(alimentacion.id);
        assertFalse(alimentacionUpdate.activa);
        assertNotNull(alimentacionUpdate.fechaFin);
        assertEquals(descripcionDieta, alimentacionUpdate.descripcion);
    }
}
