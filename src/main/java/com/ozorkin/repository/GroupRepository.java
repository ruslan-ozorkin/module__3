package com.ozorkin.repository;

import com.ozorkin.config.HibernateUtil;
import com.ozorkin.model.StudentGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import java.util.*;

public class GroupRepository  {
    private static GroupRepository instance;
    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupRepository.class);


    public void save(StudentGroup studentGroup) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        LOGGER.info("Saving studentGroup with id {}", studentGroup.getGroupId());

        entityManager.persist(studentGroup);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<StudentGroup> getAll() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        LOGGER.info("Getting all groups from repository: ");
        return entityManager.createQuery("from StudentGroup", StudentGroup.class).getResultList();

    }

    public Optional<StudentGroup> getById(String id) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return Optional.ofNullable(entityManager.find(StudentGroup.class, id));
    }

}
