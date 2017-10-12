package org.rul.nutrimake.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey



/**
 * Created by Rul on 11/10/2017.
 */
@Entity(tableName = "analitica", foreignKeys = arrayOf(ForeignKey(entity = Cliente::class, parentColumns = arrayOf("id"), childColumns = arrayOf("cliente_id"))))
internal class Analitica {
    @PrimaryKey
    var id: Int = 0

    var descripcion: String? = null

    @ColumnInfo(name = "cliente_id")
    var clienteId: Int = 0
}