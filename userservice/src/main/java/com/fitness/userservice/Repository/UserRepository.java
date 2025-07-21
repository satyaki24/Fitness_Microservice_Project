package com.fitness.userservice.Repository;

import com.fitness.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String > {
    boolean existsByEmail(String email);
}
