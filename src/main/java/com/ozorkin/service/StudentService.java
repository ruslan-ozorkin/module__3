package com.ozorkin.service;

import com.ozorkin.model.Student;
import com.ozorkin.repository.Repository;


public class StudentService {
    private final Repository<Student> studentRepository;
    private static StudentService instance;

    public StudentService(final Repository<Student> repository) {
        this.studentRepository = repository;

    }
    public Student createStudent() {
        Student student = new Student();
        student.setAge(18);
        student.setFirstname("Ivan");
        student.setSurname("Mikilan");
       // student.setSubjects(new ArrayList<>());




        return student;
    }

}
