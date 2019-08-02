package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Patologia;

import java.util.List;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
public interface PatologiaDao {

    //Listar todas las Patologias
    @Query("SELECT * FROM patologia")
    List<Patologia> findAll();

    //Recupera una patologia por Id
    @Query("SELECT * FROM patologia WHERE id = :id")
    Patologia findById(Long id);
}
