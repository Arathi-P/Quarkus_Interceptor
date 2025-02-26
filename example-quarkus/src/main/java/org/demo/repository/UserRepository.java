package org.demo.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.demo.model.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public List<User> findByUsername(String username) {
        return find("username", username).list();
    }
}
