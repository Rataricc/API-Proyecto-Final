package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.entity.Tag;
import com.informatorio.emprendimientos.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

    private final TagRepository tagRepository;

    @Autowired
    public TagController(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTag(){
        return new ResponseEntity<>(tagRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crearTag(@Valid @RequestBody Tag tag){
        return new ResponseEntity<>(tagRepository.save(tag), HttpStatus.CREATED);
    }
}
