package com.example.portfolio.Interface;

import com.example.portfolio.Model.Company;
import java.util.List;

public interface ICompanyService {
        //método para traer todas las compañías
    public List<Company> getCompany();
    
    //método para dar de alta una compañía
    public void saveCompany (Company company);
    
    //método para borrar una compañía
    public void deleteCompany(Long id);
    
    //método para encontrar una compañía
    public Company findCompany (Long id);
}
