package com.informatorio.apirestinfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Where(clause = "active = true")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String detalles;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaDeCreacion;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCierre;
    @Column(name = "estado", nullable=false, columnDefinition = "varchar(32) default 'ABIERTO'")
    @Enumerated(value = EnumType.STRING)
    private Estado estado = Estado.ABIERTO;
    @ManyToMany(mappedBy = "eventos")
    @JsonIgnoreProperties({"descripcion", "contenido", "fechaDeCreacion", "objetivo", "publicado", "tags", })
    @OrderBy("contadorDeVotos DESC")
    private List<Emprendimiento> emprendimientos;
    private BigDecimal premio;
    private Boolean activo = true;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Emprendimiento> getEmprendimientos() {
        return emprendimientos;
    }

    public void setEmprendimientos(List<Emprendimiento> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    public BigDecimal getPremio() {
        return premio;
    }

    public void setPremio(BigDecimal premio) {
        this.premio = premio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", detalles='" + detalles + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", fechaCierre=" + fechaCierre +
                ", estado=" + estado +
                ", emprendimientos=" + emprendimientos +
                ", premio=" + premio +
                ", activo=" + activo +
                '}';
    }
}

