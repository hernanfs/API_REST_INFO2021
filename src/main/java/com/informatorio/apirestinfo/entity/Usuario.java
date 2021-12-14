package com.informatorio.apirestinfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Where(clause = "activo = true")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer"})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;
    @NotEmpty(message = "El email no puede estar vacio")
    @Column(unique = true)
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;
    @NotEmpty(message = "Debe ingresar un password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Boolean activo =true;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @NotEmpty(message = "Debe ingresar una ciudad")
    private String ciudad;
    @NotEmpty(message = "Debe ingresar una provincia")
    private String provincia;
    @NotEmpty(message = "Debe ingresar un Pais")
    private String Pais;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;
    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Emprendimiento> getEmprendimientos() {
        return emprendimientos;
    }

    public void setEmprendimientos(List<Emprendimiento> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }
    public void addEmprendimiento(Emprendimiento emprendimiento) {
        emprendimientos.add(emprendimiento);
        emprendimiento.setCreador(this);
    }
    public void removeEmprendimiento(Emprendimiento emprendimiento) {
        emprendimientos.remove(emprendimiento);
        emprendimiento.setCreador(null);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activo=" + activo +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", Pais='" + Pais + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
