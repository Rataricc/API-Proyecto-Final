package com.informatorio.emprendimientos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre de puede ser vacio")
    @NotBlank
    @Column(unique = true)
    private String nombre;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    @JsonIgnore
    @ManyToMany(mappedBy = "tags")
    private List<Emprendimiento> emprendimientos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public List<Emprendimiento> getEmprendimientos() {
        return emprendimientos;
    }

    public void setEmprendimientos(List<Emprendimiento> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", emprendimientos=" + emprendimientos +
                '}';
    }
}
