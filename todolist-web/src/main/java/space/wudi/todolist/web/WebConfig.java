package space.wudi.todolist.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Slf4j
@Configuration
public class WebConfig {

    @Value("${swagger.enable}")
    String swaggerEnable;

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setMaxAge(3600L);
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        log.info("-------- swagger status: {}", swaggerEnable);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    public static String WEB_ENV;
    public static String WEB_SERIAL;

    @Bean
    boolean bindWebEnv(
            @Value("${my-variables.web.env}") String env,
            @Value("${my-variables.web.serial}") String serial
    ){
        WEB_ENV=env;
        WEB_SERIAL=serial;
        return true;
    }

    @Bean("webPrintEnv")
    @DependsOn("bindWebEnv")
    void printEnv(){
        log.info("web is at {}.{}", WEB_ENV, WEB_SERIAL);
    }
}
