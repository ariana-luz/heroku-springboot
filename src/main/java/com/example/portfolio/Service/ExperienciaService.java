package com.example.portfolio.Service;

import com.example.portfolio.Interface.IExperienciaService;
import com.example.portfolio.Model.Experiencia;
import com.example.portfolio.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository experienciaRepository;    

    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> listaExperiencia = experienciaRepository.findAll();
        return listaExperiencia;
    }
    
    public Optional<Experiencia> getOne(Long id){
        return experienciaRepository.findById(id);
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia experiencia = experienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
}
