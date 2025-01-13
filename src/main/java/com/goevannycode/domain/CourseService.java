package com.goevannycode.domain;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Flux<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Mono<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    public Mono<Course> createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Mono<Course> updateCourse(String id, Course course) {
        return courseRepository.findById(id)
                .flatMap(existingCourse -> {
                    existingCourse.setName(course.getName());
                    existingCourse.setCategory(course.getCategory());
                    existingCourse.setRating(course.getRating());
                    existingCourse.setDescription(course.getDescription());
                    return courseRepository.save(existingCourse);
                });
    }

    public Mono<Void> deleteCourse(String id) {
        return courseRepository.deleteById(id);
    }
}



