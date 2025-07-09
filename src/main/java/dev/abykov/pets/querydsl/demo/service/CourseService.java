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

    public List<Course> findByNameAndDescription(String name, String description) {
        return courseRepository.findByNameAndDescription(name, description);
    }

    public List<Course> findByNameOrDescriptionContaining(String keyword) {
        return courseRepository.findByNameOrDescriptionContaining(keyword);
    }

    public List<Course> searchCourses(String name, String description) {
        return courseRepository.searchCourses(name, description);
    }

    public List<Course> findAllOrderByNameAsc() {
        return courseRepository.findAllOrderByNameAsc();
    }

    public List<Course> findPaged(int page, int size) {
        return courseRepository.findPaged(page, size);
    }

    public long countAll() {
        return courseRepository.countAll();
    }
}
