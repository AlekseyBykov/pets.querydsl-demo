package dev.abykov.pets.querydsl.demo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.abykov.pets.querydsl.demo.entity.Course;
import dev.abykov.pets.querydsl.demo.entity.QCourse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryCustomImpl implements CourseRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public CourseRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Course> findByNamePart(String namePart) {
        QCourse course = QCourse.course;
        return queryFactory.selectFrom(course)
                .where(course.name.containsIgnoreCase(namePart))
                .fetch();
    }

    @Override
    public List<Course> findByExactName(String name) {
        QCourse course = QCourse.course;
        return queryFactory.selectFrom(course)
                .where(course.name.eq(name))
                .fetch();
    }
}
