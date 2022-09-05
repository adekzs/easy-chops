package com.easychops.easychops.service;

import com.easychops.easychops.model.User;
import com.easychops.easychops.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User saveUser(User user) {
       return userRepository.save(user);
    }
}
