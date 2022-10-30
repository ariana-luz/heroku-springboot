package com.example.portfolio.Interface;

import com.example.portfolio.Model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    //método para traer todas las experiencias
    public List<Experiencia> getExperiencia();
    
    //método para dar de alta una experiencia
    public void saveExperiencia (Experiencia experiencia);
    
    //método para borrar una experiencia
    public void deleteExperiencia(Long id);
    
    //método para encontrar una experiencia
    public Experiencia findExperiencia (Long id);

}
