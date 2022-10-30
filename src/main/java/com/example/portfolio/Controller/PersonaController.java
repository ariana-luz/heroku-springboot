package com.example.portfolio.Controller;

import com.example.portfolio.Interface.IPersonaService;
import com.example.portfolio.Model.Persona;
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

@CrossOrigin(origins = "*")
@RestController
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;

    @CrossOrigin(origins = "*")
    @GetMapping("/persona/traer")
    public List<Persona> getPersona() {
        return interPersona.getPersona();
    }

    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona) {
        interPersona.savePersona(persona);
        return "Creado correctamente";
    }

    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        interPersona.deletePersona(id);
        return "Eliminado correctamente";
    }

    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("fullname") String nuevoFullname,
            @RequestParam("backImage") String nuevoBackImage,
            @RequestParam("image") String nuevoImage,
            @RequestParam("profession") String nuevoProfession,
            @RequestParam("company") String nuevoCompany,
            @RequestParam("school") String nuevoSchool,
            @RequestParam("location") String nuevoLocation,
            @RequestParam("contact") String nuevoContact) {

        Persona persona = interPersona.findPersona(id);

        persona.setFullname(nuevoFullname);
        persona.setBackImage(nuevoBackImage);
        persona.setImage(nuevoImage);
        persona.setProfession(nuevoProfession);
        persona.setCompany(nuevoCompany);
        persona.setSchool(nuevoSchool);
        persona.setLocation(nuevoLocation);
        persona.setContact(nuevoContact);

        interPersona.savePersona(persona);
        return persona;
    }
}
