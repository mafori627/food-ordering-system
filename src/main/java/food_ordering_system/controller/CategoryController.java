package food_ordering_system.controller;

import food_ordering_system.dto.CategoryDTO;
import food_ordering_system.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (@)RestController marks this class as an API entry point.
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
     * (@)GetMapping routes HTTP GET requests targeted at "/api/categories" to this method.
     * It fetches data and returns it to the client.
     * 
     * (@))return A list of CategoryDTO objects serialized as a JSON array.
     */
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        // Calls the service layer to grab category items from the database and returns them
        return ResponseEntity.ok(service.getAllCategories());
    }

    /**
     * [Task 4.1] GET /api/categories/{id}
     * Routes HTTP GET requests targeted at a specific category identifier.
     * 
     * (@)param id The primary identifier key of the category entity.
     * (@)return The matching CategoryDTO with an HTTP 200 OK status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    /**
     * [Task 4.2] POST /api/categories
     * Processes incoming payload parameters to create a new category record.
     * 
     * (@)param dto The validated data payload model from the client request body.
     * (@)return The newly saved CategoryDTO resource along with an HTTP 201 Created status.
     */
    @PostMapping
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCategory(dto));
    }

    /**
     *PUT /api/categories/{id}
     * Modifies properties on an existing category model referenced by its key identifier.
     * 
     * (@)param id The key identifier target of the record.
     * (@)param dto The fresh values inside our incoming request data structure.
     * (@)return The updated CategoryDTO record with an HTTP 200 OK status.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO dto) {
        return ResponseEntity.ok(service.updateCategory(id, dto));
    }

    /**
     *  DELETE /api/categories/{id}
     * Removes an active category entity completely out of our data storage layer.
     * 
     * (@)param id The target key identifier to purge.
     * (@)return An empty response container showing a clean HTTP 204 No Content status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
