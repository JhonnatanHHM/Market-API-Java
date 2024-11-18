package com.api_proyect.domain.service;

import com.api_proyect.domain.Product;
import com.api_proyect.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // indicarle a spring que esta clase se encarga de manejar los servicios
public class ProductService {

    @Autowired //Inyeccion de dependencia
    private ProductRepository productRepository;

    //Metodo para retornar todos los productos desde la interfaz
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    //Metodo opcional para recuperar un producto en particular desde la interfaz
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    };

    //Metodo opcional para retornar productos por categoria desde la interfaz
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    };

    //Metodo para crear un producto desde la interfaz
    public Product save(Product product) {
        return productRepository.save(product);
    };

    //Metodo para eliminar un producto desde la interfaz
    public boolean delete(int productId) {
        //Alternativa, llamando al if
        /*
        if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }
        */
        //Alternativa .map
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse( false);
    }


}
