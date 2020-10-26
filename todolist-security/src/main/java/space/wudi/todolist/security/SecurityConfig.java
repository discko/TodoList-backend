package space.wudi.todolist.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Slf4j
@Configuration
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class SecurityConfig {
    public static String SECURITY_ENV;
    public static String SECURITY_SERIAL;

    @Bean
    boolean bindSecurityEnv(
            @Value("${my-variables.security.env}") String env,
            @Value("${my-variables.security.serial}") String serial
    ){
        SECURITY_ENV=env;
        SECURITY_SERIAL=serial;
        return true;
    }


    @Bean("securityPrintEnv")
    @DependsOn("bindSecurityEnv")
    void printEnv(){
        log.info("security is at {}.{}", SECURITY_ENV, SECURITY_SERIAL);
    }
}
