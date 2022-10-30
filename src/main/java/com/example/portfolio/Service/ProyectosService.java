package com.example.portfolio.Service;

import com.example.portfolio.Interface.IProyectosService;
import com.example.portfolio.Model.Proyectos;
import com.example.portfolio.Repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService {

    @Autowired
    private ProyectosRepository proyectosRepository;

    @Override
    public List<Proyectos> getProyectos() {
        List<Proyectos> listaProyectos = proyectosRepository.findAll();
        return listaProyectos;
    }

    @Override
    public void saveProyectos(Proyectos proyectos) {
        proyectosRepository.save(proyectos);
    }

    @Override
    public void deleteProyectos(Long id) {
        proyectosRepository.deleteById(id);
    }

    @Override
    public Proyectos findProyectos(Long id) {
        Proyectos proyectos = proyectosRepository.findById(id).orElse(null);
        return proyectos;
    }
}
