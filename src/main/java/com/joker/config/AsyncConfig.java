package com.joker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: word_test
 * @author: Joker
 * @create: 2021-06-30 10:30
 * @Description: NULL
 **/

@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean ( "testExecutor" )
    public Executor doSomethingExecutor ( ) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数：线程池创建时候初始化的线程数
        executor.setCorePoolSize( 10 );

        // 最大线程数：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize( 20 );

        // 缓冲队列：用来缓冲执行任务的队列
        executor.setQueueCapacity( 500 );

        // 允许线程的空闲时间60秒：当超过了核心线程之外的线程在空闲时间到达之后会被销毁
        executor.setKeepAliveSeconds( 60 );

        // 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
        executor.setThreadNamePrefix( "Thread-" );

        // 设置线程池关闭的时候 等待所有任务都完成后，再继续销毁其他的Bean，
        // 确保异步任务的销毁就会先于数据库连接池对象的销毁。
        executor.setWaitForTasksToCompleteOnShutdown( true );

        // 设置线程池中 任务的等待时间
        executor.setAwaitTerminationSeconds( 60 );

        // 缓冲队列满了之后的拒绝策略：由调用线程处理（一般是主线程）
        executor.setRejectedExecutionHandler( new ThreadPoolExecutor.DiscardPolicy() );

        //初始化线程
        executor.initialize();
        return executor;
    }
}
