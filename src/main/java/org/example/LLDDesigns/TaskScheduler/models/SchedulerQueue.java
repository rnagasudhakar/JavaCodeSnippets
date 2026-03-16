package org.example.LLDDesigns.TaskScheduler.models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SchedulerQueue {
   private final PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>();
   private ReentrantLock lock = new ReentrantLock();
   private Condition lockCondition = lock.newCondition();

   public void addTask(Task task){
       lock.lock();
       try {
           lockCondition.signalAll();
           taskPriorityQueue.add(task);
       }finally {
           lock.unlock();
       }
   }

   public Task getTask(){
       lock.lock();
       try {
           while (taskPriorityQueue.isEmpty()){
               lockCondition.await();
           }
           Task nextTask = taskPriorityQueue.poll();
           long diff = Duration.between(LocalDateTime.now(), nextTask.getScheduledAt()).toMillis();
           if(diff <= 1000){
               return nextTask;
           }
           lockCondition.await(diff,TimeUnit.MILLISECONDS);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       } finally {
           lock.unlock();
       }
       return null;
   }

   public int size(){
       lock.lock();
       try{
           return taskPriorityQueue.size();
       }
       finally {
           lock.unlock();
       }
   }

}
