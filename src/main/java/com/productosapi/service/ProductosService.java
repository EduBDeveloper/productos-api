package com.productosapi.service;

import com.productosapi.entity.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductosService {
    List<Producto> listar();
    Optional<Producto> obtenerPorId(Long id);
    Producto crear(Producto producto);
    Producto actualizar(Long id, Producto producto);
    void eliminar(Long id);
}
