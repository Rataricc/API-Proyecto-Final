package com.informatorio.emprendimientos.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar en blanco")
    @NotBlank
    private String nombreEvento;
    @NotEmpty(message = "La descripcion no puede estar en blanco")
    @NotBlank
    private String descripcion;
    @NotEmpty(message = "La info de los auspiciantes no puede estar en blanco")
    @NotBlank
    private String infoDeAuspiciantes;
    private BigDecimal premio;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInfoDeAuspiciantes() {
        return infoDeAuspiciantes;
    }

    public void setInfoDeAuspiciantes(String infoDeAuspiciantes) {
        this.infoDeAuspiciantes = infoDeAuspiciantes;
    }

    public BigDecimal getPremio() {
        return premio;
    }

    public void setPremio(BigDecimal premio) {
        this.premio = premio;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", infoDeAuspiciantes='" + infoDeAuspiciantes + '\'' +
                ", premio=" + premio +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", estado=" + estado +
                '}';
    }
}
