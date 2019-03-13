package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CourseRepository repository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... strings) throws Exception {
        Course course = new Course("Astrophysics", "Neil D Tyson", "Just a course on stars", 3);
        repository.save(course);

        course = new Course("Calculus", "Carol Henley", "Rate of Change of the Rate of Change", 3);
        repository.save(course);

        course = new Course("Freshman English", "Geraldine Pegram", "Learn your Language children", 3);
        repository.save(course);

        Car car = new Car("1999", "Buick", "Skylark");
        carRepository.save(car);

        car = new Car("1994", "Honda", "Accord");
        carRepository.save(car);

        car = new Car("2019", "Toyota", "Corolla");
        carRepository.save(car);
    }
}
