package com.example.homework7.data.repo

import com.example.homework7.data.datasource.TasksDataSource
import com.example.homework7.data.entity.Tasks

class TasksRepository(var kds:TasksDataSource) {
    //var kds = TasksDataSource()

    suspend fun kaydet(task_name: String) = kds.kaydet(task_name)

    suspend fun update(task_id:Int, task_name:String) = kds.update(task_id, task_name)

    suspend fun delete(task_id: Int) = kds.delete(task_id)

    suspend fun addTasks() : List<Tasks> = kds.addTasks()

    suspend fun search(aramaKelimesi:String) : List<Tasks> = kds.search(aramaKelimesi)
}