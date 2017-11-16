package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 02/11/2017.
 */

@Entity(foreignKeys = @ForeignKey(entity = Biotipo.class,
                                    parentColumns = "id",
                                    childColumns = "biotipo_id"))
public class Cliente {

    public @PrimaryKey int id;
    public String nombre;
    public String apellidos;
    public String sexo;
    public int edad;
    public int peso;
    public int altura;
    public int imc;
    public int benedite;
    public boolean ejercicio;
    public String tipoEjercicio;
    public int frecuenciaEjercicio;
    @ColumnInfo(name = "biotipo_id")
    public int biotipo;
}
