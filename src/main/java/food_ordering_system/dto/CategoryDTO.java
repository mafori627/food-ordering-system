package food_ordering_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO stands for Data Transfer Object.
 * This class acts as a customized envelope to carry only the specific database fields
 * we want to expose to our API clients, keeping our internal entity layout hidden and secure.
 */
public class CategoryDTO {

    // Explicit, read-only data fields exposed to the API consumer
    private Long id;

    /**
     * [Task 4.3] Input Validation Constraints
     * These intercept bad client request payloads before they hit the business layer.
     */
    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 50, message = "Name must be 2-50 characters")
    private String name;

    @NotBlank(message = "Category description is required")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    /**
     * Default No-Args Constructor: Mandatory for Spring Boot / Jackson JSON deserialization.
     * Jackson uses this constructor to dynamically initialize the object during POST/PUT requests.
     */
    public CategoryDTO() {
    }

    /**
     * Parameterized Constructor: Used by the service layer to instantly map
     * raw database records into this clean, client-facing format.
     */
    public CategoryDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Getter method for the ID field.
     * Spring Boot's JSON serializer (Jackson) reads this method to generate the "id" key in the JSON output.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for the ID field. Required for processing request parameters.
     */
    public void setId(Long id) {
        valueSetterId(id);
    }

    private void valueSetterId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for the Name field.
     * Spring Boot's JSON serializer (Jackson) reads this method to generate the "name" key in the JSON output.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the Name field. Required for incoming payload data assignment.
     */
    public void setName(String name) {
        valueSetterName(name);
    }

    private void valueSetterName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the Description field.
     * Jackson reads this to generate the "description" key in your JSON output.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for the Description field.
     * Required for incoming JSON payload data mapping assignment.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
