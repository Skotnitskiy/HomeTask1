package com.gh.interfaces;

import com.gh.realization.Task;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ITaskManager {

    public void addTask(Date date, Task task);

    public void removeTask(Date date);

    public Collection<String> getCategories();

    //For next 3 methods tasks should be sorted by scheduled date
    public Map<String, List<Task>> getTasksByCategories();

    public List<Task> getTasksByCategory(String category);

    public List<Task> getTasksForToday();

}