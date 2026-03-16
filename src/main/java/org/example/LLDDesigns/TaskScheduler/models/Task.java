package org.example.LLDDesigns.TaskScheduler.models;

import org.example.LLDDesigns.TaskPlanner.Entities.TaskType;
import org.example.LLDDesigns.TaskScheduler.enums.TaskStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task implements Comparable<Task> {
    private String taskId;
    private Runnable taskAction;
    private String createdBy;
    private LocalDateTime scheduledAt;
    private TaskStatus taskStatus;
    private TaskType taskType;
    private Integer maxRetryCount;
    private Integer currentRetry;
    private Double duration;

    public Task(String taskId, Runnable taskAction, String createdBy, LocalDateTime scheduledAt, TaskType taskType, Integer maxRetryCount) {
        this.taskId = taskId;
        this.taskAction = taskAction;
        this.createdBy = createdBy;
        this.scheduledAt = scheduledAt;
        this.taskStatus = TaskStatus.CREATED;
        this.taskType = taskType;
        this.maxRetryCount = maxRetryCount;
        this.currentRetry = 0;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public void runTask(){
        if(taskStatus != TaskStatus.CANCELLED && taskStatus != TaskStatus.COMPLETED){
            try{
                taskAction.run();
                System.out.println("Task has been run" + taskId);
                taskStatus = TaskStatus.RUNNING;
            }
            catch (Exception e){
                taskStatus = TaskStatus.FAILED;
                System.out.println("Task has been failed");
            }
        }
    }

    public void retryJob(){
        if(taskStatus == TaskStatus.FAILED && currentRetry < maxRetryCount){
            currentRetry++;
            taskStatus = TaskStatus.RUNNING;
            runTask();
        }
    }


    public void cancelTask(){
        if(taskStatus == TaskStatus.RUNNING || taskStatus == TaskStatus.PAUSED){
            taskStatus = TaskStatus.CANCELLED;
        }
    }

    public void pauseTask(){
        if(taskStatus == TaskStatus.RUNNING){
            taskStatus = TaskStatus.PAUSED;
        }
    }

    public void resumeTask(){
        if(taskStatus == TaskStatus.PAUSED){
            taskStatus = TaskStatus.RUNNING;
        }
    }

    @Override
    public int compareTo(Task other){
        return this.scheduledAt.compareTo(other.scheduledAt);
    }


    public String getTaskId() {
        return taskId;
    }

    public Runnable getTaskAction() {
        return taskAction;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    public Integer getCurrentRetry() {
        return currentRetry;
    }

    public Double getDuration() {
        return duration;
    }

    public Task nextSchedueldTask() {
        return null;
    }
}
