package com.example.homework7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.homework7.data.repo.TasksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskKayitViewModel @Inject constructor(var krepo:TasksRepository): ViewModel() {
    //var krepo = TasksRepository()

    fun kaydet(task_name: String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.kaydet(task_name)
        }
    }
}