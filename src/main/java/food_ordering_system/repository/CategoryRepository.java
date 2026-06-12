package food_ordering_system.repository;

import food_ordering_system.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository marks this interface as a data access layer component.
 * It tells Spring Boot to handle database exceptions and turn them into clean Spring exceptions.
 */
@Repository
/**
 * JpaRepository<CategoryEntity, Long> automatically builds your database operations.
 * - "CategoryEntity" specifies the database table mapping class to manage.
 * - "Long" specifies the data type of the primary key field (@Id) in that entity.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    // This interface remains empty because JpaRepository automatically provides:
    // - findAll()          -> Executes: SELECT * FROM category;
    // - findById(id)       -> Executes: SELECT * FROM category WHERE id = ?;
    // - save(entity)       -> Executes: INSERT INTO or UPDATE category...
    // - deleteById(id)     -> Executes: DELETE FROM category WHERE id = ?;
}
