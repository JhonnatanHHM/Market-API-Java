package com.api_proyect.domain.repository;

import com.api_proyect.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    //Metodo para retornar todos los categorias
    List<Category> getAll();

    //Metodo opcional para recuperar un cliente en particular
    Optional<Category> getCategory(int categoryId);

    //Metodo para crear un cliente
    Category save(Category category);

    //Metodo para eliminar un cliente
    void delete(int categoryId);
}
