package com.informatorio.emprendimientos.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @NotNull
    @Enumerated(EnumType.STRING)
    private GeneradoPor generadoPor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public GeneradoPor getGeneradoPor() {
        return generadoPor;
    }

    public void setGeneradoPor(GeneradoPor generadoPor) {
        this.generadoPor = generadoPor;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", generadoPor=" + generadoPor +
                '}';
    }
}
