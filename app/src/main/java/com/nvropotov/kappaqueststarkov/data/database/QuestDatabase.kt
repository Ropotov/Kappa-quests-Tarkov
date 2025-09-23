package com.nvropotov.kappaqueststarkov.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [QuestEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class QuestDatabase : RoomDatabase() {
    abstract fun dao(): QuestDao

    companion object {
        private var database: QuestDatabase? = null
        private val ANY = Any()

        fun getMainDatabase(context: Context): QuestDatabase {
            synchronized(ANY) {
                database?.let {
                    return it
                }
                val instance = Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = QuestDatabase::class.java,
                    name = "characterDb"
                )
                    .build()
                database = instance
                return instance
            }
        }
    }
}