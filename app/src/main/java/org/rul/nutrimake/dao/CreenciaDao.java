package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Creencia;

import java.util.List;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
public interface CreenciaDao {

    //Listar todas las Creencias
    @Query("SELECT * FROM creencia")
    List<Creencia> findAll();

    //Recupera una Creencia por Id
    @Query("SELECT * FROM creencia WHERE id = :id")
    Creencia findById(Long id);
}
