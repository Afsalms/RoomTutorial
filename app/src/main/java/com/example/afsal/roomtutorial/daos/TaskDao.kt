package com.example.afsal.roomtutorial.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.afsal.roomtutorial.models.Task

@Dao
interface TaskDao {

    @Insert
    fun addNewTask(task: Task)


    @Query("SELECT * from task order by id desc")
    fun getAllTask():List<Task>




}