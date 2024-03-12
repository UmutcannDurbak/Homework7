package com.example.homework7.data.datasource

import com.example.homework7.data.entity.Tasks
import com.example.homework7.room.TasksDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TasksDataSource(var kdao:TasksDao) {
    suspend fun kaydet(task_name: String){
        val yeniTask = Tasks(0,task_name)
        kdao.kaydet(yeniTask)
    }

    suspend fun update(task_id: Int, task_name: String){
        val updatedTask = Tasks(task_id, task_name)
        kdao.update(updatedTask)
    }

    suspend fun delete(task_id:Int){
        val silinenTask = Tasks(task_id,"")
        kdao.delete(silinenTask)
    }

    suspend fun addTasks() : List<Tasks> =
        withContext(Dispatchers.IO){
            return@withContext kdao.addTasks()
        }

    suspend fun search(aramaKelimesi:String) : List<Tasks> =
        withContext(Dispatchers.IO){
            return@withContext kdao.search(aramaKelimesi)
        }
}