package com.example.hibernate_learning.repisitory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public List getPersonsByCity(String city){
        var query = entityManager.createQuery("SELECT p from Persons p where p.city_of_living = :city").setParameter("city",city);
        return query.getResultList();
    }

}
