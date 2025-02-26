package org.demo.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptors;
import jakarta.transaction.Transactional;

import org.demo.config.LogMethodInvocation;
import org.demo.config.LoggingInterceptor;
import org.demo.model.User;
import org.demo.repository.UserRepository;

@ApplicationScoped
@LogMethodInvocation
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public void createUser(User user) {
        userRepository.persist(user);
    }

    public List<User> getAllUsers() {
        return userRepository.listAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}

