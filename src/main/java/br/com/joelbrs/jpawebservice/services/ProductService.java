package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.entities.Product;
import br.com.joelbrs.jpawebservice.repositories.ProductRepository;
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
        Optional<Product> product = repository.findById(id);

        return product.get();
    }
}
