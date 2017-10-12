package org.rul.nutrimake.model.projection

import android.arch.persistence.room.ColumnInfo



/**
 * Created by Rul on 12/10/2017.
 */
class NombreClientes {
    @ColumnInfo(name = "nombre")
    var nombre: String? = null

    @ColumnInfo(name = "apellidos")
    var apellidos: String? = null
}