package br.com.joelbrs.jpawebservice.repositories;

import br.com.joelbrs.jpawebservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
