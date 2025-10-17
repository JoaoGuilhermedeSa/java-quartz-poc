package com.example.quartz.demo.job;

import com.example.quartz.demo.service.HighScoreService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateHighScoreJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(UpdateHighScoreJob.class);

    @Autowired
    private HighScoreService highScoreService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("UpdateHighScoreJob started.");
        highScoreService.updateHighScores();
        logger.info("UpdateHighScoreJob finished successfully.");
    }
}
