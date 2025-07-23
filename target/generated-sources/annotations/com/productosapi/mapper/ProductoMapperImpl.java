package com.productosapi.mapper;

import com.productosapi.dto.ProductoDTO;
import com.productosapi.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-23T13:27:58-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250628-1110, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDTO toDTO(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId( producto.getId() );
        productoDTO.setNombre( producto.getNombre() );
        productoDTO.setPrecio( producto.getPrecio() );
        productoDTO.setStock( producto.getStock() );

        return productoDTO;
    }

    @Override
    public Producto toEntity(ProductoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId( dto.getId() );
        producto.setNombre( dto.getNombre() );
        producto.setPrecio( dto.getPrecio() );
        producto.setStock( dto.getStock() );

        return producto;
    }

    @Override
    public List<ProductoDTO> toDTOList(List<Producto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( productos.size() );
        for ( Producto producto : productos ) {
            list.add( toDTO( producto ) );
        }

        return list;
    }

    @Override
    public List<Producto> toEntityList(List<ProductoDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Producto> list = new ArrayList<Producto>( dtos.size() );
        for ( ProductoDTO productoDTO : dtos ) {
            list.add( toEntity( productoDTO ) );
        }

        return list;
    }
}
