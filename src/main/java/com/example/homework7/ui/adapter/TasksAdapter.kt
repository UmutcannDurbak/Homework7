package com.example.homework7.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7.data.entity.Tasks
import com.example.homework7.databinding.CardTasarimBinding
import com.example.homework7.ui.fragment.AnasayfaFragmentDirections
import com.example.homework7.ui.viewmodel.AnasayfaViewModel
import com.example.homework7.utils.gecis
import com.google.android.material.snackbar.Snackbar

//Taslak-RecyclerView
//List >= ArrayList
class TasksAdapter(var mContext: Context,
                   var tasksListesi:List<Tasks>,
                   var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<TasksAdapter.CardTasarimHolder>(){

    inner class CardTasarimHolder(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)//card_tasarim.xml

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return  CardTasarimHolder(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {//0,1,2
        val task = tasksListesi.get(position)
        val t = holder.tasarim

        t.textViewTaskName.text = task.task_name

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.taskDetayGecis(task = task)
            //Navigation.findNavController(it).navigate(gecis)
            Navigation.gecis(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${task.task_name} silinsin mi? ", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.delete(task.task_id)
                }.show()
        }


    }

    override fun getItemCount(): Int {
        return tasksListesi.size
    }
}