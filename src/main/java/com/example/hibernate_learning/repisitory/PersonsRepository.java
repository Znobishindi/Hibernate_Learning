package com.example.hibernate_learning.repisitory;

import com.example.hibernate_learning.entity.Persons;
import com.example.hibernate_learning.entity.PersonsKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, PersonsKey> {

    List<Persons> findByCityOfLiving(String cityOfLiving);
    List<Persons> findByPersonsKey_AgeBefore(int age);

    Optional<Persons> findByPersonsKey_NameAndPersonsKey_Surname(String personsKey_name, String personsKey_surname);
}
