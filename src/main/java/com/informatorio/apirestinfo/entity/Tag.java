package com.informatorio.apirestinfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "tags")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Emprendimiento> emprendimientos = new ArrayList<Emprendimiento>();

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
                ", emprendimientos=" + emprendimientos +
                '}';
    }
}
