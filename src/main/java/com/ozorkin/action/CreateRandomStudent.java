package com.ozorkin.action;

import com.ozorkin.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateRandomStudent implements Action{
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateRandomStudent.class);

    @Override
    public void execute() {
        LOGGER.info("Creating random Student...: ");
        Student randomStudent = STUDENT_SERVICE.createStudent();
        System.out.println(randomStudent);

    }
}
