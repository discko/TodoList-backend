package space.wudi.todolist.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = {
        "space.wudi.todolist.common",
        "space.wudi.todolist.persisitance",
        "space.wudi.todolist.service",
        "space.wudi.todolist.security",
        "space.wudi.todolist.web"
})
public class TodolistWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistWebApplication.class, args);
    }

}
