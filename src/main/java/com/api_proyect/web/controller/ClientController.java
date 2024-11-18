package com.api_proyect.web.controller;

import com.api_proyect.domain.Client;
import com.api_proyect.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica a spring que esta clase es un controlador de una API-REST
@RequestMapping("/clients") //dirección path en la que va a aceptar las peticiones
public class ClientController {

    @Autowired //Inyeccion de dependencia desde el servicio
    private ClientService clientService;

    @GetMapping("/all") //metodo para exponer el servicio en GET/READ para todos los clientes
    //Metodo para retornar todos los clientes desde el servicio
    public ResponseEntity<List<Client>> getAll(){
        // ResponseEntity es un objeto que envuelve a List y que permite manejar la respuesta HTTP.
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
        // Significa que la petición respondio de manera adecuada cuando fue llamada
    }

    @GetMapping("/{id}") //metodo para exponer el servicio en GET/READ por producto especifico
    //Metodo opcional para recuperar un cliente en particular desde el servicio
    public ResponseEntity<Client> getClient(@PathVariable("id") int id){
        return clientService.getClient(id).map(client ->
                        new ResponseEntity<>(client,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        /* Respuesta satisfactoria al comparar si existe el id ingresado,
         de lo contrario respuesta directa del protocolo NOT_FOUND */
    }

    @PostMapping("/save") //metodo para exponer el servicio en POST/CREATE para crear un producto
    //Metodo para crear un cliente desde el servicio
    // @RequestBody Anotación referencia al cuerpo de la entidad
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}") //metodo para exponer el servicio en DELETE por ID especificO
    //Metodo para eliminar un cliente desde el servicio
    public ResponseEntity delete(@PathVariable("id") int id) {
        // @PathVariable Anotación referencia a la variable del path
        if(clientService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
