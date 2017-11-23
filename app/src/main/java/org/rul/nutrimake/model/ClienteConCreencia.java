package org.rul.nutrimake.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Relation;

import org.rul.nutrimake.model.Cliente;
import org.rul.nutrimake.model.ClienteCreencia;
import org.rul.nutrimake.model.Creencia;

import java.util.List;

/**
 * Created by Rul on 17/11/2017.
 */

@Entity
public class ClienteConCreencia {

    @Embedded
    public Cliente cliente;
    @Relation(parentColumn = "id", entityColumn = "clienteId", entity = ClienteCreencia.class, projection = {"creenciaId"})
    public List<Long> creencias;

}
