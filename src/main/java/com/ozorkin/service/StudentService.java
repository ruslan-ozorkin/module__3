package com.ozorkin.service;

import com.ozorkin.model.Student;
import com.ozorkin.model.StudentGroup;
import com.ozorkin.repository.StudentRepository;
import com.ozorkin.utils.RandomStringBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class StudentService {
    private  StudentRepository studentRepository;
    private static StudentService instance;

    private static final Random RANDOM = new Random();

    public StudentService() {
        studentRepository=StudentRepository.getInstance();

    }

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    public StudentService(final StudentRepository studentGroupRepository) {
        this.studentRepository = studentGroupRepository;
    }
    public void save(Student student) {
        studentRepository.save(student);
    }
    public List<Student> getAll() {
        return studentRepository.getAll();
    }
    public Optional<Student> getById(String id) {
        return studentRepository.getById(id);
    }

    public Student createStudent() {
        Student.StudentBuilder studentBuilder =new Student.StudentBuilder();
        Student student = studentBuilder
                .withId()
                .withFirstname(RandomStringBuilder.createString())
                .withSurname(RandomStringBuilder.createString())
                .withAge(RANDOM.nextInt(16,60))
                .withDateTime(LocalDateTime.now())
                .build();
        studentRepository.save(student);
        return student;
    }


}
