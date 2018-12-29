package com.example.afsal.roomtutorial.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.afsal.roomtutorial.daos.TaskDao
import com.example.afsal.roomtutorial.models.Task


@Database(entities = arrayOf(Task::class), version = 1)
abstract class DatabaseHelper: RoomDatabase(){

    abstract fun taskDao(): TaskDao

    companion object {
        private var INSTANCE: DatabaseHelper? = null
        fun getInstance(context: Context): DatabaseHelper {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    DatabaseHelper::class.java,
                    "roomdb")
                    .build()
            }
            return INSTANCE as DatabaseHelper
        }
    }



}