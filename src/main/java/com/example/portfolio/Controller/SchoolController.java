package com.example.portfolio.Controller;

import com.example.portfolio.Interface.ISchoolService;
import com.example.portfolio.Model.School;
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

@RestController
public class SchoolController {
    @Autowired
    private ISchoolService interSchool;

    @CrossOrigin(origins = "*")
    @GetMapping("/school/traer")
    public List<School> getSchool() {
        return interSchool.getSchool();
    }

    @PostMapping("/school/crear")
    public String createSchool(@RequestBody School school) {
        interSchool.saveSchool(school);
        return "Creado correctamente";
    }

    @DeleteMapping("/school/borrar/{id}")
    public String deleteSchool(@PathVariable Long id) {
        interSchool.deleteSchool(id);
        return "Eliminado correctamente";
    }

    @PutMapping("/school/editar/{id}")
    public School editSchool(@PathVariable Long id,
            @RequestParam("name") String nuevoName,
            @RequestParam("img") String nuevoImg,
            @RequestParam("url") String nuevoUrl) {

        School school = interSchool.findSchool(id);

        school.setName(nuevoName);
        school.setImg(nuevoImg);
        school.setUrl(nuevoUrl);

        interSchool.saveSchool(school);
        return school;
    }
}
