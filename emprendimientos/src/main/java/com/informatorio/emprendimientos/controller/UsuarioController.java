package com.informatorio.emprendimientos.controller;

import com.informatorio.emprendimientos.entity.Usuario;
import com.informatorio.emprendimientos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate fechaDesde,
            @RequestParam(required = false) String ciudad){
        if (fechaDesde != null){
            List<Usuario> usuarios = usuarioRepository.findByFechaDeCreacionAfter(fechaDesde.atStartOfDay());
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }else if(ciudad != null){
            List<Usuario> usuarios = usuarioRepository.findByCiudad(ciudad);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void eliminarPorId(@PathVariable("id") Long id){
        usuarioRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Usuario modificarUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario){
        Usuario usuario1 = usuarioRepository.findById(id).get();
        usuario1.setNombre(usuario.getNombre());
        usuario1.setApellido(usuario.getApellido());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setContrasena(usuario.getContrasena());
        usuario1.setCiudad(usuario.getCiudad());
        usuario1.setPais(usuario.getPais());
        usuario1.setProvincia(usuario.getProvincia());
        return usuarioRepository.save(usuario1);
    }
}
