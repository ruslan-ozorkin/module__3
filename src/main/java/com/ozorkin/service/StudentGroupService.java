package com.ozorkin.service;

import com.ozorkin.model.*;
import com.ozorkin.repository.Repository;

import java.util.*;

public class StudentGroupService {
    private static Repository<StudentGroup> studentGroupRepository;
    private static Repository<Student> studentRepository;

    public StudentGroupService(final Repository<StudentGroup> studentGroupRepository, final Repository<Student> studentRepository) {
        this.studentGroupRepository = studentGroupRepository;
        this.studentRepository = studentRepository;
    }
    public StudentGroupService(final Repository<StudentGroup> studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }


    public StudentGroup createStudentGroup() {
        StudentGroup studentGroup = new StudentGroup();
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setAge(18);
            student.setFirstname("Ivan");
            student.setSurname("Mikilan");
            studentList.add(student);

            Teacher teacher1 = new Teacher("TEACHER1", "KIRBY", 30);

            Subject subject1 = new Subject();
            subject1.setSubjectName("Math");


            teacher1.setSubject(subject1);
            subject1.setTeacher(teacher1);

            List<Marks> marksList = new ArrayList<>();
            Marks marks1 = new Marks();

            marks1.setSubject(subject1);
            marks1.setStudent(student);
            marks1.setMark(5);

            subject1.setMark(marks1);

            marksList.add(marks1);


            student.setStudentGroup(studentGroup);
            student.setMarks(marksList);


        }
        studentGroup.setStudentList(studentList);
        studentGroup.setGroupName("GROUP_1");
        studentGroupRepository.save(studentGroup);


        return studentGroup;
    }
    public List<StudentGroup> getAll() {
        return studentGroupRepository.getAll();
    }

    public Optional<List<StudentGroup>> getGroupByName(String name) {
        return studentGroupRepository.getGroupByName(name);
    }
    public void countStudentsByGroup () {
        studentGroupRepository.countStudentsByGroup();
    }
    public void avgMarksByGroup () {
        studentGroupRepository.avgMarksByGroup();
    }

    public List<Teacher> findTeacherByName(String name) {

        return studentGroupRepository.findTeacherByName(name);

    }
    public List<Object[]> subjectsStatistic() {

        return studentGroupRepository.subjectsStatistic();

    }
    public List<Student>  studentsWithHigherAvgMarks(double mark) {
        return studentGroupRepository.studentsWithHigherAvgMarks(mark);
    }


}
