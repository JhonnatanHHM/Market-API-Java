package com.api_proyect.domain.repository;

import com.api_proyect.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    //Metodo para retornar todos los clientes
    List<Client> getAll();

    //Metodo opcional para recuperar un cliente en particular
    Optional<Client> getClient(int id);

    //Metodo para crear un cliente
    Client save(Client client);

    //Metodo para eliminar un cliente
    void delete(int id);
}
