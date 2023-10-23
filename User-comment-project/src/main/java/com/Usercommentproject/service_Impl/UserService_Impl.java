package com.Usercommentproject.service_Impl;

import com.Usercommentproject.entity.User;
import com.Usercommentproject.repository.UserRepository;
import com.Usercommentproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

// UserServiceImpl.java
@Service
public class UserService_Impl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private boolean isValidUserName(String userName) {
        return !userName.isEmpty() && userName.matches("^[a-zA-Z]+$");
    }

    @Override
    public User addUser(String userName) {
        if (!isValidUserName(userName)) {
            throw new IllegalArgumentException("Invalid Request: User name should not be empty and must contain only alphabets.");
        }

        Optional<User> existingUser = userRepository.findByUserName(userName);
        return existingUser.orElseGet(() -> userRepository.save(new User(userName)));
    }
}
