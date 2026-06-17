package food_ordering_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration tells Spring Boot that this class contains application configuration settings.
 * Spring will read this file during startup to configure system behaviors.
 */
@Configuration
public class CategoryConfig {

    /**
     * (@)Bean registers the return object (WebMvcConfigurer) as a manageable Spring bean.
     * This allows Spring's web engine to automatically pick up and enforce these rules.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        // Creates and returns an anonymous class implementation of WebMvcConfigurer
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Defines the URL patterns and rules for Cross-Origin Resource Sharing (CORS)
                registry.addMapping("/api/**")
                        // Allows requests from any external web domain or port (e.g., localhost:3000 for React)
                        .allowedOrigins("*")
                        // Updated to permit all required CRUD operations for our tasks
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Allows any HTTP request headers to be passed through to the API
                        .allowedHeaders("*");
            }
        };
    }
}
