package com.api_proyect.persistence.mapper;

import com.api_proyect.domain.Client;
import com.api_proyect.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
//Indicar al proyecto que la clase es un mapeador componente de tipo spring
public interface ClientMapper {

    //Metodo para mapear y convertir una cliente en Client
    @Mappings({ //sirve para estipular que se van a realizar multiples mapeos
           //sirve para mapear cada atributo de las clases
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "surnames"),
            @Mapping(source = "celular", target = "phone"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "correoElectronico", target = "email")
    })
    Client toClient(Cliente cliente);
    //listado de Compra a lista de Purchase
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "compras", ignore = true)
    Cliente toCliente(Client client);

}
