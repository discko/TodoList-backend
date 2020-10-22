package space.wudi.todolist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EntityScan(basePackages = "space.wudi.todolist.persisitance.entity")
//@EnableJpaRepositories(basePackages = "space.wudi.todolist.persisitance.repository")
@SpringBootApplication(scanBasePackages = {
        "space.wudi.todolist.persisitance",
        "space.wudi.todolist.service",
        "space.wudi.todolist.web.*"
})
public class TodolistWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistWebApplication.class, args);
    }

}
