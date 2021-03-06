package br.com.githubvini.application.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;


/**
 * Classe responsável por tratar problema de CORS da aplicação front-end.
 * @author Vinicius Torres Pascucci.
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean() {

        List<String> allOrigins = Arrays.asList("*");
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(allOrigins);
        config.setAllowedHeaders(allOrigins);
        config.setAllowedMethods(allOrigins);

        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        CorsFilter corsFilter = new CorsFilter(source);
        FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(corsFilter);

        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return filter;
    }
}
