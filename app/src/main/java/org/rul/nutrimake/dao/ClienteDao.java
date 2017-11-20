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
    
    //Nuevo Cliente    
    @Insert(onConflict = REPLACE) //Modificar datos Cliente
    void insert(Cliente cliente);
    
    //Lista Clientes
    @Query("select * from cliente")
    List<Cliente> findAll();
    
    //Recuperar un Cliente por id
    @Query("select * from cliente where id = :id")
    Cliente findById(int id);

    //Recuperar un Cliente por nombre y/o apellidos
    @Query("select * from cliente where nombre = :nombre and apellidos = :apellidos")
    List<Cliente> findByNameAndLastName(String nombre, String apellidos);
    
    //Eliminar un Cliente
    @Delete
    void delete(Cliente cliente);

    ////////////////////////////////
    // Otros metodos para pruebas //
    ////////////////////////////////
    
    @Insert(onConflict = IGNORE)
    void insertOrReplaceClientes(Cliente... clientes);

    @Query("delete from cliente where nombre like :badName OR apellidos like :badName")
    int deleteClientesByNombre(String badName);

    @Delete
    void deleteClientes(Cliente cliente1, Cliente cliente2);

    @Query("SELECT * FROM Cliente WHERE :edad == :edad") // TODO: Fix this!
    List<Cliente> findYoungerThan(int edad);

    @Query("SELECT * FROM Cliente WHERE edad < :edad")
    List<Cliente> findYoungerThanSolution(int edad);

    @Query("DELETE FROM Cliente")
    void deleteAll();
    
}
