package com.example.portfolio.Interface;

import com.example.portfolio.Model.School;
import java.util.List;

public interface ISchoolService {
    //método para traer todas las escuelas
    public List<School> getSchool();
    
    //método para dar de alta una escuela
    public void saveSchool (School school);
    
    //método para borrar una escuela
    public void deleteSchool(Long id);
    
    //método para encontrar una escuela
    public School findSchool (Long id);
}
