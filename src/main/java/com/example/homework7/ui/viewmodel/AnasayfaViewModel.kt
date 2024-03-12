package com.example.homework7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework7.data.entity.Tasks
import com.example.homework7.data.repo.TasksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var krepo:TasksRepository): ViewModel() {

    //var krepo = TasksRepository()
    var tasksListesi = MutableLiveData<List<Tasks>>()

    init {
        addTasks()
    }

    fun delete(task_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.delete(task_id)
            addTasks()
        }
    }

    fun addTasks(){
        CoroutineScope(Dispatchers.Main).launch {
            tasksListesi.value = krepo.addTasks()
        }
    }

    fun search(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            tasksListesi.value = krepo.search(aramaKelimesi)
        }
    }
}