package com.michael.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.michael.todoapp.data.ToDoDao
import com.michael.todoapp.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }
}