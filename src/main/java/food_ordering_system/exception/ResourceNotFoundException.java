package food_ordering_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * (@)ResponseStatus configures the HTTP response code bound to this error.
 * Whenever this exception is thrown anywhere in our application, Spring Boot will automatically 
 * halt execution and return an HTTP Status Code 404 (Not Found) to the API client.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    /**
     * Parameterized Constructor: Captures a custom descriptive error message.
     * 
     * (@)param message Explains precisely what was missing (e.g., "Category with ID 5 not found").
     */
    public ResourceNotFoundException(String message) {
        // Passes the descriptive message up to the parent RuntimeException class 
        // so it can be grabbed by our global loggers and exception handlers.
        super(message);
    }
}
