package de.srvn.client.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Markus Moormann
 * @version 07.12.13 - 13:22
 */
@Configuration
@ComponentScan(basePackages = { "de.srvn.client" })
public class AppConfig {

    @Bean
    public PropertyPlaceholderConfigurer applicationProperties() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocations(new Resource[]{new ClassPathResource("/application.properties")});
        return configurer;
    }

}
