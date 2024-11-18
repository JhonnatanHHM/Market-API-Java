package com.api_proyect.domain.service;

import com.api_proyect.domain.Client;
import com.api_proyect.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // indicarle a spring que esta clase se encarga de manejar los servicios
public class ClientService {

    @Autowired //Inyeccion de dependencia
    private ClientRepository clientRepository;

    //Metodo para retornar todos los clientes desde la interfaz
    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    //Metodo opcional para recuperar un cliente en particular desde la interfaz
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    };

    //Metodo para crear un producto desde la interfaz
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    //Metodo para eliminar un producto desde la interfaz
    public boolean delete(int id) {

        return getClient(id).map(product -> {
            clientRepository.delete(id);
            return true;
        }).orElse( false);
        }

}
