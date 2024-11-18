package com.api_proyect.persistence.entity;

import jakarta.persistence.*;

@Entity //Hacer que la clase se comporte como una entidad para llenar la tabla en la base de datos
@Table(name = "compras_productos") //Conectar la clase a una tabla con nombre diferente en la base de datos
public class ComprasProducto {

    //Atributos

    @EmbeddedId //clave primaria compuesta desde la clase que incluye las claves primarias
    private ComprasProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    // Relación entre las entidades (tablas) de la base de datos

    @ManyToOne //Relación muchos a uno - muchas comprasProducto pueden almacenar una compra
    @MapsId("idCompra")
    /* cuando ComprasProducto vaya a guardar en cascada va a saber a que clave primaria pertenece
    cada uno de los productos que esta en una compra*/
    @JoinColumn(name = "id_compra", insertable = false, updatable = false) /*a travéz de esta
    relación no vamos a insertar, ni borrar, ni actualizar una nueva categoria*/
    // recupera toda la información de la compra que esta relacionada con comprasProducto
    private Compra compra;

    @ManyToOne //Relación muchos a uno - muchas comprasProducto pueden utilizar un producto
    @JoinColumn(name = "id_producto", insertable = false, updatable = false) /*a travéz de esta
    relación no vamos a insertar, ni borrar, ni actualizar una nueva categoria*/
    // recupera toda la información del producto que esta relacionado con comprasProducto
    private Producto producto;

    // Getters and Setters


    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
