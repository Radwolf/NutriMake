package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 17/11/2017.
 */

@Entity(primaryKeys = {"alimentoId", "comidaId"},
        foreignKeys = { @ForeignKey(entity = Alimento.class,
                        parentColumns = "id",
                        childColumns = "alimentoIdd"),
                        @ForeignKey(entity = Comida.class,
                        parentColumns = "id",
                        childColumns = "comidaId")})
class AlimentoComida {

    Long alimentoId;
    Long comidaId;
    Long cantidad;
}
