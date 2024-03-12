package com.example.homework7.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homework7.databinding.FragmentTaskKayitBinding
import com.example.homework7.ui.viewmodel.TaskKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskKayitFragment : Fragment() {
    private lateinit var binding: FragmentTaskKayitBinding
    private lateinit var viewModel: TaskKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTaskKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val task_name = binding.editTextTaskName.text.toString()
            viewModel.kaydet(task_name)

        }

        return binding.root
    }


    fun kaydet(task_name: String){
        Log.e("Add Task", "$task_name")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:TaskKayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}