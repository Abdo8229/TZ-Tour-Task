package com.abdelrahman.ramadan.tz_.data.usecase.tasksdatausecase

import com.abdelrahman.ramadan.tz_.data.pojo.data.GroupedTasks
import com.abdelrahman.ramadan.tz_.data.pojo.data.TasksResponse
import com.abdelrahman.ramadan.tz_.data.repo.TasksDataRepoImp
import com.abdelrahman.ramadan.tz_.utils.DataTaskStats
import com.abdelrahman.ramadan.tz_.utils.TasksDataUseCaseStats
import javax.inject.Inject

class TasksDataUseCase @Inject constructor(private val tasksDataRepoImp: TasksDataRepoImp) {
    private fun iniTHasMap(groupedTasks: MutableList<GroupedTasks>): HashMap<TasksResponse, List<TasksResponse>> {
        val hashMap = HashMap<TasksResponse, List<TasksResponse>>()
        groupedTasks.forEach { groupedTasks ->
            if (groupedTasks.task.size == 1) {
                hashMap[groupedTasks.task[0]] = emptyList()
            } else {
                hashMap[groupedTasks.task[0]] = groupedTasks.task.subList(1, groupedTasks.task.size)
            }
        }

        return hashMap
    }

    suspend fun getTasksAsHashMapHeaderAndFooter(
        auth: String,
        cookie: String
    ): TasksDataUseCaseStats {
        return when (val response = tasksDataRepoImp.getTasks(auth, cookie)) {
            is DataTaskStats.Success -> {
                TasksDataUseCaseStats.Success(iniTHasMap(response.responseDay.groupedTasks))
            }

            is DataTaskStats.Error -> {
                TasksDataUseCaseStats.Error(response.error)
            }

            is DataTaskStats.Loading -> {
                TasksDataUseCaseStats.Loading
            }
        }
    }

}