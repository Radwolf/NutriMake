package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 02/11/2017.
 */

@Entity
public class Cliente {

    public @PrimaryKey(autoGenerate = true) Long id;
    public String nombre;
    public String apellidos;
    public String sexo;
    public Long edad;
    public Long peso;
    public Long altura;
    public Long imc;
    public Long benedite;
    public boolean ejercicio;
    public String tipoEjercicio;
    public Long frecuenciaEjercicio;
    @Embedded
    public Biotipo biotipo;
}
