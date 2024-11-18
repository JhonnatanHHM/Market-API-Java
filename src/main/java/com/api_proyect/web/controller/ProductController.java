package com.api_proyect.web.controller;

import com.api_proyect.domain.Product;
import com.api_proyect.domain.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //indica a spring que esta clase es un controlador de una API-REST
@RequestMapping("/products") //dirección path en la que va a aceptar las peticiones
public class ProductController {

    @Autowired //Inyeccion de dependencia desde el servicio
    private ProductService productService;

    // Codigo sin ResponseEntity
    /*
    @GetMapping("/all") //metodo para exponer el servicio en GET/READ para todos los productos
    //Metodo para retornar todos los productos desde el servicio
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}") //metodo para exponer el servicio en GET/READ por producto especifico
    //Metodo opcional para recuperar un producto en particular desde el servicio
    public Optional<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    };

     @GetMapping("/category/{categoryId}") //metodo para exponer el servicio en GET/READ por categoria especifica
    //Metodo opcional para retornar productos por categoria desde el servicio
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    };
    */

    // Mejora de codigo a travez de ResponseEntity


    @GetMapping("/all") //metodo para exponer el servicio en GET/READ para todos los productos
    //Metodo para retornar todos los productos desde el servicio
    public ResponseEntity<List<Product>> getAll(){
        // ResponseEntity es un objeto que envuelve a List y que permite manejar la respuesta HTTP.
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
        // Significa que la petición respondio de manera adecuada cuando fue llamada
    }

    @GetMapping("/{productId}") //metodo para exponer el servicio en GET/READ por producto especifico
    //Metodo opcional para recuperar un producto en particular desde el servicio
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId).map(product ->
                new ResponseEntity<>(product,HttpStatus.OK))
                        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        /* Respuesta satisfactoria al comparar si existe el productId ingresado,
         de lo contrario respuesta directa del protocolo NOT_FOUND */
    }

    @GetMapping("/category/{categoryId}") //metodo para exponer el servicio en GET/READ por categoria especifica
    //Metodo opcional para retornar productos por categoria desde el servicio
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId).map(products ->
                        new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    };

    @PostMapping("/save") //metodo para exponer el servicio en POST/CREATE para crear un producto
    //Metodo para crear un producto desde el servicio
    // @RequestBody Anotación referencia al cuerpo de la entidad
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{deleteId}") //metodo para exponer el servicio en DELETE por ID especificO
    //Metodo para eliminar un producto desde el servicio
    public ResponseEntity delete(@PathVariable("deleteId") int productId) {
    // @PathVariable Anotación referencia a la variable del path
                if(productService.delete(productId)){
                    return new ResponseEntity<>(HttpStatus.OK);
        } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
    }
}
