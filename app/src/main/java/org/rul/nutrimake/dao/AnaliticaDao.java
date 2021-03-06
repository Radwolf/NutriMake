package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
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

    @Query("SELECT * From analitica")
    List<Analitica> findAll();

    @Insert(onConflict = REPLACE)
    void insertAnalitica(Analitica analitica);

    @Query("DELETE FROM analitica")
    void deleteAll();

    @Query("SELECT * FROM analitica WHERE clienteId = :clienteId")
    List<Analitica> findByCliente(Long clienteId);

    @Query("SELECT * FROM analitica WHERE clienteId = :clienteId ORDER BY fecha DESC")
    Analitica getLastAnalitica(Long clienteId);
}
