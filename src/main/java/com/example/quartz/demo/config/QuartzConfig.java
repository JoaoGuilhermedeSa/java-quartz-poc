package com.example.quartz.demo.config;

import com.example.quartz.demo.job.WorldTransferJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail worldTransferJobDetail() {
        return JobBuilder.newJob(WorldTransferJob.class)
                .withIdentity("worldTransferJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger worldTransferJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(worldTransferJobDetail())
                .withIdentity("worldTransferTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public WorldTransferJob worldTransferJob() {
        return new WorldTransferJob();
    }
}
