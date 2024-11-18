package com.api_proyect.web.controller;

import com.api_proyect.domain.Category;
import com.api_proyect.domain.Client;
import com.api_proyect.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica a spring que esta clase es un controlador de una API-REST
@RequestMapping("/category") //dirección path en la que va a aceptar las peticiones
public class CategoryController {

    @Autowired //Inyeccion de dependencia desde el servicio
    private CategoryService categoryService;

    @GetMapping("/all") //metodo para exponer el servicio en GET/READ para todos las categorias
    //Metodo para retornar todos las categorias desde el servicio
    public ResponseEntity<List<Category>> getAll(){
        // ResponseEntity es un objeto que envuelve a List y que permite manejar la respuesta HTTP.
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
        // Significa que la petición respondio de manera adecuada cuando fue llamada
    }

    @GetMapping("/{categoryId}") //metodo para exponer el servicio en GET/READ por categoria especifica
    //Metodo opcional para recuperar una categoria en particular desde el servicio
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") int categoryId){
        return categoryService.getCategory(categoryId).map(client ->
                        new ResponseEntity<>(client,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        /* Respuesta satisfactoria al comparar si existe el categoryId ingresado,
         de lo contrario respuesta directa del protocolo NOT_FOUND */
    }

    @PostMapping("/save") //metodo para exponer el servicio en POST/CREATE para crear una categoria
    //Metodo para crear una categoria desde el servicio
    // @RequestBody Anotación referencia al cuerpo de la entidad
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{categoryId}") //metodo para exponer el servicio en DELETE por ID especificO
    //Metodo para eliminar una categoria desde el servicio
    public ResponseEntity delete(@PathVariable("categoryId") int categoryId) {
        // @PathVariable Anotación referencia a la variable del path
        if(categoryService.delete(categoryId)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
