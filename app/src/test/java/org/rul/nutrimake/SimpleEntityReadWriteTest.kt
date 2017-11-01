package org.rul.nutrimake

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.rul.nutrimake.configuration.db.TestDatabase
import java.io.IOException


/**
 * Created by Rul on 12/10/2017.
 */
@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {
    private var mClienteDao: ClienteDaoKt? = null
    private var mDb: TestDatabase? = null

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        mDb = Room.inMemoryDatabaseBuilder(context, TestDatabase::class.java!!).build()
        mClienteDao = mDb!!.getClienteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        mDb!!.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val cliente : ClienteKt = TestUtil.createCliente()
        cliente.nombre = "Rul"
        cliente.apellidos = "Prueba"
        mClienteDao!!.insertAll(cliente)
        val byName = mClienteDao!!.findByName("Rul", null)
        assertThat(byName, equalTo(cliente))
    }
}
