package com.ozorkin;

import com.ozorkin.repository.GroupRepository;
import com.ozorkin.service.StudentGroupService;
import com.ozorkin.service.StudentService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       // StudentService studentService = new StudentService(new StudentRepository());
        StudentGroupService studentGroupService = new StudentGroupService(new GroupRepository());


        System.out.println(studentGroupService.getAll());
        System.out.println(studentGroupService.getGroupByName("1"));
        studentGroupService.countStudentsByGroup();
        studentGroupService.avgMarksByGroup();
        studentGroupService.findTeacherByName("Salo").forEach(System.out::println);
        studentGroupService.subjectsStatistic().forEach(s -> System.out.println(Arrays.toString(s)));
        studentGroupService.studentsWithHigherAvgMarks(30).forEach(System.out::println);
    }
}
