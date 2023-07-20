package com.example.studentregistration.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase:RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {           //It provides a way to access the database instance and avoid multiple instances being created.
        @Volatile
        private var INSTANCE: StudentDatabase? = null //ensures that the value of INSTANCE is always up-to-date across all execution threads.
        //This function is used to retrieve the singleton instance of the StudentDatabase
        fun getINSTANCE(context: Context): StudentDatabase {
        synchronized(this){
            var instance = INSTANCE
            if (instance==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_data_database"
                ).build()
            }
            return instance
        }
        }
    }
}