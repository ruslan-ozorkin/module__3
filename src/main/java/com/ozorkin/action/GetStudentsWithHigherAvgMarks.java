package com.ozorkin.action;

import com.ozorkin.utils.UserInput;


public class GetStudentsWithHigherAvgMarks implements Action {

    @Override
    public void execute() {
        final double number = UserInput.getNumber();
        STUDENT_GROUP_SERVICE.studentsWithHigherAvgMarks(number).forEach(System.out::println);
    }
}
