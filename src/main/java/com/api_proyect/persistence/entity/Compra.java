package com.api_proyect.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity //Hacer que la clase se comporte como una entidad para llenar la tabla en la base de datos
@Table(name = "compras") //Conectar la clase a una tabla con nombre diferente en la base de datos
public class Compra {

    //Atributos

    @Id //Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generar automaticamente el valor unico para la clave
    @Column(name = "id_compra") //Conectar un atributo que se llama diferente en la base de datos
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    // Relación entre las entidades (tablas) de la base de datos

    @ManyToOne //Relación muchos a uno - muchos clientes pueden realizar una compra
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false) /*a travéz de esta
    relación no vamos a insertar, ni borrar, ni actualizar una nueva categoria*/
    // recupera toda la información del cliente que esta realizando la compra
    private Cliente cliente;

    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    /*relación contraria a la de comprasProducto -
    un compra puede estar en muchas comprasProducto */
    // cascade para que todos los productos se guarden en cascada
    // todos los proceso que se hagan contra la base de datos de una compra van a influir en cascada sus productos
    private List<ComprasProducto> productos; //recupera todos los productos de una compra

    // Getters and Setters

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ComprasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.productos = productos;
    }

}
