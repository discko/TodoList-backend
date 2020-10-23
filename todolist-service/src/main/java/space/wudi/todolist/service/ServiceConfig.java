package space.wudi.todolist.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("ServiceConfig")
@ComponentScan(basePackages = {"space.wudi.todolist.service.impl"})
public class ServiceConfig {

    @Value("${my-variables.service.env}")
    public String ENV;

    @Bean("servicePrintEnv")
    void printEnv(){
        System.out.println("service is at "+ENV);
    }

}
