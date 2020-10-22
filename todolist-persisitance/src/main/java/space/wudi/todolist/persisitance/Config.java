package space.wudi.todolist.persisitance;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration("PersistenceConfig")
@EntityScan(basePackages = "space.wudi.todolist.persisitance.entity")
@EnableJpaRepositories(basePackages = "space.wudi.todolist.persisitance.repository")
@PropertySource("classpath:application-persistence.properties")
public class Config {

}
