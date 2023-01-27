package com.example.hibernate_learning.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AfterStartSettings {

    private static List<Persons> personsList;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void fillInTheTable() {

        personsList = List.of(new Persons(new PersonsKey("Денис", "Знобишин", 31), "Nizhny Novgorod", "+799999922"),
                new Persons(new PersonsKey("Елена", "Знобишина", 32), "Moscow", "+799555522"),
                new Persons(new PersonsKey("Сергей", "Филькин", 45), "Kazan", "+791219922"),
                new Persons(new PersonsKey("Василий", "Теркин", 53), "Moscow", "+799544922"),
                new Persons(new PersonsKey("Валера", "Камушкин", 23), "Moscow", "+799111122"));
        personsList.forEach(entity -> entityManager.persist(entity));
    }
}
