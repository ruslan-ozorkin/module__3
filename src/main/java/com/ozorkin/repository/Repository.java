package com.ozorkin.repository;

import com.ozorkin.model.Student;
import com.ozorkin.model.StudentGroup;
import com.ozorkin.model.Teacher;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Repository<T> {
    void save(final T student);

    List<T> getAll();

    Optional<T> getById(final String id);

    void delete(final String id);

    Optional<List<StudentGroup>> getGroupByName(String name);

    void countStudentsByGroup();
    void avgMarksByGroup ();
    List<Teacher> findTeacherByName(String name);
    List<Object[]>  subjectsStatistic();
    List<Student>  studentsWithHigherAvgMarks(double mark);

}