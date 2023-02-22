package com.ozorkin.repository;

import com.ozorkin.config.HibernateUtil;
import com.ozorkin.model.StudentGroup;

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
public Map<String, Object> countStudentsByGroup() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
    Query nativeQuery = entityManager.createNativeQuery("select t2.groupname, count(t1.student_id) as student_count\n" +
            "FROM student as t1\n" +
            "JOIN studentgroup as t2 ON t2.groupid = t1.groupid\n" +
            "GROUP BY t2.groupname");
    List<Object[]> objects = nativeQuery.getResultList();
    for (Object[] object : objects) {
        System.out.println(Arrays.toString(object));
    }

    return null;

    }
}
