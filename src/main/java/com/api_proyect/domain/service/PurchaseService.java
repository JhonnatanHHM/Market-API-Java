package com.api_proyect.domain.service;

import com.api_proyect.domain.Purchase;
import com.api_proyect.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // indicarle a spring que esta clase se encarga de manejar los servicios
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    //Metodo para retornar todos las compras desde la interfaz
    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    //Metodo opcional para retornar las compras por clientes
    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    };


    //Metodo para guardar una compra
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    };

}
