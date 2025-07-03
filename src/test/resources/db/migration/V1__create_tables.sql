CREATE TABLE student (
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL
);

CREATE TABLE course (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE enrollment (
    id          SERIAL PRIMARY KEY,
    student_id  INTEGER REFERENCES student(id),
    course_id   INTEGER REFERENCES course(id),
    grade       VARCHAR(10)
);
