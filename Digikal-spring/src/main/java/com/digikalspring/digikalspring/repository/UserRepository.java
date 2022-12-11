package com.digikalspring.digikalspring.repository;

import com.digikalspring.digikalspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findUserByEmailAndPassword(String username,String password);
    Optional<User> findUserById(Long id);
    String findByEmail(String email);

}
