package com.Usercommentproject.repository;

import com.Usercommentproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
