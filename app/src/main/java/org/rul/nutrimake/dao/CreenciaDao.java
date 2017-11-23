package org.rul.nutrimake.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.rul.nutrimake.model.Creencia;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.FAIL;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
public interface CreenciaDao {

    //Añadir Creencia
    @Insert(onConflict = FAIL) //Modificar Creencia
    void insert(Creencia creencia);

    //Listar todas las Creencias
    @Query("SELECT * FROM creencia")
    List<Creencia> findAll();

    //Recupera una Creencia por Id
    @Query("SELECT * FROM creencia WHERE id = :id")
    Creencia findById(Long id);

    //Recupera una Creencia por nombre
    @Query("SELECT * FROM creencia WHERE nombre = :nombre")
    Creencia findByNombre(String nombre);
}
