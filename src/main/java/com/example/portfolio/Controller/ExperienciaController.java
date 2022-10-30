package com.example.portfolio.Controller;

import com.example.portfolio.Dto.ExperienciaDto;
import com.example.portfolio.Interface.IExperienciaService;
import com.example.portfolio.Model.Experiencia;
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

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService interExperiencia;
    
    @GetMapping("/experiencia/traer")
    public List<Experiencia> getExperiencia() {
        return interExperiencia.getExperiencia();
    }
    
    @GetMapping("/experiencia/detail/{id}")
    public ResponseEntity<Experiencia> findExperiencia(@PathVariable("id") Long id){
        Experiencia experiencia = interExperiencia.findExperiencia(id);
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/experiencia/crear")
    public ResponseEntity createExperiencia(@RequestBody Experiencia experiencia) {
        interExperiencia.saveExperiencia(experiencia);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public ResponseEntity deleteExperiencia(@PathVariable Long id) {
        interExperiencia.deleteExperiencia(id);
//            return "Eliminado correctamente";
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("/experiencia/editar/{id}")
    public ResponseEntity<?> editExperiencia(@PathVariable("id") Long id, @RequestBody ExperienciaDto experienciaDto){
        
        Experiencia experiencia = interExperiencia.findExperiencia(id);
        experiencia.setPosition(experienciaDto.getPosition());
        experiencia.setCompany(experienciaDto.getCompany());
        experiencia.setImg(experienciaDto.getImg());
        experiencia.setUrl(experienciaDto.getUrl());
        
        interExperiencia.saveExperiencia(experiencia);
        return new ResponseEntity(HttpStatus.OK);
             
    }
   
}
