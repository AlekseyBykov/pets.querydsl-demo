package dev.abykov.pets.querydsl.demo.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import dev.abykov.pets.querydsl.demo.entity.Course;
import dev.abykov.pets.querydsl.demo.entity.QCourse;
import dev.abykov.pets.querydsl.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findCoursesByName(String namePart) {
        QCourse course = QCourse.course;

        BooleanExpression predicate = course.name.containsIgnoreCase(namePart);

        return StreamSupport.stream(
                        courseRepository.findAll(predicate).spliterator(), false
                )
                .toList();
    }
}
