package org.rul.nutrimake.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.rul.nutrimake.model.Cliente;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
public interface ClienteDao {

    @Query("select * from cliente")
    List<Cliente> loadAllClientes();

    @Query("select * from cliente where id = :id")
    Cliente loadClienteById(int id);

    @Query("select * from cliente where nombre = :nombre and apellidos = :apellidos")
    List<Cliente> findByNameAndLastName(String nombre, String apellidos);

    @Insert(onConflict = IGNORE)
    void insertCliente(Cliente cliente);

    @Delete
    void deleteCliente(Cliente cliente);

    @Query("delete from cliente where nombre like :badName OR apellidos like :badName")
    int deleteClientesByNombre(String badName);

    @Insert(onConflict = IGNORE)
    void insertOrReplaceClientes(Cliente... clientes);

    @Delete
    void deleteClientes(Cliente cliente1, Cliente cliente2);

    @Query("SELECT * FROM Cliente WHERE :edad == :edad") // TODO: Fix this!
    List<Cliente> findYoungerThan(int edad);

    @Query("SELECT * FROM Cliente WHERE edad < :edad")
    List<Cliente> findYoungerThanSolution(int edad);

    @Query("DELETE FROM Cliente")
    void deleteAll();
    
}
