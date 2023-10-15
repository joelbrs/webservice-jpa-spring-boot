package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.dtos.ProductDTO;
import br.com.joelbrs.jpawebservice.entities.Product;
import br.com.joelbrs.jpawebservice.repositories.ProductRepository;
import br.com.joelbrs.jpawebservice.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();

        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDTO findBydId(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        return new ProductDTO(product);
    }
}
