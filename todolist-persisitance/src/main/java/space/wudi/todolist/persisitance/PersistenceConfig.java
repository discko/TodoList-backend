package space.wudi.todolist.persisitance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@Configuration("PersistenceConfig")
@EntityScan(basePackages = "space.wudi.todolist.persisitance.entity")
@EnableJpaRepositories(basePackages = "space.wudi.todolist.persisitance.repository")
public class PersistenceConfig {

    public static String PERSISTENCE_ENV;
    public static String PERSISTENCE_SERIAL;

    @Bean()
    boolean bindPersistenceEnv(
            @Value("${my-variables.persistence.env}") String env,
            @Value("${my-variables.persistence.serial}") String serial
    ){
        PERSISTENCE_ENV=env;
        PERSISTENCE_SERIAL=serial;
        return true;
    }

    @Bean("persistencePrintEnv")
    @DependsOn("bindPersistenceEnv")
    void printEnv(){
        log.info("persistence is at {}.{}", PERSISTENCE_ENV, PERSISTENCE_SERIAL);
    }

}
