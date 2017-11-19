package org.rul.nutrimake.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 17/11/2017.
 */

@Entity
public class Alimento {

    public @PrimaryKey(autoGenerate = true) Long id;
    @Embedded
    public ValorNutricional valorNutricional;
    public String nombre;
    public String grupo;
}
