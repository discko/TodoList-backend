package space.wudi.todolist.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration("ServiceConfig")
@ComponentScan(basePackages = {"space.wudi.todolist.service.impl"})
public class ServiceConfig {

    public static String SERVICE_ENV;
    public static String SERVICE_SERIAL;

    @Bean
    boolean bindServiceEnv(
            @Value("${my-variables.service.env}") String env,
            @Value("${my-variables.service.serial}") String serial
    ){
        SERVICE_ENV=env;
        SERVICE_SERIAL=serial;
        return true;
    }

    @Bean("servicePrintEnv")
    @DependsOn("bindServiceEnv")
    void printEnv(){
        System.out.printf("service is at %s.%s\n", SERVICE_ENV, SERVICE_SERIAL);
    }

}
