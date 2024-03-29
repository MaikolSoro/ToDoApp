package com.michael.todoapp.data.data_source

import android.content.Context
import androidx.room.*
import com.michael.todoapp.data.Converter
import com.michael.todoapp.data.models.ToDoData

@Database(
    entities = [ToDoData::class], version = 2, exportSchema = false
)
@TypeConverters(Converter::class)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ToDoDatabase::class.java, "todo_database"
            )
                .build()

    }
}
