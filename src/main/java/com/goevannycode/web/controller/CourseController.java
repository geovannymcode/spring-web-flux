package com.goevannycode.web.controller;

import com.goevannycode.domain.Course;
import com.goevannycode.domain.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/courses/")
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public Flux<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Course>> getCourseById(@PathVariable String id) {
        return courseRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("category/{name}")
    public Flux<Course> getCourseByCategory(@PathVariable String name) {
        return courseRepository.findAllByCategory(name)
                .doOnError(e -> log.error("Failed to retrieve courses by category", e));
    }

    @PostMapping
    public Mono<ResponseEntity<Course>> createCourse(@RequestBody Course course) {
        return courseRepository.save(course)
                .map(savedCourse -> {
                    log.info("Successfully created course: {}", savedCourse);
                    return ResponseEntity
                            .created(URI.create("/courses/" + savedCourse.getId()))
                            .body(savedCourse);
                })
                .doOnError(e -> log.error("Failed to create course", e));
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<Course>> updateCourse(@PathVariable String id, @RequestBody Course course) {
        return courseRepository.findById(id)
                .flatMap(existingCourse -> {
                    existingCourse.setName(course.getName());
                    existingCourse.setRating(course.getRating());
                    existingCourse.setCategory(course.getCategory());
                    existingCourse.setDescription(course.getDescription());
                    return courseRepository.save(existingCourse);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .doOnError(e -> log.error("Failed to update course", e));
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Course>> deleteCourseById(@PathVariable String id) {
        return courseRepository.findById(id)
                .flatMap(course -> courseRepository.deleteById(course.getId())
                        .then(Mono.just(ResponseEntity.ok(course))))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<Void> deleteCourses() {
        return courseRepository.deleteAll();
    }
}
