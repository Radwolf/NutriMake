package org.rul.nutrimake.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 17/11/2017.
 */

@Entity
public class Creencia {

    public @PrimaryKey(autoGenerate = true) Long id;
    public String nombre;
}
