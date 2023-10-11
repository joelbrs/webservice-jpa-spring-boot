package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.entities.User;
import br.com.joelbrs.jpawebservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        Optional<User> user = repository.findById(id);

        return user.get();
    }
}
