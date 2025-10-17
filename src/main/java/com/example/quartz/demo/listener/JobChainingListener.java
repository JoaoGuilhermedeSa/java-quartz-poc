package com.example.quartz.demo.listener;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobChainingListener implements JobListener {

    private static final Logger logger = LoggerFactory.getLogger(JobChainingListener.class);

    private final String nextJobName;

    public JobChainingListener(String nextJobName) {
        this.nextJobName = nextJobName;
    }

    @Override
    public String getName() {
        return "JobChainingListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        logger.info("Job was executed, chaining to next job: {}", nextJobName);
        try {
            context.getScheduler().triggerJob(new JobKey(nextJobName));
        } catch (SchedulerException e) {
            logger.error("Error while chaining job", e);
        }
    }
}
