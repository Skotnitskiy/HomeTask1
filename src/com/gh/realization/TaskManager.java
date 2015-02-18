package com.gh.realization;

import com.gh.Const;
import com.gh.interfaces.ITaskManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManager implements ITaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<Task>();
    }

    private Date cheekDate(Date date, String format) {
        DateFormat sd = new SimpleDateFormat(format);
        try {
            date = sd.parse(sd.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public void addTask(Date date, Task task) {
        task.setDate(cheekDate(date, Const.DMY));
        this.tasks.add(task);
    }

    @Override
    public void removeTask(Date date) {
        Date formatedDate = cheekDate(date, Const.DMY);
        for (Iterator<Task> taskIter = this.tasks.iterator(); taskIter.hasNext(); ) {
            Task task = taskIter.next();
            if (task.getDate().equals(formatedDate)) {
                taskIter.remove();
                return;
            }
        }
    }

    @Override
    public Collection<String> getCategories() {
        List<String> categories = new ArrayList();
        for (Task task : this.tasks) {
            categories.add(task.getCategory());
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories() {
        Map<String, List<Task>> tasks = new HashMap<String, List<Task>>();
        List<String> categories = (List<String>) getCategories();
        int ln = categories.size();
        String category;
        for (int index = 0; index < ln; index++) {
            category = categories.get(index);
            tasks.put(category, getTasksByCategory(category));
        }

        return tasks;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> tasks = new ArrayList<Task>();
        for (Task task : this.tasks) {
            if (category.equals(task.getCategory())) {
                tasks.add(task);
            }
        }
        Collections.sort(tasks);
        return tasks;
    }

    @Override
    public List<Task> getTasksForToday() {
        Date date = Calendar.getInstance().getTime();
        Date dateToday = cheekDate(date, Const.DMY);
        List<Task> tasks = new ArrayList<Task>();
        for (Task task : this.tasks) {
            if (task.getDate().equals(dateToday)) {
                tasks.add(task);
            }
        } Collections.sort(tasks);
        return tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
