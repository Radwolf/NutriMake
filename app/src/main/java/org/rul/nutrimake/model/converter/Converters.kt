package org.rul.nutrimake.model.converter

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * Created by Rul on 12/10/2017.
 */
object Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return (if (date == null) null else date.getTime())
    }
}