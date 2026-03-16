package org.example.LLDDesigns.TaskScheduler.models;

import org.example.LLDDesigns.TaskPlanner.Entities.TaskType;
import org.example.LLDDesigns.TaskScheduler.Strategy.TaskSchedulerStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TaskScheduler {

    private SchedulerQueue schedulerQueue;
    private ExecutorService executorService;
    private Semaphore semaphore;
    private volatile boolean isRunning;

    public TaskScheduler(int maxThreadCount) {
        schedulerQueue = new SchedulerQueue();
        executorService = Executors.newFixedThreadPool(maxThreadCount);
        semaphore = new Semaphore(maxThreadCount);
        this.isRunning = true;
    }


    public void start(){
        Thread dispatcherThread = new Thread(()->{
            while (isRunning){
                while (schedulerQueue.size() >0){
                    Task nextTask = schedulerQueue.getTask();
                    if(nextTask.getTaskType() == TaskType.RECURRING){
                        Task nextScheduledTask =  nextTask.nextSchedueldTask();
                        schedulerQueue.addTask(nextScheduledTask);
                    }
                    try {
                        semaphore.acquire();
                        executorService.submit(nextTask::runTask);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
        dispatcherThread.start();
    }

    public void shutDown(){
        this.isRunning = false;
        executorService.shutdown();
    }

}
