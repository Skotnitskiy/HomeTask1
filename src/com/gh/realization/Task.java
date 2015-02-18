package com.gh.realization;

import java.util.Comparator;
import java.util.Date;

public class Task implements Comparable<Task> {
    private String category;
    private String description;
    private Date date;

    public Task(String category, String description) {
        this.category = category;
        this.description = description;
    }

    @Override
    public int compareTo(Task task) {
        return this.date.compareTo(task.getDate());
    }

    @Override
    public String toString() {
        String str = "";
            str += "Category: " + this.getCategory() + "\n" +
                    "Description: " + this.getDescription() + "\n" +
                    "Date: " + this.getDate() + "\n" +
                    "-------------------------------------------\n";
        return str;
    }

    public Task() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
