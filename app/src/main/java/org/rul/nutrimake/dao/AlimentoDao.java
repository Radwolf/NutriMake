package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Alimento;
import org.rul.nutrimake.model.converter.DateConverter;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface AlimentoDao {

    //Añadir una Alimento
    @Insert(onConflict = REPLACE) //Modificamos una Alimento
    void insert(Alimento alimento);

    //Lista todos los Alimentos registrados
    @Query("SELECT * FROM alimento")
    List<Alimento> findAll();

    //Recupera un Alimento por Id
    @Query("SELECT * FROM alimento WHERE id = :id")
    Alimento findById(Long id);
    
    //Lista de todas las Alimento por grupo
    @Query("SELECT * FROM alimento WHERE grupo = :grupo")
    List<Alimento> findByGrupo(String grupo);
    
    //Recupera la última Alimento activa
    @Query("SELECT * FROM alimento WHERE nombre = :nombre")
    Alimento findByNombre(String nombre);
    
    //Eliminar un alimento
    @Delete
    void delete(Alimento alimento);

}
