package space.wudi.todolist.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Slf4j
@Configuration
public class CommonConfig {

    public static String COMMON_ENV;
    public static String COMMON_SERIAL;

    @Bean
    boolean bindCommonEnv(
            @Value("${my-variables.common.env}")String commonEnv,
           @Value("${my-variables.common.serial}")String serial
    ){
        COMMON_ENV=commonEnv;
        COMMON_SERIAL=serial;
        return true;
    }

    @Bean("commonPrintEnv")
    @DependsOn("bindCommonEnv")
    void printEnv(){
        log.info("Common is at {}.{}",COMMON_ENV, COMMON_SERIAL);
    }
}
