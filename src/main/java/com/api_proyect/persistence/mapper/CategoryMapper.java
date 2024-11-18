package com.api_proyect.persistence.mapper;

import com.api_proyect.domain.Category;
import com.api_proyect.domain.Client;
import com.api_proyect.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.api_proyect.persistence.entity.Categoria;

import java.util.List;

@Mapper(componentModel = "spring") //Indicar al proyecto que la clase es un mapeador
//componente de tipo spring
public interface CategoryMapper {

    //Metodo para mapear y convertir una categoria en Category
    @Mappings({ //sirve para estipular que se van a realizar multiples mapeos
            @Mapping(source = "idCategoria", target = "categoryId"), //sirve para mapear cada atributo de las clases
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);
    //listado de Compra a lista de Purchase
    List<Category> toCategorys(List<Categoria> categorias);


    @InheritInverseConfiguration //indica a Mapstruct que la configuración sera inversa a la anterior
    @Mapping(target = "productos", ignore = true) /*vamos a ignorar el atributo que esta en categoria pero
    no esta en Category*/
    Categoria toCategoria(Category category);
}


