package com.ozorkin;

import com.ozorkin.repository.GroupRepository;
import com.ozorkin.service.StudentGroupService;
import com.ozorkin.service.StudentService;

public class Main {
    public static void main(String[] args) {
       // StudentService studentService = new StudentService(new StudentRepository());
        StudentGroupService studentGroupService = new StudentGroupService(new GroupRepository());


        System.out.println(studentGroupService.getAll());
        System.out.println(studentGroupService.getGroupByName("1"));
        System.out.println(studentGroupService.countStudentsByGroup());
    }
}
