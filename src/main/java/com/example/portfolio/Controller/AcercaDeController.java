package com.example.portfolio.Controller;

import com.example.portfolio.Dto.AcercaDeDto;
import com.example.portfolio.Interface.IAcercaDeService;
import com.example.portfolio.Model.AcercaDe;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class AcercaDeController {

    @Autowired
    private IAcercaDeService interAcercaDe;

    @GetMapping("/acercade/traer")
    public List<AcercaDe> getAcercaDe() {
        return interAcercaDe.getAcercaDe();
    }
  
    @GetMapping("/acercade/detail/{id}")
    public ResponseEntity<AcercaDe> findAcercaDe(@PathVariable("id") Long id){
        AcercaDe acercaDe = interAcercaDe.findAcercaDe(id);
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
    
    @PostMapping("/acercade/crear")
    public ResponseEntity createAcercaDe(@RequestBody AcercaDe acercaDe) {
        interAcercaDe.saveAcercaDe(acercaDe);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/acercade/borrar/{id}")
    public ResponseEntity deleteAcercaDe(@PathVariable Long id) {
        interAcercaDe.deleteAcercaDe(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/acercade/editar/{id}")
    public ResponseEntity<?> editAcercaDe(@PathVariable("id") Long id, @RequestBody AcercaDeDto acercaDeDto){
        
        AcercaDe acercaDe = interAcercaDe.findAcercaDe(id);
        acercaDe.setAbout(acercaDeDto.getAbout());

        interAcercaDe.saveAcercaDe(acercaDe);
        return new ResponseEntity(HttpStatus.OK);
    }
}
