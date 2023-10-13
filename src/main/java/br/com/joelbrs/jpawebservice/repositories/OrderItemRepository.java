package br.com.joelbrs.jpawebservice.repositories;

import br.com.joelbrs.jpawebservice.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
