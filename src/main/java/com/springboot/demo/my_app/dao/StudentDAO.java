package com.springboot.demo.my_app.dao;

import com.springboot.demo.my_app.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(Integer id);
    int deleteAll();
}
