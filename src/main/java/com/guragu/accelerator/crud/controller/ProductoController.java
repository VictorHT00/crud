package com.guragu.accelerator.crud.controller;

import com.guragu.accelerator.crud.model.entities.Producto;
import com.guragu.accelerator.crud.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost", "*"})
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<Producto> listar() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping()
    public Producto crear(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public Producto editar(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoActual = productoService.findById(id);
        productoActual.setNombre(producto.getNombre());
        productoActual.setPrecio(producto.getPrecio());

        return productoService.save(productoActual);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.delete(id);
    }
}
