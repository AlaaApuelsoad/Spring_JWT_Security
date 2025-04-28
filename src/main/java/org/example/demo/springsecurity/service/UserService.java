package org.example.demo.springsecurity.service;

import lombok.RequiredArgsConstructor;
import org.example.demo.springsecurity.model.User;
import org.example.demo.springsecurity.repository.RoleRepository;
import org.example.demo.springsecurity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByRoleName("USER"));
        System.out.println(user.getPassword());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
