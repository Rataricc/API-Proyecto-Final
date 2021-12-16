package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.dto.OperacionEmprendimiento;
import com.informatorio.emprendimientos.repository.EmprendimientoRepository;
import com.informatorio.emprendimientos.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/emprendimiento")
public class EmprendimientoController {

    private final EmprendimientoService emprendimientoService;
    private final EmprendimientoRepository emprendimientoRepository;

    @Autowired
    public EmprendimientoController(EmprendimientoService emprendimientoService,
                                    EmprendimientoRepository emprendimientoRepository){
        this.emprendimientoService = emprendimientoService;
        this.emprendimientoRepository = emprendimientoRepository;
    }
    //Tratar de ver como agregar metodo Get para ver todos los emprendimientos.

    @PostMapping
    public ResponseEntity<?> crearEmprendimiento(@Valid @RequestBody OperacionEmprendimiento operacionEmprendimiento){
        return new ResponseEntity<>(emprendimientoService.crearEmprendimiento(operacionEmprendimiento),
                HttpStatus.CREATED);
    }
}
