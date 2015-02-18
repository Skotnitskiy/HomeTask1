package com.gh.realization;


import com.gh.Const;
import com.gh.interfaces.ISetOperations;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String args[]) {
        System.out.println("SetOperations 0");
        System.out.println("TaskManager 1");
        Integer way = null;
        try {
            way = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (way == Const.SET_OPERATIONS) {
            Set<Integer> objects1 = new HashSet<Integer>();
            Set<Integer> objects2 = new HashSet<Integer>();
            int k = 10;
            for (int i = 0; i <= k; i++) {
                objects1.add(i);
                objects2.add(i - k);
            }
            System.out.println("objects1: " + objects1);
            System.out.println("objects2: " + objects2);
            ISetOperations setOperator = new SetOperator();
            System.out.println("Equals: " + setOperator.equals(objects1, objects2));
            System.out.println("Union: " + setOperator.union(objects1, objects2));
            System.out.println("Subtract: " + setOperator.subtract(objects1, objects2));
            System.out.println("Intersect: " + setOperator.intersect(objects1, objects2));
            System.out.println("SymmetricSubtract: " + setOperator.symmetricSubtract(objects1, objects2));
        } else if (way == Const.TASK_MANAGER) {
            TaskManager taskManager = new TaskManager();
            Calendar c2 = new GregorianCalendar(2020, 11, 25);
            taskManager.addTask(c2.getTime(), new Task("Category " + 10, "Task " + 10));
            for (int i = 0; i < 10; i++) {
                taskManager.addTask(Calendar.getInstance().getTime(), new Task("Category " + i, "Task " + i));
               // System.out.println((taskManager.getTasks().get(i).toString()));
            }
            System.out.println(taskManager.getCategories());
            Map<String, List<Task>> tasks = taskManager.getTasksByCategories();
            taskManager.getTasksForToday();
            System.out.println((tasks.get("Category 1")).get(0).toString());
            System.out.println(taskManager.getTasksForToday());

        }

    }
}