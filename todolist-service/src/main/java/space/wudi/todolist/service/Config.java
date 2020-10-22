package space.wudi.todolist.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("ServiceConfig")
@ComponentScan(basePackages = {"space.wudi.todolist.service.impl"})
public class Config {
}
