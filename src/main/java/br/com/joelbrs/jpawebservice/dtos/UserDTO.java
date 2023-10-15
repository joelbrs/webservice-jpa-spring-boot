package br.com.joelbrs.jpawebservice.dtos;

import br.com.joelbrs.jpawebservice.entities.User;

import java.io.Serializable;
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public UserDTO() {}

    public UserDTO(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserDTO(User user) {
        setId(user.getId());
        setName(user.getName());
        setEmail(user.getEmail());
        setPhone(user.getPhone());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
