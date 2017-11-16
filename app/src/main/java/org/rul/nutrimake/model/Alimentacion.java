package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.converter.DateConverter;

import java.util.Date;

/**
 * Created by Rul on 02/11/2017.
 */

@Entity(foreignKeys = @ForeignKey(entity = Cliente.class,
                                    parentColumns = "id",
                                    childColumns = "cliente_id"))
@TypeConverters(DateConverter.class)
public class Alimentacion {

    public @PrimaryKey int id;
    @ColumnInfo(name = "cliente_id")
    public int clienteId;
    public String descripcion;
    public Date fechaInicio;
    public Date fechaFin;
    public boolean activa;


}
