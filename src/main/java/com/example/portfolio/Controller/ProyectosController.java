package com.example.portfolio.Controller;

import com.example.portfolio.Interface.IProyectosService;
import com.example.portfolio.Model.Proyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://portfolio-ariana-osuna-vargas.web.app")
@RestController
public class ProyectosController {
    @Autowired
    private IProyectosService interProyectos;

    
    @GetMapping("/proyectos/traer")
    public List<Proyectos> getProyectos() {
        return interProyectos.getProyectos();
    }

    @PostMapping("/proyectos/crear")
    public String createProyectos(@RequestBody Proyectos proyectos) {
        interProyectos.saveProyectos(proyectos);
        return "Creado correctamente";
    }

    @DeleteMapping("/proyectos/borrar/{id}")
    public String deleteProyectos(@PathVariable Long id) {
        interProyectos.deleteProyectos(id);
        return "Eliminado correctamente";
    }

    @PutMapping("/proyectos/editar/{id}")
    public Proyectos editProyectos(@PathVariable Long id,
            @RequestParam("name") String nuevoName,
            @RequestParam("school") String nuevoSchool,
            @RequestParam("img") String nuevoImg,
            @RequestParam("url") String nuevoUrl) {

        Proyectos proyectos = interProyectos.findProyectos(id);

        proyectos.setName(nuevoName);
        proyectos.setSchool(nuevoSchool);
        proyectos.setImg(nuevoImg);
        proyectos.setUrl(nuevoUrl);

        interProyectos.saveProyectos(proyectos);
        return proyectos;
    }
}
