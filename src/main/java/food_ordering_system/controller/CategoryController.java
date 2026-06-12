package food_ordering_system.controller;

import food_ordering_system.dto.CategoryDTO;
import food_ordering_system.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @RestController marks this class as an API entry point.
 * It automatically converts Java objects returned by methods directly into JSON format for the client.
 */
@RestController
/**
 * @RequestMapping defines the base URL path for this entire class.
 * All endpoints inside this controller will start with "/api/categories".
 */
@RequestMapping("/api/categories")
public class CategoryController {

    // Dependency injection placeholder for the service layer containing business logic
    private final CategoryService service;

    /**
     * Constructor Injection: Spring automatically injects the CategoryService bean here.
     * This establishes the connection between the controller and the service layer.
     */
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    /**
     * @GetMapping routes HTTP GET requests targeted at "/api/categories" to this method.
     * It fetches data and returns it to the client.
     * 
     * @return A list of CategoryDTO objects serialized as a JSON array.
     */
    @GetMapping
    public List<CategoryDTO> getCategories() {
        // Calls the service layer to grab category items from the database and returns them
        return service.getAllCategories();
    }
}
