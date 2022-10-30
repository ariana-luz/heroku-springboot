package com.example.portfolio.Interface;

import com.example.portfolio.Model.AcercaDe;
import java.util.List;

public interface IAcercaDeService {
    //método para traer todos los perfiles
    public List<AcercaDe> getAcercaDe();
    
    //método para dar de alta un perfil
    public void saveAcercaDe (AcercaDe acercaDe);
    
    //método para borrar un perfil
    public void deleteAcercaDe(Long id);
    
    //método para encontrar un perfil
    public AcercaDe findAcercaDe (Long id);
}
