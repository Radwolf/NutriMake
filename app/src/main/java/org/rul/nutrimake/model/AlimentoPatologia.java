package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 17/11/2017.
 */

@Entity(primaryKeys = { "alimentoId", "patologiaId" },
        foreignKeys = { @ForeignKey(entity = Alimento.class,
                        parentColumns = "id",
                        childColumns = "alimentoId"),
                        @ForeignKey(entity = Patologia.class,
                        parentColumns = "id",
                        childColumns = "patologiaId")})
public class AlimentoPatologia {

    public Long alimentoId;
    public Long patologiaId;
}
