package org.rul.nutrimake.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 17/11/2017.
 */

@Entity (indices = {@Index(value = {"nombre", "grado"},
        unique = true)})
public class Patologia {

    public @PrimaryKey(autoGenerate = true) Long id;
    public String nombre;
    public String grado;

}
