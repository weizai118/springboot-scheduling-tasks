package com.gf.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: ScheduledTasks</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-04-10 15:01
 */
@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger( ScheduledTasks.class );

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat( "HH:mm:ss" );

    /**
     * <p>Title: reportCurrentTime</p>
     * <p>Description: </p>
     * @param 
     * @return
     *
     * @Scheduled(fixedRate = 5000)  : 上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) : 上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay = 1000 , fixedRate = 5000) : 第一次延迟1秒后在执行，之后fixedRate的规则每5秒执行一次
     * @Scheduled(cron = " /5 ") : 通过cron表达式定义规则
     * @Scheduled(cron = "0 15 10 * * ?") : 每天上午 10：15 触发
     *
     */


    @Scheduled(initialDelay = 10000 , fixedRate = 5000)
    public void reportCurrentTime() throws Exception{
        //演示 @Scheduled(fixedRate = 5000)
        Thread.sleep( 5000 );
        logger.info( "The time is now {}" , dateFormat.format( new Date() ) );
        //Thread.sleep( 5000 ); //演示 @Scheduled(fixedDelay = 5000)
    }

    @Scheduled(cron = "0 8 1 * * ?")
    public void reportCurrentTime2() throws Exception{

        logger.info( "The time is now {}" , dateFormat.format( new Date() ) );
        //Thread.sleep( 5000 ); //演示 @Scheduled(fixedDelay = 5000)

    }


}
