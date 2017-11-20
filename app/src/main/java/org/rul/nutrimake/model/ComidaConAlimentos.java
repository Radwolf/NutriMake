package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import org.rul.nutrimake.model.Alimentacion;
import org.rul.nutrimake.model.Cliente;

import java.time.LocalDate;

/**
 * Created by Rul on 02/11/2017.
 */

class ComidaConAlimentos {

    @Embedded
    Comida comida;
    @Relation(parentColumn = "id", entityColumn = "comidaId", entity = Alimento.class)
    List<Alimentos> alimentos;
    Long cantidad;

}
