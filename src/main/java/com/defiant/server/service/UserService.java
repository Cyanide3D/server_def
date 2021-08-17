package com.defiant.server.service;

import com.defiant.server.model.User;
import com.defiant.server.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repository;

    public User findUserById(Long id) {
        return repository.getById(id);
    }

    public void saveOrUpdate(User user) {
        repository.save(user);
    }

}
