package com.api_proyect.domain.service;

import com.api_proyect.domain.Category;
import com.api_proyect.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // indicarle a spring que esta clase se encarga de manejar los servicios
public class CategoryService {

    @Autowired //Inyeccion de dependencia
    private CategoryRepository categoryRepository;

    //Metodo para retornar todos los categorias desde la interfaz
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    //Metodo opcional para recuperar un cliente en particular desde la interfaz
    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    };

    //Metodo para crear un producto desde la interfaz
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    //Metodo para eliminar un producto desde la interfaz
    public boolean delete(int categoryId) {

        return getCategory(categoryId).map(product -> {
            categoryRepository.delete(categoryId);
            return true;
        }).orElse( false);
    }
}
