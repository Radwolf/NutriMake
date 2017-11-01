package org.rul.nutrimake.configuration.db

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.TypeConverters


/**
 * Created by Rul on 11/10/2017.
 */
@Database(entities = arrayOf(ClienteKt::class), version = 1)
@TypeConverters(Converters::class)
abstract class TestDatabase : RoomDatabase() {
    abstract fun getClienteDao(): ClienteDaoKt
}