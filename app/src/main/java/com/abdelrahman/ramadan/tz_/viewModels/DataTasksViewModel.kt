package com.abdelrahman.ramadan.tz_.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdelrahman.ramadan.tz_.data.repo.AuthRepoImp
import com.abdelrahman.ramadan.tz_.data.repo.TasksDataRepoImp
import com.abdelrahman.ramadan.tz_.data.usecase.tasksdatausecase.TasksDataUseCase
import com.abdelrahman.ramadan.tz_.utils.DataTaskStats
import com.abdelrahman.ramadan.tz_.utils.TasksDataUseCaseStats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataTasksViewModel
@Inject
constructor(private val useCase: TasksDataUseCase) : ViewModel() {
    private var _mutableDataTasksStateFlow: MutableStateFlow<TasksDataUseCaseStats> =
        MutableStateFlow(TasksDataUseCaseStats.Loading)
    val TasksDataStatsFlow: StateFlow<TasksDataUseCaseStats> = _mutableDataTasksStateFlow
    fun getTasks(auth: String, cookie: String) {
        viewModelScope.launch(Dispatchers.IO) {
           when(val response =  useCase.getTasksAsHashMapHeaderAndFooter(auth, cookie)){
               is TasksDataUseCaseStats.Success -> {
                   _mutableDataTasksStateFlow.value = TasksDataUseCaseStats.Success(response.header ,response.hashMap)
               }
               is TasksDataUseCaseStats.Error -> {
                   _mutableDataTasksStateFlow.value = TasksDataUseCaseStats.Error(response.error)
               }
                is TasksDataUseCaseStats.Loading -> {
                     _mutableDataTasksStateFlow.value = TasksDataUseCaseStats.Loading
                }

           }
        }
    }
}