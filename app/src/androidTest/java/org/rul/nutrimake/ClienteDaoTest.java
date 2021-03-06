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
import org.rul.nutrimake.dao.AnaliticaDao;
import org.rul.nutrimake.dao.ClienteDao;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Cliente;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Rul on 12/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ClienteDaoTest extends DaoTest {

    private ClienteDao clienteDao;
    private AnaliticaDao analiticaDao;
    private AppDatabase db;

    @Before
    public void setUp() throws Exception{
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        clienteDao = db.getClienteDao();
        analiticaDao = db.getAnaliticaDao();
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
        assertNotNull(analiticaDao);
    }

    @Test
    public void shouldInsertClient(){
        Cliente cliente1 = addCliente(db, "Jason", "Seaver", (long) 40);
        List clientes = clienteDao.loadAllClientes();

        assertEquals(1, clientes.size());
        Cliente dbCliente = (Cliente) clientes.get(0);
        assertEquals("Jason", dbCliente.nombre);
        assertEquals("Seaver", dbCliente.apellidos);
        assertEquals(1, dbCliente.id.longValue());
    }

    @Test
    public void shouldDeleteCliente(){

        Cliente cliente1 = addCliente(db, "Jason", "Seaver", (long) 40);
        List clientes = clienteDao.findYoungerThan(40);

        assertEquals(1, clientes.size());
        clienteDao.deleteAll();
        clientes = clienteDao.loadAllClientes();
        assertEquals(0, clientes.size());
    }
}
