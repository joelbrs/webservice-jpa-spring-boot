package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.entities.Category;
import br.com.joelbrs.jpawebservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository respository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return respository.findAll();
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        Optional<Category> category = respository.findById(id);

        return category.get();
    }
}
