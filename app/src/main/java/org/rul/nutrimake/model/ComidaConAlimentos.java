package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;

import org.rul.nutrimake.model.Alimentacion;
import org.rul.nutrimake.model.Cliente;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Rul on 02/11/2017.
 */

public class ComidaConAlimentos {

    @Embedded
    public Comida comida;
    @Relation(parentColumn = "id", entityColumn = "comidaId", entity = Alimento.class)
    public List<Alimento> alimentos;
    public Long cantidad;

}
