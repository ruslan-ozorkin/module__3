//package com.ozorkin.repository;
//
//import com.ozorkin.config.HibernateUtil;
//import com.ozorkin.model.Student;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//public class StudentRepository implements Repository <Student> {
//
//    @Override
//    public void save(Student student) {
//        final EntityManager entityManager = HibernateUtil.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(student);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//
//    @Override
//    public List<Student> getAll() {
//        final EntityManager entityManager = HibernateUtil.getEntityManager();
//        return entityManager.createQuery("from Student", Student.class).getResultList();
//
//    }
//
//    @Override
//    public Optional<Student> getById(String id) {
//        final EntityManager entityManager = HibernateUtil.getEntityManager();
//        return Optional.ofNullable(entityManager.find(Student.class, id));
//    }
//
//    @Override
//    public void delete(String id) {
//        final EntityManager entityManager = HibernateUtil.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.createQuery("delete from Student where id = :id")
//                .setParameter("id", id)
//                .executeUpdate();
//        entityManager.getTransaction().commit();
//
//    }
//}
