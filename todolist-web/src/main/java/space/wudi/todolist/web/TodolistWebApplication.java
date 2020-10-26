package space.wudi.todolist.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@Slf4j
@SpringBootApplication(scanBasePackages = {
        "space.wudi.todolist.common",
        "space.wudi.todolist.persisitance",
        "space.wudi.todolist.service",
        "space.wudi.todolist.security",
        "space.wudi.todolist.web.*"
})
public class TodolistWebApplication {

    public static String WEB_ENV;
    public static String WEB_SERIAL;

    @Bean
    boolean bindWebEnv(
            @Value("${my-variables.web.env}") String env,
            @Value("${my-variables.web.serial}") String serial
    ){
        WEB_ENV=env;
        WEB_SERIAL=serial;
        return true;
    }

    @Bean("webPrintEnv")
    @DependsOn("bindWebEnv")
    void printEnv(){
        log.info("web is at {}.{}", WEB_ENV, WEB_SERIAL);
    }

    public static void main(String[] args) {
        SpringApplication.run(TodolistWebApplication.class, args);
    }

}
