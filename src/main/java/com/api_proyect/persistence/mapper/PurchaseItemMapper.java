package com.api_proyect.persistence.mapper;

import com.api_proyect.domain.Purchase;
import com.api_proyect.domain.PurchaseItem;
import com.api_proyect.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "Spring", uses = {ProductMapper.class})
//Indicar al proyecto que la clase es un mapeador componente de tipo spring
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            // @Mapping(source = "total", target = "total"),
            // este no es necesario colocarlo porque el source y el target se llaman exactamente igual
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration //indica a Mapstruct que la configuración sera inversa a la anterior
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    //vamos a ignorar los atributos que estan en ComprasProducto pero no esta en PurchaseItems
    ComprasProducto toComprasProducto(PurchaseItem item);
}
