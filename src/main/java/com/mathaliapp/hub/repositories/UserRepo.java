package com.mathaliapp.hub.repositories;

import com.mathaliapp.hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    void deleteUserById(Long id);
    void deleteUserByUserIdent(String userIdent);

    Optional<User> findUserById(Long id);
}
