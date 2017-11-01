package org.rul.nutrimake.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 02/11/2017.
 */

@Entity
public class Cliente {

    public @PrimaryKey String id;
    public String nombre;
    public String apellidos;
    public int edad;
}
