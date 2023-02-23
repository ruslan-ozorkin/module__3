package com.ozorkin.action;

import com.ozorkin.service.StudentGroupService;

import java.util.Arrays;

public class GetSubjectStatistics implements Action{
    @Override
    public void execute() {
        STUDENT_GROUP_SERVICE.subjectsStatistic().forEach(s -> System.out.println(Arrays.toString(s)));;
    }
}
