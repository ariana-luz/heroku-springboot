package com.example.portfolio.Interface;

import com.example.portfolio.Model.Certificaciones;
import java.util.List;

public interface ICertificacionesService {
    //método para traer todas las certificaciones
    public List<Certificaciones> getCertificaciones();
    
    //método para dar de alta una certificación
    public void saveCertificaciones (Certificaciones certificaciones);
    
    //método para borrar una certificación
    public void deleteCertificaciones(Long id);
    
    //método para encontrar una certificación
    public Certificaciones findCertificaciones (Long id);
}
