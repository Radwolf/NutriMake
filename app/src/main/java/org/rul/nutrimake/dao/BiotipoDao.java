package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Biotipo;

import java.util.List;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
public interface BiotipoDao {

    //Listar todas los biotipos
    @Query("SELECT * FROM biotipo")
    List<Biotipo> findAll();

    //Recupera un biotipo por Id
    @Query("SELECT * FROM biotipo WHERE id = :id")
    Biotipo findById(Long id);
}
