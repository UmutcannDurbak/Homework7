package com.example.homework7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework7.R
import com.example.homework7.databinding.FragmentAnasayfaBinding
import com.example.homework7.ui.adapter.TasksAdapter
import com.example.homework7.ui.viewmodel.AnasayfaViewModel
import com.example.homework7.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)


        viewModel.tasksListesi.observe(viewLifecycleOwner){
            val tasksAdapter = TasksAdapter(requireContext(), it, viewModel)
            binding.tasksRv.adapter = tasksAdapter
        }


        binding.tasksRv.layoutManager = LinearLayoutManager(requireContext())

//        binding.tasksRv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        binding.fab.setOnClickListener {
            //Navigation.findNavController(it).navigate(R.id.taskKayitGecis)
            Navigation.gecis(it,R.id.taskKayitGecis)
        }


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.addTasks()
    }
}