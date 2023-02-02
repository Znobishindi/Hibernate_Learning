package com.example.hibernate_learning.repisitory;
import com.example.hibernate_learning.entity.Persons;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TestRepository {

 private final PersonsRepository personsRepository;

    public TestRepository(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }




    @Transactional
    public List getPersonsByCity(String city){
        return personsRepository.findPersonsByCity(city);
    }
    @Transactional
    public List getPersonsByAgeAndSort(int age){
        return personsRepository.findPersonByAgeBefore(age);
    }

    @Transactional
    public Optional<Persons> getPersonsByNameAndSurname(String name,String surname){
        return personsRepository.findPersonByNameAndSurname(name,surname);
    }

}
