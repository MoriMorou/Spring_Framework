package ru.morou.springintegrationdemo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAutoConfiguration
@EnableIntegration
@IntegrationComponentScan("ru.skubatko.dev.gb.spring2.lesson6.integration")
public class AppConfiguration {

    @Bean
    public MessageChannel simpleMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel testChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel simpleMessageTransformChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel textMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel welcomeNullableChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel welcomeNotNullableChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel welcomeChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel dispatcherChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel broadcastChannel() {
        return new PublishSubscribeChannel(executor());
    }

    @Bean
    public ThreadPoolTaskExecutor executor(){
        final ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(10);
        pool.setMaxPoolSize(10);
        pool.setWaitForTasksToCompleteOnShutdown(true);
        return pool;
    }

}
