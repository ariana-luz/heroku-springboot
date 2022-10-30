package com.example.portfolio.Controller;

import com.example.portfolio.Dto.EducacionDto;
import com.example.portfolio.Interface.IEducacionService;
import com.example.portfolio.Model.Educacion;
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

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
@RestController
public class EducacionController {

    @Autowired
    private IEducacionService interEducacion;

    @GetMapping("/educacion/traer")
    public List<Educacion> getEducacion() {
        return interEducacion.getEducacion();
    }

    @GetMapping("/educacion/detail/{id}")
    public ResponseEntity<Educacion> findEducacion(@PathVariable("id") Long id) {
        Educacion educacion = interEducacion.findEducacion(id);
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/educacion/crear")
    public ResponseEntity createEducacion(@RequestBody Educacion educacion) {
        interEducacion.saveEducacion(educacion);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/educacion/borrar/{id}")
    public ResponseEntity deleteEducacion(@PathVariable Long id) {
        interEducacion.deleteEducacion(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/educacion/editar/{id}")
    public ResponseEntity<?> editEducacion(@PathVariable("id") Long id, @RequestBody EducacionDto educacionDto){
        
        Educacion educacion = interEducacion.findEducacion(id);

        educacion.setSchool(educacionDto.getSchool());
        educacion.setCareer(educacionDto.getCareer());
        educacion.setImg(educacionDto.getImg());
        educacion.setUrl(educacionDto.getUrl());

        interEducacion.saveEducacion(educacion);
        return new ResponseEntity(HttpStatus.OK);
    }
}
