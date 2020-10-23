package space.wudi.todolist.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Value("${my-variables.common.env}")
    public String COMMON_ENV;

    @Bean("commonPrintEnv")
    void printEnv(){
        System.out.println("Common is at "+COMMON_ENV);
    }
}
