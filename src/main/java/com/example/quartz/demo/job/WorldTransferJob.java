package com.example.quartz.demo.job;

import com.example.quartz.demo.service.WorldTransferService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class WorldTransferJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(WorldTransferJob.class);
    @Autowired
    private WorldTransferService worldTransferService;

    @Override
    	public void execute(JobExecutionContext context) throws JobExecutionException {
    		logger.info("WorldTransferJob started.");
    		worldTransferService.processPendingTransfers();
    		logger.info("WorldTransferJob finished successfully.");
    	}}
