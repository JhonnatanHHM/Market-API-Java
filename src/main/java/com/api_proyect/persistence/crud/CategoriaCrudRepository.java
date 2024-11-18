package com.api_proyect.persistence.crud;

import com.api_proyect.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaCrudRepository extends CrudRepository<Categoria,Integer> {
}
