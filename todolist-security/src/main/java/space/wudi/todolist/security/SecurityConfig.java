package space.wudi.todolist.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Value("${my-variables.security.env}")
    public String ENV;

    @Bean("securityPrintEnv")
    void printEnv(){
        System.out.println("security is at "+ENV);
    }
}
