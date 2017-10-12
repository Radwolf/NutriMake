package org.rul.nutrimake.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.database.Cursor
import io.reactivex.Flowable
import org.rul.nutrimake.model.Cliente
import org.rul.nutrimake.model.projection.NombreClientes


/**
 * Created by Rul on 11/10/2017.
 */
@Dao
interface ClienteDao {
    @get:Query("SELECT * FROM cliente")
    val all: List<Cliente>

    @Query("SELECT * FROM cliente WHERE uid IN (:clienteIds)")
    fun loadAllByIds(clienteIds: IntArray): List<Cliente>

    @Query("SELECT * FROM cliente WHERE nombre LIKE :pNombre AND " + " apellidos LIKE :pApellidos LIMIT 1")
    fun findByName(pNombre: String, pApellidos: String?): Cliente

    //LiveData ejemplo
    @Query("SELECT nombre, apellidos FROM cliente")
    fun loadFullName(): LiveData<List<NombreClientes>>

    //RxJava2 ejemplo
    @Query("SELECT * from cliente where id = :id LIMIT 1")
    fun loadClienteById(id: Int): Flowable<Cliente>

    @Query("SELECT * FROM cliente " +
            " INNER JOIN analitica ON analitica.cliente_id = cliente.id LIMIT 5")
    fun loadRawClienteConAnalitica(minAge: Int): Cursor

    @Insert
    fun insertAll(vararg clientes: Cliente)

    @Delete
    fun delete(cliente: Cliente)
}
