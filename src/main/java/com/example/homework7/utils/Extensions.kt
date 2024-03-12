package com.example.homework7.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.homework7.R

fun Navigation.gecis(it:View,id:Int){
    findNavController(it).navigate(id)
}

fun Navigation.gecis(it:View,id:NavDirections){
    findNavController(it).navigate(id)
}