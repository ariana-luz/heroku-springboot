package com.example.portfolio.Repository;

import com.example.portfolio.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User findByEmail(String email);
}
