package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.entities.Product;
import br.com.joelbrs.jpawebservice.repositories.ProductRepository;
import br.com.joelbrs.jpawebservice.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findBydId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
