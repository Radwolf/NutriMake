package org.rul.nutrimake.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Comida;

import java.util.List;

/**
 * Created by Rul on 02/11/2017.
 */
@Dao
public interface ComidaDao {

    //Listar todas las Comidas
    @Query("SELECT * FROM comida")
    List<Comida> findAll();

    //Recupera una comida por Id
    @Query("SELECT * FROM comida WHERE id = :id")
    Comida findById(Long id);
    
    //Listar todas las comidas asociadas a una alimentación
    @Query("SELECT * FROM comida WHERE alimentacionId = :alimentacionId")
    List<Comida> findByAlimentacion(Long alimentacionId);
    
    //Listar Comidas de una alimentación de un tipo de comida en concreto
    @Query("SELECT * FROM comida WHERE alimentacionId = :alimentacionId AND tipoComida = :tipoComida")
    List<Comida> findByAlimentacionByTipoComida(Long alimentacionId, String tipoComida);
    
    //Listar las Comidas de una alimentación para un día
    @Query("SELECT * FROM comida WHERE alimentacionId = :alimentacionId AND numeroDiaPlan = :numeroDiaPlan")
    List<Comida> findByAlimentacionByNumeroDiaPlan(Long alimentacionId, Long numeroDiaPlan);
    
}
