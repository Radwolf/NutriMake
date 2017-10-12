package org.rul.nutrimake.configuration.db

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.TypeConverters
import org.rul.nutrimake.dao.ClienteDao
import org.rul.nutrimake.model.Cliente
import org.rul.nutrimake.model.converter.Converters


/**
 * Created by Rul on 11/10/2017.
 */
@Database(entities = arrayOf(Cliente::class), version = 1)
@TypeConverters(Converters::class)
abstract class TestDatabase : RoomDatabase() {
    abstract fun getClienteDao(): ClienteDao
}