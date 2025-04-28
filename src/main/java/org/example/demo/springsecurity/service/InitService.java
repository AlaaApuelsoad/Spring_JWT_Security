package org.example.demo.springsecurity.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.demo.springsecurity.model.Role;
import org.example.demo.springsecurity.model.User;
import org.example.demo.springsecurity.repository.RoleRepository;
import org.example.demo.springsecurity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitService {


    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @PostConstruct
    public void init(){
        createRoles();
        createAdmin();
    }



    private void createRoles() {
        List<String> roleNames = List.of("ADMIN", "USER");


        roleNames.forEach(roleName -> {
            if (!roleRepository.existsByRoleName(roleName)) {
                Role role = new Role();
                role.setRoleName(roleName);
                roleRepository.save(role);
            } else {
                System.out.println("Role %s already exists");
            }
        });
    }

    private void createAdmin() {
        Role adminRole = roleRepository.findByRoleName("ADMIN");

        if (!userRepository.existsByUsername("admin")) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role(adminRole)
                    .build();
            userRepository.save(admin);
            System.out.println("Admin User Created");
        } else {
            System.out.println("Admin User Exists");
        }


    }

}
