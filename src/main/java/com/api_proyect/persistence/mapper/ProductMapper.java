package com.api_proyect.persistence.mapper;


import com.api_proyect.domain.Product;
import com.api_proyect.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
//Indicar al proyecto que la clase es un mapeador componente de tipo spring
/*Como category es una CategoryMapper, le indicamos que use CategoryMapper, cuando vaya a convertir
una categoria en category*/
public interface ProductMapper {

    //Metodo para mapear y convertir una categoria en Category
    @Mappings({ //sirve para estipular que se van a realizar multiples mapeos
            @Mapping(source = "idProducto", target = "productId"), //sirve para mapear cada atributo de las clases
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);
    //listado de productos a lista de products
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration //indica a Mapstruct que la configuración sera inversa a la anterior
    @Mapping(target = "codigoBarras", ignore = true) /*vamos a ignorar el atributo que esta en categoria pero
    no esta en Category*/
    Producto toProducto(Product Product);
}
