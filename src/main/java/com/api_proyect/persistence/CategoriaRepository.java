package com.api_proyect.persistence;

import com.api_proyect.domain.Category;
import com.api_proyect.domain.repository.CategoryRepository;
import com.api_proyect.persistence.crud.CategoriaCrudRepository;
import com.api_proyect.persistence.entity.Categoria;
import com.api_proyect.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // indicarle a spring que esta clase se encarga de trabajar directamente con la base de datos
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Override
    public List<Category> getAll() {
        return mapper.toCategorys((List<Categoria>) categoriaCrudRepository.findAll());
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId).map(categoria -> mapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId){
        categoriaCrudRepository.deleteById(categoryId);
    }
}
