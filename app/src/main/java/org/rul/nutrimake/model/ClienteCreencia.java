package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 17/11/2017.
 */

@Entity(primaryKeys = { "clienteId", "creenciaId" },
        foreignKeys = { @ForeignKey(entity = Cliente.class,
                        parentColumns = "id",
                        childColumns = "clienteId"),
                        @ForeignKey(entity = Creencia.class,
                        parentColumns = "id",
                        childColumns = "creenciaId")})
public class ClienteCreencia {

    public Long clienteId;
    public Long creenciaId;
}
