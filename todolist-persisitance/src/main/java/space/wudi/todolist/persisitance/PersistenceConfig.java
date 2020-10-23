package space.wudi.todolist.persisitance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration("PersistenceConfig")
@EntityScan(basePackages = "space.wudi.todolist.persisitance.entity")
@EnableJpaRepositories(basePackages = "space.wudi.todolist.persisitance.repository")
public class PersistenceConfig {

    @Value("${my-variables.persistence.env}")
    public String ENV;

    @Bean("persistencePrintEnv")
    void printEnv(){
        System.out.println("persistence is at "+ENV);
    }

}
