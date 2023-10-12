package br.com.joelbrs.jpawebservice.repositories;

import br.com.joelbrs.jpawebservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
