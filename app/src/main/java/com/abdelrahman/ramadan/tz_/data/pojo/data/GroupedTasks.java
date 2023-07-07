package com.abdelrahman.ramadan.tz_.data.pojo.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class GroupedTasks {
    @Element(name = "groupedTask", required = false)
    GroupedTask groupedTask;

    @ElementList(entry = "task", inline = true)
    List<TasksResponse> task;

    public GroupedTask getGroupedTask() {
        return groupedTask;
    }

    public void setGroupedTask(GroupedTask groupedTask) {
        this.groupedTask = groupedTask;
    }

    @Attribute(name = "mainRideId")
    String mainRideId;
    public String getMainRideId() {
        return mainRideId;
    }

    public void setMainRideId(String mainRideId) {
        this.mainRideId = mainRideId;
    }



    public List<TasksResponse> getTask() {
        return task;
    }

    public void setTask(List<TasksResponse> task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "GroupedTasks{" +
                "groupedTask=" + groupedTask +
                ", task=" + task +
                ", mainRideId='" + mainRideId + '\'' +
                '}';
    }
}
