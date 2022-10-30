package com.example.portfolio.Interface;

import com.example.portfolio.Model.Educacion;
import java.util.List;

public interface IEducacionService {
     //método para traer todos los estudios
    public List<Educacion> getEducacion();
    
    //método para dar de alta un estudio
    public void saveEducacion (Educacion educacion);
    
    //método para borrar un estudio
    public void deleteEducacion(Long id);
    
    //método para encontrar un estudio
    public Educacion findEducacion (Long id);
}
