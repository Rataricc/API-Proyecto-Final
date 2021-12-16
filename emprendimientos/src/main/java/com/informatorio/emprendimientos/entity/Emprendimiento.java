package com.informatorio.emprendimientos.entity;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    private String contenido;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    private BigDecimal objetivoRecaudacion;
    private boolean publicado;

    //Agregue la conexion entre las tablas
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario owner;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "emprendimiento_id", joinColumns = @JoinColumn(name = "emprendimiento_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public BigDecimal getObjetivoRecaudacion() {
        return objetivoRecaudacion;
    }

    public void setObjetivoRecaudacion(BigDecimal objetivoRecaudacion) {
        this.objetivoRecaudacion = objetivoRecaudacion;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    //Agregue los metodos setter and getter de usuario owner (dueño)
    public Usuario getOwner() {
        return owner;
    }

    public void setOwner(Usuario owner) {
        this.owner = owner;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void agregarTag(Tag tag){
        tags.add(tag);
        tag.getEmprendimientos().add(this);
    }

    public void removerTag(Tag tag){
        tags.remove(tag);
        tag.getEmprendimientos().remove(null);
    }

    @Override
    public String toString() {
        return "Emprendimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", objetivoRecaudacion=" + objetivoRecaudacion +
                ", publicado=" + publicado +
                ", owner=" + owner +
                ", tags=" + tags +
                '}';
    }
}
