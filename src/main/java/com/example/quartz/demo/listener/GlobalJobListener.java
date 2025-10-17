package com.example.quartz.demo.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalJobListener implements JobListener {

    private static final Logger logger = LoggerFactory.getLogger(GlobalJobListener.class);

    @Override
    public String getName() {
        return "GlobalJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        logger.info("Job is about to be executed. Job Key: {}", context.getJobDetail().getKey());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        logger.info("Job execution was vetoed. Job Key: {}", context.getJobDetail().getKey());
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        logger.info("Job was executed. Job Key: {}", context.getJobDetail().getKey());
    }
}
