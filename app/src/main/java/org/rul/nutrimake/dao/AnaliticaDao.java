package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.converter.DateConverter;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.ABORT;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface AnaliticaDao {

    @Query("SELECT * From analitica")
    LiveData<List<Analitica>> findAll();

    @Insert(onConflict = ABORT)
    void insertAnalitica(Analitica analitica);

    @Query("DELETE FROM analitica")
    void deleteAll();
}
