package com.Blog_Project.Repositories;

import com.Blog_Project.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> { //< User - means we perform operations on user entity and id is Integer >
    Optional<User> findByEmail(String email);
}
