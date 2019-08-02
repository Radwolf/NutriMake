package org.rul.nutrimake.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.rul.nutrimake.model.ClienteCreencia;
import org.rul.nutrimake.model.Creencia;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.FAIL;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
public interface ClienteCreenciaDao {

    //Añadir ClienteCreencia
    @Insert(onConflict = FAIL)
    void insert(ClienteCreencia clienteCreencia);

    //Listar todas las Creencias
    @Query("SELECT * FROM creencia")
    List<Creencia> findAll();

    //Recupera una ClienteCreencia por Id
    @Query("SELECT * FROM clienteCreencia WHERE clienteId = :clienteId")
    List<ClienteCreencia> findByCliente(Long clienteId);

    //Recupera una ClienteCreencia por nombre
    @Query("SELECT * FROM clienteCreencia WHERE creenciaId = :creenciaId")
    List<ClienteCreencia> findByCreencia(Long creenciaId);
}
