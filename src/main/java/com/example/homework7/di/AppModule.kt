package com.example.homework7.di

import android.content.Context
import androidx.room.Room
import com.example.homework7.data.datasource.TasksDataSource
import com.example.homework7.data.repo.TasksRepository
import com.example.homework7.room.TasksDao
import com.example.homework7.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTasksRepository(kds:TasksDataSource) : TasksRepository{
        return TasksRepository(kds)
    }

    @Provides
    @Singleton
    fun provideTasksDataSource(kdao:TasksDao) : TasksDataSource {
        return TasksDataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideTasksDao(@ApplicationContext context: Context) : TasksDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"todo.sqlite").createFromAsset("todo.sqlite").build()
        return  vt.getTasksDao()
    }
}