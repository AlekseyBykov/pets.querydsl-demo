package dev.abykov.pets.querydsl.demo.service;

import dev.abykov.pets.querydsl.demo.entity.Course;
import dev.abykov.pets.querydsl.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> findCoursesByNamePart(String namePart) {
        return courseRepository.findByNamePart(namePart);
    }

    public List<Course> findCoursesByExactName(String name) {
        return courseRepository.findByExactName(name);
    }
}
