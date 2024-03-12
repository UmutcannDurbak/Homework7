package com.example.homework7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.homework7.databinding.FragmentTaskDetayBinding
import com.example.homework7.ui.viewmodel.TaskDetayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TaskDetayFragment : Fragment() {
    private lateinit var binding: FragmentTaskDetayBinding
    private lateinit var viewModel: TaskDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTaskDetayBinding.inflate(inflater, container, false)

        val bundle:TaskDetayFragmentArgs by navArgs()
        val gelenTask = bundle.task

        binding.editTextTaskName.setText(gelenTask.task_name)

        binding.buttonGNcelle.setOnClickListener {
            val task_name = binding.editTextTaskName.text.toString()
            viewModel.update(gelenTask.task_id,task_name)
        }

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TaskDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

}