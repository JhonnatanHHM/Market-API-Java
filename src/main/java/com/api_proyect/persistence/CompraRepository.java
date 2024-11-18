package com.api_proyect.persistence;

import com.api_proyect.domain.Purchase;
import com.api_proyect.domain.repository.PurchaseRepository;
import com.api_proyect.persistence.crud.CompraCrudRepository;
import com.api_proyect.persistence.entity.Compra;
import com.api_proyect.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // indicarle a spring que esta clase se encarga de trabajar directamente con la base de datos
public class CompraRepository implements PurchaseRepository {

    @Autowired //Inyeccion de dependencia
    private PurchaseMapper mapper;

    @Autowired //Inyeccion de dependencia
    private CompraCrudRepository compraCrudRepository;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }


    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        // hacer que la información se guarde en cascada
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        //compra conoce sus productos y diciendo a producto a que compra pertenece
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
