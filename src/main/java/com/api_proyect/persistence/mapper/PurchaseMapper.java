package com.api_proyect.persistence.mapper;

import com.api_proyect.domain.Purchase;
import com.api_proyect.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
//Indicar al proyecto que la clase es un mapeador componente de tipo spring
/*Indicamos que use la clase PurchaseItemMapper porque vamos a mapear dentro de la compra(Purchase)
todos sus productos */
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")
            //Este mapping ultimo es el que usa PurchaseItemMapper para convertir los productos uno a uno
    })
    Purchase toPurchase(Compra compra);
    //listado de Compra a lista de Purchase
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);

}
