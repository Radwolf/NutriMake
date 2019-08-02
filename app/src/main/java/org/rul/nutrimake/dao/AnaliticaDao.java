package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.model.converter.DateConverter;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.ABORT;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface AnaliticaDao {

    //Añadir Analítica a un cliente
    @Insert(onConflict = REPLACE) //Modificar Analítica
    void insert(Analitica analitica);
    
    //Listar todas las Analíticas
    @Query("SELECT * From analitica")
    List<Analitica> findAll();

    //Recuperar una Analítica por id
    @Query("SELECT * FROM analitica WHERE id = :id")
    Analitica findById(Long id);
    
    //Listar todas las Analíticas de un cliente
    @Query("SELECT * FROM analitica WHERE clienteId = :clienteId")
    List<Analitica> findByCliente(Long clienteId);

    //Recuperar la última Analítica de un Cliente
    @Query("SELECT * FROM analitica WHERE clienteId = :clienteId ORDER BY fecha DESC")
    Analitica findByClienteLastAnalitica(Long clienteId);

    //Eliminar una Analítica
    @Delete
    void delete(Analitica analitica);
    
    ///////////////////////////////
    // Otros métodos             //
    ///////////////////////////////
    
    @Query("DELETE FROM analitica")
    void deleteAll();


}
