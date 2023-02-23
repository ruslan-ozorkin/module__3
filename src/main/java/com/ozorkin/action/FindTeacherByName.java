package com.ozorkin.action;

import com.ozorkin.model.Teacher;
import com.ozorkin.utils.UserInput;

import java.util.List;

public class FindTeacherByName implements Action {
    @Override
    public void execute() {
        final String name = UserInput.writeName();
        List<Teacher> teacherByName = STUDENT_GROUP_SERVICE.findTeacherByName(name);
        if (teacherByName.size()==0) {
            System.out.println("There is no teacher with this name");
        } else {
            teacherByName.forEach(System.out::println);
        }

    }
}
