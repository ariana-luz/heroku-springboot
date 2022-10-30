package com.example.portfolio.Interface;

import com.example.portfolio.Model.Proyectos;
import java.util.List;

public interface IProyectosService {
        //método para traer todos los proyectos
    public List<Proyectos> getProyectos();
    
    //método para dar de alta un proyecto
    public void saveProyectos (Proyectos proyectos);
    
    //método para borrar un proyecto
    public void deleteProyectos(Long id);
    
    //método para encontrar un proyecto
    public Proyectos findProyectos (Long id);
}
