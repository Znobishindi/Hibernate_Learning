package com.example.hibernate_learning.controller;

import com.example.hibernate_learning.repisitory.TestRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping("/persons/by-city")
    public List returnPersonsByCity(@RequestParam("city") String city){
        return testRepository.getPersonsByCity(city);
    }
}
