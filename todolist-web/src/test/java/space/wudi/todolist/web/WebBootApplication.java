package space.wudi.todolist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "space.wudi.todolist.web.controller")
public class WebBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebBootApplication.class, args);
    }
}
