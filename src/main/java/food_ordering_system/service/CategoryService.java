package food_ordering_system.service;

import food_ordering_system.dto.CategoryDTO;
import food_ordering_system.entity.CategoryEntity;
import food_ordering_system.exception.ResourceNotFoundException;
import food_ordering_system.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    // Your existing method
    public List<CategoryDTO> getAllCategories() {
        return repository.findAll().stream()
                .map(cat -> new CategoryDTO(cat.getId(), cat.getName(), cat.getDescription()))
                .collect(Collectors.toList());
    }

    // Task 4.1: Get Category By ID
    public CategoryDTO getCategoryById(Long id) {
        CategoryEntity category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        return mapToDto(category);
    }

    // Task 4.2: Add Category
    public CategoryDTO addCategory(CategoryDTO dto) {
        CategoryEntity category = mapToEntity(dto);
        CategoryEntity savedCategory = repository.save(category);
        return mapToDto(savedCategory);
    }

    // Task 4.4: Update Category
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        CategoryEntity category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        CategoryEntity updatedCategory = repository.save(category);
        return mapToDto(updatedCategory);
    }

    // Task 4.5: Delete Category
    public void deleteCategory(Long id) {
        CategoryEntity category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        repository.delete(category);
    }

    // Helper Mapping Methods matching your constructor signatures
    private CategoryDTO mapToDto(CategoryEntity entity) {
        return new CategoryDTO(entity.getId(), entity.getName(), entity.getDescription());
    }

    private CategoryEntity mapToEntity(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
