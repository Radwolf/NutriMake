package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Rul on 02/11/2017.
 */

@Entity
class Cliente {

    @PrimaryKey(autoGenerate = true) Long id;
    String nombre;
    String apellidos;
    String telefono;
    String email;
    String documentoIdentidad;
    //Enum o lista_valor
    String sexo;
    Long edad;
    Long peso;
    Long altura;
    Long imc;
    Long benedite;
    boolean ejercicio;
    String tipoEjercicio;
    Long frecuenciaEjercicio;
    @Embedded
    Biotipo biotipo;
    
    Date fechaAlta;
    Date fecheBaja;
}
