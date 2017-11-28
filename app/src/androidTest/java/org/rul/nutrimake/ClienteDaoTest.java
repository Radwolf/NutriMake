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
import org.rul.nutrimake.dao.ClienteDao;
import org.rul.nutrimake.model.Alimento;
import org.rul.nutrimake.model.Biotipo;
import org.rul.nutrimake.model.Cliente;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Rul on 12/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ClienteDaoTest extends DaoTest {

    private ClienteDao clienteDao;
    private AppDatabase db;

    @Before
    public void setUp() throws Exception{
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        clienteDao = db.getClienteDao();
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
    }

    @Test
    public void shouldInsertClient(){
        Biotipo biotipo = addBiotipo(db, 1L, "Mayores 35 Hombres", 1L,
                1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L);
        Cliente cliente1 = addCliente(db, 1L, "Jason", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 40, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, biotipo);
        List clientes = clienteDao.findAll();

        assertEquals(1, clientes.size());
        Cliente dbCliente = (Cliente) clientes.get(0);
        assertEquals("Jason", dbCliente.nombre);
        assertEquals("Seaver", dbCliente.apellidos);
        assertEquals(1, dbCliente.id.longValue());
    }

    @Test
    public void shouldDeleteCliente(){
        Biotipo biotipo = addBiotipo(db, 1L, "Mayores 35 Hombres", 1L,
                1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L);
        Cliente cliente1 = addCliente(db, 1L,"Jason", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 40, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, biotipo);
        List clientes = clienteDao.findYoungerThan(40);

        assertEquals(1, clientes.size());
        clienteDao.deleteAll();
        clientes = clienteDao.findAll();
        assertEquals(0, clientes.size());
    }

    @Test
    public void shouldInsertClientNoGustaAliemtentos(){
        Biotipo biotipo = addBiotipo(db, 1L, "Mayores 35 Hombres", 1L,
                1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L, 1L,
                1L, 1L, 1L, 1L, 1L, 1L);
        Cliente cliente = addCliente(db, 1L,"Jason", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 40, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, biotipo);
        List<Alimento> alimentos = new ArrayList<>();
        alimentos.add(addAlimento(db, 1L, "Aguacate"));
        alimentos.add(addAlimento(db, 2L, "Platano"));

    }
}
