package br.com.joelbrs.jpawebservice.repositories;

import br.com.joelbrs.jpawebservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
