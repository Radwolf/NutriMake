package org.rul.nutrimake;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rul.nutrimake.configuration.db.AppDatabase;
import org.rul.nutrimake.dao.AnaliticaDao;
import org.rul.nutrimake.dao.ClienteCreenciaDao;
import org.rul.nutrimake.dao.ClienteDao;
import org.rul.nutrimake.dao.CreenciaDao;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Biotipo;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.model.ClienteCreencia;
import org.rul.nutrimake.model.Creencia;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Rul on 12/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class CreenciaDaoTest extends DaoTest {

    private ClienteDao clienteDao;
    private CreenciaDao creenciaDao;
    private ClienteCreenciaDao clienteCreenciaDao;
    private AppDatabase db;

    @Before
    public void setUp() throws Exception{
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        clienteDao = db.getClienteDao();
        creenciaDao = db.getCreenciaDao();
        clienteCreenciaDao = db.getClienteCreenciaDao();
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
        assertNotNull(creenciaDao);
    }

    @Test
    public void shouldInsertCreencia(){
        String nombreCreencia = "Vegano";
        addCreencia(db, nombreCreencia);
        Creencia creencia = creenciaDao.findByNombre(nombreCreencia);
        assertNotNull(creencia);
    }

    @Test(expected = SQLiteConstraintException.class)
    public void shouldInsertCreenciaThenError(){
        String nombreCreencia = "Vegano";
        addCreencia(db, nombreCreencia);
        addCreencia(db, nombreCreencia);
    }

    @Test
    public void shouldClienteCreencia(){
        Cliente cliente = addCliente(db, "Jason", "Seaver", "670010101", null,
                "12345678Z", "HOMBRE", (long) 40, (long) 70, (long) 170,
                (long) 1, (long) 1, false, null, (long) 0, new Biotipo());
        String nombreCreencia = "Vegano";
        addCreencia(db, nombreCreencia);
        Creencia creencia = creenciaDao.findByNombre(nombreCreencia);
        addClienteCreencia(db, cliente, creencia);

        List<ClienteCreencia> clienteCreencias = clienteCreenciaDao.findByCliente(cliente.id);
        assertEquals(clienteCreencias.get(0).clienteId, cliente.id);
        assertEquals(clienteCreencias.get(0).creenciaId, creencia.id);
    }
}
