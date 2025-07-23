package com.productosapi.service.impl;

import com.productosapi.entity.Producto;
import com.productosapi.exception.RecursoNoEncontradoException;
import com.productosapi.repository.ProductoRepository;
import com.productosapi.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto actualizar(Long id, Producto producto) {
        Producto existente = repository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con ID: " + id));
        existente.setNombre(producto.getNombre());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNoEncontradoException("Producto no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }
}
