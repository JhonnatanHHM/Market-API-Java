package com.api_proyect.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity //Hacer que la clase se comporte como una entidad para llenar la tabla en la base de datos
@Table(name = "clientes") //Conectar la clase a una tabla con nombre diferente en la base de datos
public class Cliente {

    //Atributos

    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private Long celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    // Relación entre las entidades (tablas) de la base de datos

    @OneToMany(mappedBy = "cliente") //relación contraria a la de compra -
    // un cliente puede hacer muchas compras
    // mappedBy - mapea la entidad que estará relacionada con este listado
    private List<Compra> compras; //listado de compras

    // Getters and Setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
