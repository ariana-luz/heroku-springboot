package com.example.portfolio.Controller;

import com.example.portfolio.Interface.ICertificacionesService;
import com.example.portfolio.Model.Certificaciones;
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
public class CertificacionesController {

    @Autowired
    private ICertificacionesService interCertificaciones;

    @CrossOrigin(origins = "*")
    @GetMapping("/certificaciones/traer")
    public List<Certificaciones> getCertificaciones() {
        return interCertificaciones.getCertificaciones();
    }

    @PostMapping("/certificaciones/crear")
    public String createCertificaciones(@RequestBody Certificaciones certificaciones) {
        interCertificaciones.saveCertificaciones(certificaciones);
        return "Creado correctamente";
    }

    @DeleteMapping("/certificaciones/borrar/{id}")
    public String deleteCertificaciones(@PathVariable Long id) {
        interCertificaciones.deleteCertificaciones(id);
        return "Eliminado correctamente";
    }

    @PutMapping("/certificaciones/editar/{id}")
    public Certificaciones editCertificaciones(@PathVariable Long id,
            @RequestParam("title") String nuevoTitle,
            @RequestParam("school") String nuevoSchool,
            @RequestParam("img") String nuevoImg,
            @RequestParam("url") String nuevoUrl) {

        Certificaciones certificaciones = interCertificaciones.findCertificaciones(id);
        certificaciones.setTitle(nuevoTitle);
        certificaciones.setSchool(nuevoSchool);
        certificaciones.setImg(nuevoImg);
        certificaciones.setUrl(nuevoUrl);

        interCertificaciones.saveCertificaciones(certificaciones);
        return certificaciones;
    }
}
