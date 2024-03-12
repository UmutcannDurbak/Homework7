package com.example.homework7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework7.data.entity.Tasks

@Database(entities = [Tasks::class], version = 1)
abstract class Veritabani : RoomDatabase(){
    abstract fun getTasksDao() : TasksDao

}