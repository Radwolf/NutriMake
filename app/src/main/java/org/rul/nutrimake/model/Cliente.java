package org.rul.nutrimake.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.converter.DateConverter;

import java.util.Date;
import java.util.List;

/**
 * Created by Rul on 02/11/2017.
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = Biotipo.class,
                parentColumns = "id",
                childColumns = "biotipoId")
})
@TypeConverters(DateConverter.class)
public class Cliente {

    public @PrimaryKey(autoGenerate = true) Long id;
    public String nombre;
    public String apellidos;
    public String telefono;
    public String email;
    public String documentoIdentidad;
    //Enum o lista_valor
    public String sexo;
    public Long edad;
    public Long peso;
    public Long altura;
    public Long imc;
    public Long benedite;
    public boolean ejercicio;
    //Enum o lista_valor
    public String tipoEjercicio;
    public Long frecuenciaEjercicio;
    public Long biotipoId;

    public Date fechaAlta;
    public Date fecheBaja;

}
