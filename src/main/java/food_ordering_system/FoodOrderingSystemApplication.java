package food_ordering_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication is the master annotation for this project.
 * It combines three critical configurations into one:
 * 1. @SpringBootConfiguration: Enables configuration scanning for custom setups.
 * 2. @EnableAutoConfiguration: Tells Spring Boot to guess and configure database connections automatically.
 * 3. @ComponentScan: Commands Spring to scan all sub-folders for beans like Controllers, Services, and Repositories.
 */
@SpringBootApplication
public class FoodOrderingSystemApplication {

    /**
     * The standard Java Main Method.
     * This acts as the absolute starting line and entry point of your executable application.
     */
    public static void main(String[] args) {
        // Starts up the Spring Engine, initializes the embedded Tomcat web server, 
        // reads your application.properties file, and activates the REST API.
        SpringApplication.run(FoodOrderingSystemApplication.class, args);
    }
}
