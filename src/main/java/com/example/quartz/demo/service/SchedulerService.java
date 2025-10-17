package com.example.quartz.demo.service;

import com.example.quartz.demo.config.QuartzConfig;
import com.example.quartz.demo.listener.GlobalJobListener;
import com.example.quartz.demo.listener.JobChainingListener;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.matchers.KeyMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private QuartzConfig quartzConfig;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            scheduler.getListenerManager().addJobListener(new GlobalJobListener());

            scheduler.addJob(quartzConfig.worldTransferJobDetail(), true);
            scheduler.addJob(quartzConfig.updateHighScoreJobDetail(), true);

            scheduler.getListenerManager().addJobListener(
                    new JobChainingListener("updateHighScoreJob"),
                    KeyMatcher.keyEquals(new JobKey("worldTransferJob"))
            );

            if (!scheduler.checkExists(quartzConfig.worldTransferJobTrigger().getKey())) {
                scheduler.scheduleJob(quartzConfig.worldTransferJobTrigger());
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
