package org.rul.nutrimake.model

import android.arch.persistence.room.*
import android.graphics.Bitmap

/**
 * Created by Rul on 11/10/2017.
 */
@Entity(tableName = "cliente", indices = arrayOf(Index("idx_nombre_completo"), Index(value = *arrayOf("nombre", "apellidos"))))
class Cliente {

    @PrimaryKey
    var id: Int = 0

    @ColumnInfo(name = "nombre")
    var nombre: String? = null

    @ColumnInfo(name = "apellidos")
    var apellidos: String? = null

    @Ignore
    internal var picture: Bitmap? = null

    constructor(nombre: String?, apellidos: String?) {
        this.nombre = nombre
        this.apellidos = apellidos
    }
}