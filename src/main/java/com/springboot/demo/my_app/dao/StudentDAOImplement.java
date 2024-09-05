package com.springboot.demo.my_app.dao;

import com.springboot.demo.my_app.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class StudentDAOImplement implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;
    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    // implement methods save
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
        System.out.println("Student saved: " + student);
    }

    // implement method findById
    @Override
    @Transactional
    public Student findById(Integer id) {
        Student student = entityManager.find(Student.class, id);
        System.out.println("Student found: " + student);
        return student;
    }

    // implement method findAll
    @Override
    @Transactional
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student order by lastName desc", Student.class);
        List<Student> students = query.getResultList();
        System.out.println("Students found: " + students);
        return students;
    }

    // implement method findByLastName
    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {
        // create a query
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:lastName", Student.class);
        // set parameter
        query.setParameter("lastName", lastName);
        // execute query
        List<Student> students = query.getResultList();
        System.out.println("Students found: " + students);
        return students;
    }

    // implement method update
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
        System.out.println("Student updated: " + student);
    }

    // implement method delete
    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        System.out.println("Student deleted: " + student);
    }

    // implement method deleteAll
    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }

}
