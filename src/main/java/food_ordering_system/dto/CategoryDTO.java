package food_ordering_system.dto;

/**
 * DTO stands for Data Transfer Object.
 * This class acts as a customized envelope to carry only the specific database fields 
 * we want to expose to our API clients, keeping our internal entity layout hidden and secure.
 */
public class CategoryDTO {
    
    // Explicit, read-only data fields exposed to the API consumer
    private Long id;
    private String name;

    /**
     * Parameterized Constructor: Used by the service layer to instantly map 
     * raw database records into this clean, client-facing format.
     */
    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter method for the ID field.
     * Spring Boot's JSON serializer (Jackson) reads this method to generate the "id" key in the JSON output.
     */
    public Long getId() { 
        return id; 
    }

    /**
     * Getter method for the Name field.
     * Spring Boot's JSON serializer (Jackson) reads this method to generate the "name" key in the JSON output.
     */
    public String getName() { 
        return name; 
    }
}
