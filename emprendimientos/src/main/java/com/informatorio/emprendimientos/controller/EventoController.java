package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.entity.Evento;
import com.informatorio.emprendimientos.repository.EventoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

    private final EventoRepository eventoRepository;

    public EventoController(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosEventos(){
        return new ResponseEntity<>(eventoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crearEvento(@Valid @RequestBody Evento evento){
        return new ResponseEntity<>(eventoRepository.save(evento), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminarEventoId(@PathVariable("id") Long id){
        eventoRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Evento modificarEvento(@PathVariable("id") Long id, @Valid @RequestBody Evento evento){
        Evento evento1 = eventoRepository.findById(id).get();
        evento1.setNombreEvento(evento.getNombreEvento());
        evento1.setDescripcion(evento.getDescripcion());
        evento1.setInfoDeAuspiciantes(evento.getInfoDeAuspiciantes());
        evento1.setPremio(evento.getPremio());
        evento1.setEstado(evento.getEstado());
        return eventoRepository.save(evento1);
    }
}
