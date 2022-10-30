package com.example.portfolio.Repository;

import com.example.portfolio.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
