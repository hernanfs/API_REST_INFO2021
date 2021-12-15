package com.informatorio.apirestinfo.dto;

import com.informatorio.apirestinfo.entity.Generado;

import java.time.LocalDateTime;

public class VotoDTO {
    private Generado generado;
    private Long usuarioId;
    private Long empredimientoId;
    private LocalDateTime fechaDeCreacion;
    private Boolean votado;

    public Generado getGenerado() {
        return generado;
    }

    public void setGenerado(Generado generado) {
        this.generado = generado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEmpredimientoId() {
        return empredimientoId;
    }

    public void setEmpredimientoId(Long empredimientoId) {
        this.empredimientoId = empredimientoId;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Boolean isVotado() {
        return votado;
    }

    public void setVotado(Boolean votado) {
        this.votado = votado;
    }

}
