package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.entities.Order;
import br.com.joelbrs.jpawebservice.repositories.OrderRepository;
import br.com.joelbrs.jpawebservice.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
