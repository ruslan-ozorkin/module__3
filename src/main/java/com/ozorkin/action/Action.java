package com.ozorkin.action;

import com.ozorkin.service.StudentGroupService;
import com.ozorkin.service.StudentService;

public interface Action {

    StudentGroupService STUDENT_GROUP_SERVICE = StudentGroupService.getInstance();
    StudentService STUDENT_SERVICE = StudentService.getInstance();

    void execute();
}
