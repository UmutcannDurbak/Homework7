package com.example.homework7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.homework7.data.entity.Tasks

@Dao
interface TasksDao {
    @Query("SELECT * FROM taskler")
    suspend fun addTasks() : List<Tasks>

    @Insert
    suspend fun kaydet(task: Tasks)

    @Update
    suspend fun update(task: Tasks)

    @Delete
    suspend fun delete(task: Tasks)

    @Query("SELECT * FROM taskler WHERE task_name like '%'|| :aramaKelimesi ||'%' ")
    suspend fun search(aramaKelimesi:String) : List<Tasks>
}