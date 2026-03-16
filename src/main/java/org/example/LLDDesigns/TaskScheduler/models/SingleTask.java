package org.example.LLDDesigns.TaskScheduler.models;

import org.example.LLDDesigns.TaskPlanner.Entities.TaskType;

import java.time.LocalDateTime;

public class SingleTask extends Task{
    public SingleTask(String taskId, Runnable taskAction, String createdBy, LocalDateTime scheduledAt, TaskType taskType, Integer maxRetryCount) {
        super(taskId, taskAction, createdBy, scheduledAt, taskType, maxRetryCount);
    }
}
