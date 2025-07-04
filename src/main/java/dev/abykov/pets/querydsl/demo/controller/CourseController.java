package dev.abykov.pets.querydsl.demo.controller;

import dev.abykov.pets.querydsl.demo.entity.Course;
import dev.abykov.pets.querydsl.demo.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/search")
    public List<String> searchCourses(@RequestParam String q) {
        return courseService.findCoursesByNamePart(q).stream()
                .map(Course::getName)
                .toList();
    }
}
