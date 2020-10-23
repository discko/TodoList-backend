package space.wudi.todolist.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
        "space.wudi.todolist.common",
        "space.wudi.todolist.persisitance",
        "space.wudi.todolist.service",
        "space.wudi.todolist.security",
        "space.wudi.todolist.web.*"
})
public class TodolistWebApplication {
    @Value("${my-variables.web.env}")
    public String ENV;

    @Bean("webPrintEnv")
    void printEnv(){
        System.out.println("web is at "+ENV);
    }

    public static void main(String[] args) {
        SpringApplication.run(TodolistWebApplication.class, args);
    }

}
