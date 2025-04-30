package q4_PrioritizationEngine;

import java.util.*;

class Task {
    String name;
    int priority, deadline;
    Task(String name, int priority, int deadline){
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    int getPriority(){
        return priority;
    }
    int getDeadline(){
        return deadline;
    }
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", deadline=" + deadline + "}";
    }
}

class TaskScheduler{
    public static void main(String[] args){
        PriorityQueue<Task> taskQueue = new PriorityQueue<>
                (Comparator.comparingInt(Task::getDeadline).
                        thenComparingInt(Task::getPriority));
        taskQueue.add(new Task("Task 1", 5, 10));
        taskQueue.add(new Task("Task 2", 3, 11));
        taskQueue.add(new Task("Task 3", 8, 23));
        taskQueue.add(new Task("Task 4", 2,11));
        taskQueue.add(new Task("Task 5", 6,20));

        taskQueue.add(new Task("Task 6", 15, 22));
        taskQueue.add(new Task("Task 7", 9, 18));
        taskQueue.add(new Task("Task 8", 8, 23));
        taskQueue.add(new Task("Task 9", 12,21));
        taskQueue.add(new Task("Task 10", 16,25));

        taskQueue.forEach(task -> {
                    System.out.println(task);
                });

    }
}
