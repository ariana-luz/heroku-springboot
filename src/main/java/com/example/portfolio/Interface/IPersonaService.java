package com.example.portfolio.Interface;

import com.example.portfolio.Model.Persona;
import java.util.List;

public interface IPersonaService {
    //método para traer todas las personas
    public List<Persona> getPersona();
    
    //método para dar de alta una persona
    public void savePersona (Persona persona);
    
    //método para borrar una persona
    public void deletePersona(Long id);
    
    //método para encontrar una persona
    public Persona findPersona (Long id);
}
