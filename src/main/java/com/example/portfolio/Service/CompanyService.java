package com.example.portfolio.Service;

import com.example.portfolio.Interface.ICompanyService;
import com.example.portfolio.Model.Company;
import com.example.portfolio.Repository.CompanyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements ICompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getCompany() {
        List<Company> listaCompany = companyRepository.findAll();
        return listaCompany;
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company findCompany(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        return company;
    }
}
