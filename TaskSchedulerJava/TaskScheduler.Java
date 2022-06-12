package com.coder.Java.lambdas;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TaskScheduler {
    public static void main(String[] args) {

        Thread taskOne = new Thread(() -> task1(), "Show time");
        Thread taskTwo = new Thread(() -> task2(), "Show other task");
        List<Thread> taskList = Arrays.asList(taskOne, taskTwo);
        taskList.forEach(tk -> tk.start());
    }

    private static void task1() {
        Timer scheduler = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now());
            }
        };
        scheduler.scheduleAtFixedRate(myTask, 0, 5000);
    }

    private static void task2() {
        Timer scheduler = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("It is other task");
            }
        };
        scheduler.scheduleAtFixedRate(task, 1, 2000);
    }
}
