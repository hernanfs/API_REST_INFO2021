package com.informatorio.apirestinfo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Generado generado;
    private Long emprendimientoId;
    private Long usuarioId;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    public Long getId() {
        return id;
    }

    public Generado getGenerado() {
        return generado;
    }

    public void setGenerado(Generado generado) {
        this.generado = generado;
    }

    public Long getEmprendimientoId() {
        return emprendimientoId;
    }

    public void setEmprendimientoId(Long emprendimientoId) {
        this.emprendimientoId = emprendimientoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", generado=" + generado +
                ", emprendimientoId=" + emprendimientoId +
                ", usuarioId=" + usuarioId +
                ", fechaDeCreacion=" + fechaDeCreacion +
                '}';
    }
}
