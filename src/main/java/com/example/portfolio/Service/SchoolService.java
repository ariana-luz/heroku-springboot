package com.example.portfolio.Service;

import com.example.portfolio.Interface.ISchoolService;
import com.example.portfolio.Model.School;
import com.example.portfolio.Repository.SchoolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService implements ISchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public List<School> getSchool() {
        List<School> listaSchool = schoolRepository.findAll();
        return listaSchool;
    }

    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public School findSchool(Long id) {
        School school = schoolRepository.findById(id).orElse(null);
        return school;
    }
}
