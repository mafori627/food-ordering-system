package food_ordering_system.entity;

import jakarta.persistence.*;

/**
 * @Entity tells Spring Boot and Hibernate that this Java class is a database model.
 * Each object created from this class represents a specific row inside a database table.
 */
@Entity
/**
 * @Table defines the exact name of the table inside your database.
 * This links this Java class directly to the "category" table seen in your DBeaver database editor.
 */
@Table(name = "category")
public class CategoryEntity {

    /**
     * @Id marks this specific field as the primary key of the database table.
     * @GeneratedValue specifies that the ID column is auto-incrementing. 
     * GenerationType.IDENTITY leaves the ID numbering assignment entirely up to your MySQL database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This field maps directly to the column named "name" inside your MySQL category table.
    private String name;

    // --- Getters and Setters ---
    // These methods allow other layers (like repositories and services) to read and modify the row values safely.

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }
}
