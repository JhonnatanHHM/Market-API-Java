package com.api_proyect.domain.repository;

import com.api_proyect.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    //Metodo para retornar todas las compras
    List<Purchase> getAll();

    //Metodo opcional para retornar las compras por clientes
    Optional<List<Purchase>> getByClient(String clientId);

    //Metodo para guardar una compra
    Purchase save(Purchase purchase);
}
