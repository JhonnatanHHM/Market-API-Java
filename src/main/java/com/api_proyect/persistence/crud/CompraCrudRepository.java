package com.api_proyect.persistence.crud;

import com.api_proyect.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra,Integer> {

    //Metodo query para recuperar una compra por el id del cliente
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
