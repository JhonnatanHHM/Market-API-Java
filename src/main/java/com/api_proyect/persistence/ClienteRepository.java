package com.api_proyect.persistence;

import com.api_proyect.domain.Client;
import com.api_proyect.domain.repository.ClientRepository;
import com.api_proyect.persistence.crud.ClienteCrudRepository;
import com.api_proyect.persistence.entity.Cliente;
import com.api_proyect.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository // indicarle a spring que esta clase se encarga de trabajar directamente con la base de datos
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClientMapper mapper;

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;


    @Override
    public List<Client> getAll() {
        return mapper.toClients((List<Cliente>) clienteCrudRepository.findAll());
    }

    @Override
    public Optional<Client> getClient(int id) {
        return clienteCrudRepository.findById(id).map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(int id){
        clienteCrudRepository.deleteById(id);
    }

}
