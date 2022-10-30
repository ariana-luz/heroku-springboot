package com.example.portfolio.Repository;

import com.example.portfolio.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
    
}
