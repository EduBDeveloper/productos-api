package com.productosapi.mapper;

import com.productosapi.dto.ProductoDTO;
import com.productosapi.entity.Producto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDTO toDTO(Producto producto);

    Producto toEntity(ProductoDTO dto);

    List<ProductoDTO> toDTOList(List<Producto> productos);

    List<Producto> toEntityList(List<ProductoDTO> dtos);
}
