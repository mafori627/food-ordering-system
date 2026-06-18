package food_ordering_system.controller;

import food_ordering_system.dto.CategoryDTO;
import food_ordering_system.Response.Response;
import food_ordering_system.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller responsible for handling HTTP requests related to Categories.
 * Provides endpoints for creating, retrieving, updating, and deleting category records.
 * All endpoint responses are standardized using the generic {(@)link Response} wrapper.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    /**
     * Constructor Injection to establish dependency decoupling from the service layer.
     * Spring Boot automatically wires up the CategoryService bean resource here.
     */
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    /**
     * Fetch all available category resources from the system.
     *
     * (@)return A list of CategoryDTO payloads wrapped inside a standardized success envelope.
     */
    @GetMapping
    public ResponseEntity<Response<List<CategoryDTO>>> getCategories() {
        List<CategoryDTO> categories = service.getAllCategories();
        return ResponseEntity.ok(Response.success("All categories retrieved successfully", categories));
    }

    /**
     * Fetch a distinct category matching the unique id reference segment.
     *
     * (@)param id The primary dynamic key identifier extracted directly from the path variable.
     * (@)return The target CategoryDTO data object nested inside the success data wrapper payload.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Response<CategoryDTO>> getCategoryById(@PathVariable Long id) {
        CategoryDTO dto = service.getCategoryById(id);
        return ResponseEntity.ok(Response.success("Category retrieved", dto));
    }

    /**
     * Process an incoming payload blueprint to insert a fresh category row record.
     * Triggers active input constraint checks using the {(@)link Valid} annotation filter.
     *
     * (@)param dto The data model passed inside the incoming client request transmission body.
     * (@)return The newly saved resource with an HTTP 201 Created server response status block.
     */
    @PostMapping
    public ResponseEntity<Response<CategoryDTO>> addCategory(@Valid @RequestBody CategoryDTO dto) {
        CategoryDTO savedCategory = service.addCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Response.success("Category created successfully", savedCategory));
    }

    /**
     * Update the structural attributes of an active category database entity record.
     * Runs automatic intercept checks to catch bad strings before reaching business logic.
     *
     * (@)param id The structural database record identifier target.
     * (@)param dto The modified content values mapped from the JSON payload map.
     * (@)return The altered data model reflection state back with a success note update shell.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response<CategoryDTO>> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO dto) {
        CategoryDTO updatedCategory = service.updateCategory(id, dto);
        return ResponseEntity.ok(Response.success("Category updated successfully", updatedCategory));
    }

    /**
     * Permanently purge an indexed category object out of the storage persistence space layer.
     * Returns an explicit success flag wrapper carrying a null data body to the consumer.
     *
     * (@)param id The target primary key identifier to isolate and drop.
     * (@)return A standard HTTP 200 execution packet wrapper containing zero object elements.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.ok(Response.success("Category deleted successfully", null));
    }
}
