package com.example.portfolio.Service;

import com.example.portfolio.Interface.IAcercaDeService;
import com.example.portfolio.Model.AcercaDe;
import com.example.portfolio.Repository.AcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcercaDeService implements IAcercaDeService{

    @Autowired
    private AcercaDeRepository acercaDeRepository;

    @Override
    public List<AcercaDe> getAcercaDe() {
        List<AcercaDe> listaAcercaDe = acercaDeRepository.findAll();
        return listaAcercaDe;
    }

    @Override
    public void saveAcercaDe(AcercaDe acercaDe) {
        acercaDeRepository.save(acercaDe);
    }

    @Override
    public void deleteAcercaDe(Long id) {
        acercaDeRepository.deleteById(id);
    }

    @Override
    public AcercaDe findAcercaDe(Long id) {
        AcercaDe acercaDe = acercaDeRepository.findById(id).orElse(null);
        return acercaDe;
    }

}
