package com.api_proyect.persistence;

import com.api_proyect.domain.Product;
import com.api_proyect.domain.repository.ProductRepository;
import com.api_proyect.persistence.crud.ProductoCrudRepository;
import com.api_proyect.persistence.entity.Producto;
import com.api_proyect.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // indicarle a spring que esta clase se encarga de trabajar directamente con la base de datos
public class ProductoRepository implements ProductRepository {

    @Autowired //Inyeccion de dependencia
    private ProductMapper mapper;

    @Autowired //Inyeccion de dependencia
    private ProductoCrudRepository productoCrudRepository;

    //Metodo que recuperar todos los productos que tenemos en la base de datos
    @Override //permite sobre escribir el comportamiento, funcionalidad del método
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    //Metodo para recuperar toda la lista de productos que pertenecen a una categoria en especifico
    //Ordenado por nombre de forma ascendente
    @Override //permite sobre escribir el comportamiento, funcionalidad del método
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        /*como se espera un optional y lo que obtendremos es una lista agregamos .of() a Optional y enviamos
        la lista por medio del mapper*/
        return Optional.of(mapper.toProducts(productos));
    }

    //Metodo opcional para recuperar todos los productos que esten por debajo de la cantidad indicada
    @Override //permite sobre escribir el comportamiento, funcionalidad del método
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        //funcion labmda para que el .map retorne un opcional de lo que se esta haciendo dentro de la expresion
        //arrow function - recibe los productos que tiene adentro y los convierte a products y los retorna
        return productos.map(prods -> mapper.toProducts(prods));
    }

    //Metodo opcional para recuperar un producto en particular
    @Override //permite sobre escribir el comportamiento, funcionalidad del método
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    //Metodo para crear un producto
    @Override //permite sobre escribir el comportamiento, funcionalidad del método
    public Product save(Product product) {
        //Ya que .save espera es un producto, hacemos la conversión de product a producto
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    //Metodo para eliminar un producto
    @Override //permite sobre escribir el comportamiento, funcionalidad del método
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
