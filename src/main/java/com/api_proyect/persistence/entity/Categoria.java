package com.api_proyect.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity //Hacer que la clase se comporte como una entidad para llenar la tabla en la base de datos
@Table(name = "categorias") //Conectar la clase a una tabla con nombre diferente en la base de datos
public class Categoria {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generar automaticamente el valor unico para la clave
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;

    // Relación entre las entidades (tablas) de la base de datos

    @OneToMany(mappedBy = "categoria") //relación contraria a la de productos -
    // una categoria puede tener muchos productos
    // mappedBy - mapea la entidad que estará relacionada con este listado
    private List<Producto> productos; //listado de productos

    // Getters and Setters


    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
