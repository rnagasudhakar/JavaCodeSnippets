package org.example.LLDDesigns.TaskScheduler.factory;

import org.example.LLDDesigns.TaskPlanner.Entities.TaskType;
import org.example.LLDDesigns.TaskScheduler.models.RecurringTask;
import org.example.LLDDesigns.TaskScheduler.models.SingleTask;
import org.example.LLDDesigns.TaskScheduler.models.Task;

import java.time.LocalDateTime;

public class TaskFactory {

    public static Task getTask(TaskType taskType,   String taskId,
                               Runnable taskAction,
                               String createdBy,
                               LocalDateTime scheduledAt,
                               Integer maxRetryCount,
                               Integer delay){
        return switch (taskType){
            case SINGLE -> new SingleTask(taskId,taskAction,createdBy, scheduledAt, taskType, maxRetryCount);
            default -> new RecurringTask(taskId,taskAction,createdBy, scheduledAt, taskType, maxRetryCount,delay);
        };
    }

}
