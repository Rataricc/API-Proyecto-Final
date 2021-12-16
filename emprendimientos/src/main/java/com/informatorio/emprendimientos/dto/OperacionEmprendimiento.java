package com.informatorio.emprendimientos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

public class OperacionEmprendimiento { //POJO - Plain Old Java Object

    @NotEmpty(message = "El nombre no puede estar en blanco")
    @NotBlank
    private String nombre;
    @NotEmpty(message = "El descripcion no puede estar en blanco")
    @NotBlank
    private String descripcion;
    private String contenido;
    @Positive
    private BigDecimal objetivoRecaudacion;
    private boolean publicado;
    @NotNull
    @Positive
    @JsonProperty(value = "id_usuario")
    private Long idUsuario;
    private List<Long> tags;

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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public BigDecimal getObjetivoRecaudacion() {
        return objetivoRecaudacion;
    }

    public void setObjetivoRecaudacion(BigDecimal objetivoReacaudacion) {
        this.objetivoRecaudacion = objetivoReacaudacion;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }
}
