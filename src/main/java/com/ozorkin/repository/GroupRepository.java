package com.ozorkin.repository;

import com.ozorkin.config.HibernateUtil;
import com.ozorkin.model.Student;
import com.ozorkin.model.StudentGroup;
import com.ozorkin.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

public class GroupRepository implements Repository<StudentGroup> {
    @Override
    public void save(StudentGroup studentGroup) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(studentGroup);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<StudentGroup> getAll() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery("from StudentGroup", StudentGroup.class).getResultList();

    }

    @Override
    public Optional<StudentGroup> getById(String id) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return Optional.ofNullable(entityManager.find(StudentGroup.class, id));
    }

    @Override
    public void delete(String id) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from StudentGroup where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.getTransaction().commit();

    }


@Override
    public Optional<List<StudentGroup>> getGroupByName(String name) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();



        return Optional.ofNullable(entityManager.createQuery("from StudentGroup where groupName like :name", StudentGroup.class)
                .setParameter("name", '%' + name + '%')
                .getResultList());
    }
    @Override
    public void countStudentsByGroup() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        Query nativeQuery = entityManager.createNativeQuery("select t2.groupname, count(t1.student_id) as student_count\n" +
                "FROM student as t1\n" +
                "JOIN studentgroup as t2 ON t2.groupid = t1.groupid\n" +
                "GROUP BY t2.groupname");
        List<Object[]> objects = nativeQuery.getResultList();
        for (Object[] object : objects) {
            System.out.println(Arrays.toString(object));
        }

    }

    @Override
    public void avgMarksByGroup() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
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
        List<Teacher> resultList =(List<Teacher>) entityManager.createNativeQuery(
                        "select * from teacher where firstname = :name or surname = :name", Teacher.class)
                .setParameter("name", name)
                .getResultList();

        return resultList;
    }

    public List<Object[]>  subjectsStatistic() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
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
