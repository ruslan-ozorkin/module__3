package com.ozorkin;

import com.ozorkin.model.Student;
import com.ozorkin.repository.GroupRepository;
import com.ozorkin.repository.StudentRepository;
import com.ozorkin.service.StudentGroupService;
import com.ozorkin.service.StudentService;
import com.ozorkin.utils.FlyMigration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FlyMigration.migrateDB();

        StudentGroupService studentGroupService = new StudentGroupService( new GroupRepository(),new StudentRepository());
        StudentService studentService = new StudentService(new StudentRepository());

        System.out.println(studentGroupService.getById("ID-1"));
        System.out.println(studentGroupService.getAll());
        System.out.println(studentGroupService.getGroupByName("1"));
        studentGroupService.countStudentsByGroup();
        studentGroupService.avgMarksByGroup();
        studentGroupService.findTeacherByName("Salo").forEach(System.out::println);
        studentGroupService.subjectsStatistic().forEach(s -> System.out.println(Arrays.toString(s)));
        studentGroupService.studentsWithHigherAvgMarks(30).forEach(System.out::println);
        System.out.println(studentService.getById("STUDENT_5"));

        Student randomStudent = studentService.createStudent();
        System.out.println(randomStudent);
        studentService.getAll().forEach(System.out::println);


    }
}
