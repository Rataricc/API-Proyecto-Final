package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.repository.VotoRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotoController {

    private final VotoRepository votoRepository;

    public VotoController(VotoRepository votoRepository){
        this.votoRepository = votoRepository;
    }

    //Aca tendria que ir el CRUD...
}
