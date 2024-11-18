package com.api_proyect.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.api_proyect.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    //Metodo query para recuperar toda la lista de productos que pertenecen a una categoria en especifico
    //Ordenado por nombre de forma ascendente
    //@Query(value = "SELECT * FORM productos WHERE id_categoria = ?", nativeQuery = true)
    //forma nativa para expresar la función que realiza el QueryMethod en SQL
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Metodo query opcional para recuperar todos los productos que esten por debajo de la cantidad indicada
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
