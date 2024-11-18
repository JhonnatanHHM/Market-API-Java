package com.api_proyect.web.controller;


import com.api_proyect.domain.Purchase;
import com.api_proyect.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica a spring que esta clase es un controlador de una API-REST
@RequestMapping("/purchases") //dirección path en la que va a aceptar las peticiones
public class PurchaseController {

    @Autowired //Inyeccion de dependencia desde el servicio
    private PurchaseService purchaseService;

    @GetMapping("/all") //metodo para exponer el servicio en GET/READ para todos las compras
    //Metodo para retornar todos las compras desde el servicio
    public ResponseEntity<List<Purchase>> getAll() {
        // ResponseEntity es un objeto que envuelve a List y que permite manejar la respuesta HTTP.
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
        // Significa que la petición respondio de manera adecuada cuando fue llamada
    }

    @GetMapping("/client/{idClient}") //metodo para exponer el servicio en GET/READ por una compra especifica
    //Metodo opcional para recuperar una compra en particular desde el servicio por medio del id del cliente
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId){
        return purchaseService.getByClient(clientId).map(purchases ->
                        new ResponseEntity<>(purchases,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    };

        /* Respuesta satisfactoria al comparar si existe el purchaseId ingresado,
         de lo contrario respuesta directa del protocolo NOT_FOUND */

    @PostMapping("/save") //metodo para exponer el servicio en POST/CREATE para crear una compra
    //Metodo para crear una compra desde el servicio
    // @RequestBody Anotación referencia al cuerpo de la entidad
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
    }

}
