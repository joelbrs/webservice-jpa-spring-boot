package br.com.joelbrs.jpawebservice.repositories;

import br.com.joelbrs.jpawebservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
