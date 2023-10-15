package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.dtos.OrderDTO;
import br.com.joelbrs.jpawebservice.entities.Order;
import br.com.joelbrs.jpawebservice.repositories.OrderRepository;
import br.com.joelbrs.jpawebservice.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> orders = repository.findAll();

        return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        return new OrderDTO(order);
    }
}
