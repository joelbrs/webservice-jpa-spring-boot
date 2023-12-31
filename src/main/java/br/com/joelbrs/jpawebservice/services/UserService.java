package br.com.joelbrs.jpawebservice.services;

import br.com.joelbrs.jpawebservice.dtos.UserDTO;
import br.com.joelbrs.jpawebservice.dtos.UserInsertDTO;
import br.com.joelbrs.jpawebservice.entities.User;
import br.com.joelbrs.jpawebservice.repositories.UserRepository;
import br.com.joelbrs.jpawebservice.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();

        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserInsertDTO dto) {
        User user = new User(null, dto.getName(), dto.getEmail(), dto.getPhone(), dto.getPassword());
        user = repository.save(user);

        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, User obj) {
        User entity = repository.getReferenceById(id);

        updateData(entity, obj);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
