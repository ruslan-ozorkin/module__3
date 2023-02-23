package com.ozorkin.service;

import com.ozorkin.config.HibernateUtil;
import com.ozorkin.model.*;
import com.ozorkin.repository.GroupRepository;
import com.ozorkin.repository.StudentRepository;
import com.ozorkin.utils.FlyMigration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

public class StudentGroupService {
    private static GroupRepository studentGroupRepository;
    private static StudentRepository studentRepository;
    private static StudentGroupService instance;
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentGroupService.class);

    public static StudentGroupService getInstance() {
        if (instance == null) {
            instance = new StudentGroupService(GroupRepository.getInstance(),StudentRepository.getInstance());
        }
        return instance;
    }
    public StudentGroupService(final GroupRepository studentGroupRepository, final StudentRepository studentRepository) {
        this.studentGroupRepository = studentGroupRepository;
        this.studentRepository = studentRepository;

    }
    public void save(StudentGroup studentGroup) {
        studentGroupRepository.save(studentGroup);
    }
    public List<StudentGroup> getAll() {
        return studentGroupRepository.getAll();
    }
    public Optional<StudentGroup> getById(String id) {
        return studentGroupRepository.getById(id);
    }



    public Optional<List<StudentGroup>> getGroupByName(String name) {
    final EntityManager entityManager = HibernateUtil.getEntityManager();
        LOGGER.info("Getting group(s) by name  {}", name);
    return Optional.ofNullable(entityManager.createQuery("from StudentGroup where groupName like :name", StudentGroup.class)
            .setParameter("name", '%' + name + '%')
            .getResultList());
}

    public void countStudentsByGroup() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        LOGGER.info("Count students by group...: ");

        Query nativeQuery = entityManager.createNativeQuery("select t2.groupname, count(t1.student_id) as student_count\n" +
                "FROM student as t1\n" +
                "JOIN studentgroup as t2 ON t2.groupid = t1.groupid\n" +
                "GROUP BY t2.groupname");
        List<Object[]> objects = nativeQuery.getResultList();
        for (Object[] object : objects) {
            System.out.println(Arrays.toString(object));
        }

    }
    public void avgMarksByGroup() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        LOGGER.info("Count average marks by  group(s)... ");

        Query nativeQuery = entityManager.createNativeQuery(
                "select t1.groupname, avg(t3.mark) as avg_marks\n" +
                        "FROM studentgroup as t1\n" +
                        "JOIN student as t2 ON t2.groupid = t1.groupid\n" +
                        "JOIN marks as t3 on t3.student_id=t2.student_id GROUP BY t1.groupname");
        List<Object[]> objects = nativeQuery.getResultList();
        for (Object[] object : objects) {
            System.out.println(Arrays.toString(object));
        }
    }
    public List<Teacher> findTeacherByName(String name) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        LOGGER.info("Searching teacher by name: {}", name);

        List<Teacher> resultList =(List<Teacher>) entityManager.createNativeQuery(
                        "select * from teacher where firstname = :name or surname = :name", Teacher.class)
                .setParameter("name", name)
                .getResultList();

        return resultList;
    }

    public List<Object[]>  subjectsStatistic() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        LOGGER.info("Getting subject statistics..:");

        List<Object[]> resultList = entityManager.createNativeQuery(
                        "(select t1.subjectname, avg(t2.mark) as avg_mark from subject as t1 " +
                                "join marks as t2 on t2.mark_id=t1.marks_id " +
                                "group by t1.subjectname order by  avg_mark asc limit 1)" +
                                "union " +
                                "(select   t1.subjectname, avg(t2.mark) as avg_mark from subject as t1 " +
                                "join marks as t2 on t2.mark_id=t1.marks_id " +
                                "group by t1.subjectname order by  avg_mark desc limit 1)" )
                .getResultList();

        return resultList;
    }

    public List<Student>  studentsWithHigherAvgMarks(double mark) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        LOGGER.info("Looking for students with higher average marks than {}",mark);

        List<Student> result = entityManager.createNativeQuery(
                        "select t1.firstname, t1.surname, t1.student_id, t1.age, t1.rep_date, t1.groupid " +
                                "from student as t1 " +
                                "join (SELECT student_id, avg(mark) AS avg_mark FROM marks group by student_id) as t2 " +
                                "on t2.student_id = t1.student_id " +
                                "where t2.avg_mark > :mark", Student.class)
                .setParameter("mark", mark)
                .getResultList();

        return result;
    }


}
