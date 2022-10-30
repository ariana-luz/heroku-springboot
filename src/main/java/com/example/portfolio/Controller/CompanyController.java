package com.example.portfolio.Controller;

import com.example.portfolio.Interface.ICompanyService;
import com.example.portfolio.Model.Company;
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
public class CompanyController {

    @Autowired
    private ICompanyService interCompany;

    @CrossOrigin(origins = "*")
    @GetMapping("/company/traer")
    public List<Company> getCompany() {
        return interCompany.getCompany();
    }

    @PostMapping("/company/crear")
    public String createCompany(@RequestBody Company company) {
        interCompany.saveCompany(company);
        return "Creado correctamente";
    }

    @DeleteMapping("/company/borrar/{id}")
    public String deleteCompany(@PathVariable Long id) {
        interCompany.deleteCompany(id);
        return "Eliminado correctamente";
    }

    @PutMapping("/company/editar/{id}")
    public Company editCompany(@PathVariable Long id,
            @RequestParam("name") String nuevoName,
            @RequestParam("img") String nuevoImg,
            @RequestParam("url") String nuevoUrl) {
        Company company = interCompany.findCompany(id);
        company.setName(nuevoName);
        company.setImg(nuevoImg);
        company.setUrl(nuevoUrl);

        interCompany.saveCompany(company);
        return company;
    }
}
