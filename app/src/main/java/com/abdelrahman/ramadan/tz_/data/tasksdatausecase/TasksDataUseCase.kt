package com.abdelrahman.ramadan.tz_.data.tasksdatausecase

import android.annotation.SuppressLint
import com.abdelrahman.ramadan.tz_.data.pojo.data.GroupedTasks
import com.abdelrahman.ramadan.tz_.data.pojo.data.TasksResponse
import com.abdelrahman.ramadan.tz_.data.repo.TasksDataRepoImp
import com.abdelrahman.ramadan.tz_.utils.DataTaskStats
import com.abdelrahman.ramadan.tz_.utils.TasksDataUseCaseStats
import okhttp3.internal.toImmutableList
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class TasksDataUseCase @Inject constructor(private val tasksDataRepoImp: TasksDataRepoImp) {
    private fun iniTHasMap(groupedTasks: MutableList<GroupedTasks>): HashMap<String, List<TasksResponse>> {
        val hashMap = HashMap<String, List<TasksResponse>>()
        groupedTasks.forEach { groupedTasks ->
            groupedTasks.task.forEach {
                if (hashMap[groupedTasks.mainRideId] == null)
                    hashMap[groupedTasks.mainRideId] = listOf(it)
                else
                    hashMap[groupedTasks.mainRideId] =
                        (hashMap[groupedTasks.mainRideId] ?: listOf()).toImmutableList().plus(it)


            }
//            if (groupedTasks.task.size == 1) {
//                hashMap[groupedTasks.task[0].rideId] = groupedTasks.task
//            } else {
//                hashMap[groupedTasks.task[0].rideId] = groupedTasks.task.subList(1, groupedTasks.task.size)
//            }
        }

        return hashMap
    }

    suspend fun getTasksAsHashMapHeaderAndFooter(
        auth: String,
        cookie: String
    ): TasksDataUseCaseStats {
        return try {
            when (val response = tasksDataRepoImp.getTasks(auth, cookie)) {
                is DataTaskStats.Success -> {
                    TasksDataUseCaseStats.Success(
                        initHeaderList(response.responseDay.groupedTasks),
                        iniTHasMap(response.responseDay.groupedTasks)
                    )
                }

                is DataTaskStats.Error -> {
                    TasksDataUseCaseStats.Error(response.error)
                }

                is DataTaskStats.Loading -> {
                    TasksDataUseCaseStats.Loading
                }
            }
        } catch (e: TimeoutException) {
            TasksDataUseCaseStats.Error("Server response "+e.message.toString())
        } catch (e: Exception) {
            TasksDataUseCaseStats.Error(e.message.toString())
        }


    }

    @SuppressLint("SuspiciousIndentation")
    private fun initHeaderList(tasks: List<GroupedTasks>): List<String> {
        val headerList = mutableListOf<String>()
        tasks.forEach {
            headerList.add(it.task.first().rideId)
        }
        return headerList
    }

}