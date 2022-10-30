package com.example.portfolio.Repository;

import com.example.portfolio.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>{
    
}
