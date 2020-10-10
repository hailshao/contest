package com.contest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author shaohailin
 * 线程池配置类
 */
@Configuration
public class ThreadPoolTaskExecutorConfig {
    /**
     * 线程池初始容量:
     * 如果是CPU密集型应用，则线程池大小设置为N+1
     * 如果是IO密集型应用，则线程池大小设置为2N+1（其中N为CPU核树）
     * 精确计算：
     * 最佳线程数目 = （（线程等待时间+线程CPU时间）/线程CPU时间 ）* CPU核心数
     * <p>
     * 在Windows中，在cmd命令中输入“wmic”，然后在出现的新窗口中输入“cpu get *”即可查看物理CPU数、CPU核心数、线程数。其中，
     * 　　NumberOfCores：表示CPU核心数
     * 　　NumberOfLogicalProcessors：表示CPU线程数
     *
     * @return
     */
    @Bean("taskExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(300);
        executor.setQueueCapacity(25);
        return executor;
    }
}

