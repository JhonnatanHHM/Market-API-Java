package com.api_proyect.persistence.entity;

import jakarta.persistence.*;

@Entity //Hacer que la clase se comporte como una entidad para llenar la tabla en la base de datos
@Table(name = "productos") //Conectar la clase a una tabla con nombre diferente en la base de datos
public class Producto {

    //Atributos

    @Id //Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generar automaticamente el valor unico para la clave
    @Column(name = "id_producto") //Conectar un atributo que se llama diferente en la base de datos
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    // Relación entre las entidades (tablas) de la base de datos

    @ManyToOne //Relación muchos a uno - muchos producto pueden estar en una categoria
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) /*a travéz de esta
    relación no vamos a insertar, ni borrar, ni actualizar una nueva categoria*/
    // esto solo servira para identificar a que categoria pertenece un producto
    private Categoria categoria;

    // Getters and Setters

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
