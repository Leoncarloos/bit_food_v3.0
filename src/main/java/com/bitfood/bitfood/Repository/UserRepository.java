package com.bitfood.bitfood.Repository;

import com.bitfood.bitfood.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername (String username);
}
