package org.example.demo.springsecurity.repository;

import org.example.demo.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByUsername(String username);

    boolean existsByUsername(String username);

    @Query(value = "SELECT r.role_name FROM users u " +
            "JOIN roles r ON u.role_id = r.id WHERE u.username=:username",nativeQuery = true)
    String getUserRole(@Param("username") String username);
}
