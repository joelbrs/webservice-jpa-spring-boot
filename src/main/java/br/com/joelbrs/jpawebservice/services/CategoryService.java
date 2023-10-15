package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.dtos.CategoryDTO;
import br.com.joelbrs.jpawebservice.entities.Category;
import br.com.joelbrs.jpawebservice.repositories.CategoryRepository;
import br.com.joelbrs.jpawebservice.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository respository;

    public CategoryService(CategoryRepository respository) {
        this.respository = respository;
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> categories = respository.findAll();

        return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Category category = respository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        return new CategoryDTO(category);
    }
}
