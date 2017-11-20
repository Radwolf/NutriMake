package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Alimentacion;
import org.rul.nutrimake.model.converter.DateConverter;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface AlimentacionDao {

    //Añadir una Alimentación a un Cliente
    @Insert(onConflict = REPLACE) //Modificamos una Alimentación
    void insert(Alimentacion alimentacion);

    //Lista todas las Alimentaciones registradas
    @Query("SELECT * FROM alimentacion")
    List<Alimentacion> findAll();

    //Recupera una Alimentación por Id
    @Query("SELECT * FROM alimentacion WHERE id = :id")
    Alimentacion findById(Long id);
    
    //Lista de todas las Alimentaciones de un Cliente
    @Query("SELECT * FROM alimentacion WHERE clienteId = :clienteId")
    List<Alimentacion> findByCliente(Long clienteId);
    
    //Recupera la última Alimentación activa
    @Query("SELECT * FROM analitica WHERE clienteId = :clienteId AND fechaFin IS null")
    Alimentacion findByClienteLastAlimentacion(Long clienteId);
    
    //Eliminar una Alimentación de un Cliente
    @Delete
    void delete(Alimentacion alimentacion);

}
