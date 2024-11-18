package com.api_proyect.domain.repository;

import com.api_proyect.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    //Metodo para retornar todos los productos
    List<Product> getAll();

    //Metodo opcional para retornar productos por categoria
    Optional<List<Product>> getByCategory(int categoryId);

    //Metodo opcional para recuperar todos los productos que esten por debajo de la cantidad indicada
    Optional<List<Product>> getScarseProducts(int quantity);

    //Metodo opcional para recuperar un producto en particular
    Optional<Product> getProduct(int productId);

    //Metodo para crear un producto
    Product save(Product product);

    //Metodo para eliminar un producto
    void delete(int productId);
}
