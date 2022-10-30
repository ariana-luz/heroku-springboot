package com.example.portfolio.Service;

import com.example.portfolio.Interface.ICertificacionesService;
import com.example.portfolio.Model.Certificaciones;
import com.example.portfolio.Repository.CertificacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificacionesService implements ICertificacionesService{

    @Autowired
    private CertificacionesRepository certificacionesRepository;

    @Override
    public List<Certificaciones> getCertificaciones() {
        List<Certificaciones> listaCertificaciones = certificacionesRepository.findAll();
        return listaCertificaciones;
    }

    @Override
    public void saveCertificaciones(Certificaciones certificaciones) {
        certificacionesRepository.save(certificaciones);
    }

    @Override
    public void deleteCertificaciones(Long id) {
        certificacionesRepository.deleteById(id);
    }

    @Override
    public Certificaciones findCertificaciones(Long id) {
        Certificaciones certificaciones = certificacionesRepository.findById(id).orElse(null);
        return certificaciones;
    }
    
}
