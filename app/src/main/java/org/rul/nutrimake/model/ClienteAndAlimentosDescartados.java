package org.rul.nutrimake.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.arch.persistence.room.TypeConverters;

import org.rul.nutrimake.model.Biotipo;
import org.rul.nutrimake.model.converter.DateConverter;

import java.util.Date;
import java.util.List;

/**
 * Created by Rul on 02/11/2017.
 */

public class ClienteAndAlimentosDescartados {

    public Long id;
    @Relation(parentColumn = "id", entityColumn = "clienteId")
    public List<AlimentoNoGusta> alimentosNoGusta;

}
