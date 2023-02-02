package com.example.hibernate_learning.repisitory;

import com.example.hibernate_learning.entity.Persons;
import com.example.hibernate_learning.entity.PersonsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, PersonsKey> {
    @Query("select p from Persons p where p.cityOfLiving = :cityOfLiving")
    List<Persons> findPersonsByCity(@Param("cityOfLiving") String cityOfLiving);

    @Query("select p from Persons p where p.personsKey.age <= :age ")
    List<Persons> findPersonByAgeBefore(@Param("age") int age);

    @Query("select p from Persons p where p.personsKey.name = :name and p.personsKey.surname = :surname")
    Optional<Persons> findPersonByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
