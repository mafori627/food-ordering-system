package food_ordering_system.service;

import food_ordering_system.dto.CategoryDTO;
import food_ordering_system.repository.CategoryRepository;
import food_ordering_system.entity.CategoryEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDTO> getAllCategories() {
        return repository.findAll().stream()
                .map(cat -> new CategoryDTO(cat.getId(), cat.getName()))
                .collect(Collectors.toList());
    }
}
