package com.abdelrahman.ramadan.tz_.data.pojo.data;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "response",strict = false)

public class ResponseDay {


    @ElementList(name = "groupedTasks")
    public List<GroupedTasks> groupedTasks;

    public List<GroupedTasks> getGroupedTasks() {
        return groupedTasks;
    }

    public void setGroupedTasks(List<GroupedTasks> groupedTasks) {
        this.groupedTasks = groupedTasks;

    }

    @Override
    public String toString() {
        return "ResponseDay{" +
                "groupedTasks=" + groupedTasks +
                '}';
    }
}
