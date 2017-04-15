package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by trainer8 on 4/9/17.
 */
@RestController
@RequestMapping("/lessons")
public class LessonsController {
    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Lesson getById(@PathVariable long id) {
        return this.repository.findOne(id);
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }


    @PatchMapping("/{id}")
    public Lesson patchById(@PathVariable long id, @RequestBody Lesson lesson){
        if (this.repository.findOne(id)!=null){
            return this.repository.save(lesson);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable long id){
        this.repository.delete(id);
        return new ResponseEntity("", HttpStatus.OK);
    }
}
