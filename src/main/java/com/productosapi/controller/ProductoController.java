package com.productosapi.controller;

import com.productosapi.dto.ProductoDTO;
import com.productosapi.entity.Producto;
import com.productosapi.exception.RecursoNoEncontradoException;
import com.productosapi.service.ProductosService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductosService productoService;

    @Autowired
    private ModelMapper modelMapper;

    // GET: Listar todos los productos
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listar() {
        List<Producto> productos = productoService.listar();
        List<ProductoDTO> productosDTO = productos.stream()
                .map(p -> modelMapper.map(p, ProductoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productosDTO);
    }

    // GET: Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.obtenerPorId(id);
        if (productoOpt.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("mensaje", "Producto no encontrado con ID: " + id));
        }
        ProductoDTO dto = modelMapper.map(productoOpt.get(), ProductoDTO.class);
        return ResponseEntity.ok(dto);
    }

    // POST: Crear nuevo producto
    @PostMapping
    public ResponseEntity<Map<String, Object>> crear(@Valid @RequestBody ProductoDTO productoDTO) {
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        Producto creado = productoService.crear(producto);
        ProductoDTO creadoDTO = modelMapper.map(creado, ProductoDTO.class);
        URI ubicacion = URI.create(String.format("/api/productos/%s", creado.getId()));
        return ResponseEntity.created(ubicacion).body(Map.of(
                "mensaje", "Producto creado correctamente",
                "producto", creadoDTO
        ));
    }

    // PUT: Actualizar producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@PathVariable Long id, @Valid @RequestBody ProductoDTO productoDTO) {
        productoService.obtenerPorId(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con ID: " + id));

        Producto productoActualizado = modelMapper.map(productoDTO, Producto.class);
        Producto actualizado = productoService.actualizar(id, productoActualizado);
        ProductoDTO actualizadoDTO = modelMapper.map(actualizado, ProductoDTO.class);
        return ResponseEntity.ok(Map.of(
                "mensaje", "Producto actualizado correctamente",
                "producto", actualizadoDTO
        ));
    }

    // DELETE: Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.ok(Map.of("mensaje", "Producto eliminado correctamente"));
    }
}
