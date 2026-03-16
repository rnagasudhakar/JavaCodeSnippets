package org.example.LLDDesigns.TaskScheduler.models;

import org.example.LLDDesigns.TaskPlanner.Entities.TaskType;

import java.time.LocalDateTime;

public class RecurringTask extends Task{

    private final Integer delay;

    public RecurringTask(String taskId, Runnable taskAction, String createdBy, LocalDateTime scheduledAt, TaskType taskType, Integer maxRetryCount, Integer delay) {
        super(taskId, taskAction, createdBy, scheduledAt, taskType, maxRetryCount);
        this.delay = delay;
    }

    public Task nextSchedueldTask(){
        LocalDateTime nextScheduledTime = this.getScheduledAt().plusSeconds(delay);
        this.setScheduledAt(nextScheduledTime);
        return this;
    }


}
