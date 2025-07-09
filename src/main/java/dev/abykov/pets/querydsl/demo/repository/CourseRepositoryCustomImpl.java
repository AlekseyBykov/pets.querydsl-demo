package dev.abykov.pets.querydsl.demo.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
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

    @Override
    public List<Course> findByNameAndDescription(String name, String description) {
        return queryFactory
                .selectFrom(QCourse.course)
                .where(
                        QCourse.course.name.eq(name),
                        QCourse.course.description.eq(description)
                )
                .fetch();
    }

    @Override
    public List<Course> findByNameOrDescriptionContaining(String keyword) {
        return queryFactory
                .selectFrom(QCourse.course)
                .where(
                        QCourse.course.name.containsIgnoreCase(keyword)
                                .or(QCourse.course.description.containsIgnoreCase(keyword))
                )
                .fetch();
    }

    @Override
    public List<Course> searchCourses(String name, String description) {
        BooleanBuilder builder = new BooleanBuilder();

        if (name != null && !name.isEmpty()) {
            builder.and(QCourse.course.name.containsIgnoreCase(name));
        }

        if (description != null && !description.isEmpty()) {
            builder.and(QCourse.course.description.containsIgnoreCase(description));
        }

        return queryFactory
                .selectFrom(QCourse.course)
                .where(builder)
                .fetch();
    }

    @Override
    public List<Course> findAllOrderByNameAsc() {
        return queryFactory
                .selectFrom(QCourse.course)
                .orderBy(QCourse.course.name.asc())
                .fetch();
    }

    @Override
    public List<Course> findPaged(int page, int size) {
        return queryFactory
                .selectFrom(QCourse.course)
                .offset(page * size)
                .limit(size)
                .fetch();
    }

    @Override
    public long countAll() {
        return queryFactory
                .select(QCourse.course.count())
                .from(QCourse.course)
                .fetchOne();
    }

    @Override
    public List<Tuple> countByCategory() {
        return queryFactory
                .select(QCourse.course.name, QCourse.course.count())
                .from(QCourse.course)
                .groupBy(QCourse.course.name)
                .fetch();
    }
}
