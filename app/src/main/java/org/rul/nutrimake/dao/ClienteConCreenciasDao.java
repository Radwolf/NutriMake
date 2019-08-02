package org.rul.nutrimake.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.model.ClienteCreencia;
import org.rul.nutrimake.model.Creencia;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.FAIL;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
public interface ClienteConCreenciasDao {

    //Añadir ClienteCreencia
    @Insert(onConflict = FAIL)
    void insert(Cliente cliente, List<Long> creencias);


}
