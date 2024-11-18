package com.api_proyect.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable //Se usa para embeder una clase dentro de otra clase
public class ComprasProductoPK implements Serializable {

    //Atributos

    @Column(name = " id_compra")
    private Integer idCompra;

    @Column(name = " id_producto")
    private Integer idProducto;

    // Getters and Setters


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
