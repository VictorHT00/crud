package com.guragu.accelerator.crud.controller;

import com.guragu.accelerator.crud.dto.CompraDTO;
import com.guragu.accelerator.crud.model.dao.IProductoDao;
import com.guragu.accelerator.crud.model.dao.IUsuarioDao;
import com.guragu.accelerator.crud.model.entities.Compra;
import com.guragu.accelerator.crud.model.entities.Producto;
import com.guragu.accelerator.crud.model.entities.Usuario;
import com.guragu.accelerator.crud.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost", "*"})
@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private ICompraService compraService;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    IProductoDao productoDao;


    @GetMapping()
    public List<Compra> listar() {
        return compraService.findAll();
    }

    @GetMapping("/{id}")
    public Compra buscar(@PathVariable Long id) {
        return compraService.findById(id);
    }

    private Compra getCompra(@RequestBody CompraDTO compra, Compra compraActual) {
        Usuario usuarioAux = usuarioDao.findById(compra.getUsuario()).orElse(null);
        Producto productoAux = productoDao.findById(compra.getProducto()).orElse(null);

        compraActual.setUsuario(usuarioAux);
        compraActual.setProducto(productoAux);
        compraActual.setCantidad(compra.getCantidad());
        compraActual.setFecha(compra.getFecha());

        return compraService.save(compraActual);
    }

    @PostMapping()
    public Compra crear(@RequestBody CompraDTO compra) {
        Compra compraActual = new Compra();

        return getCompra(compra, compraActual);
    }

    @PutMapping("/{id}")
    public Compra editar(@PathVariable Long id, @RequestBody CompraDTO compra) {
        Compra compraActual = compraService.findById(id);

        return getCompra(compra, compraActual);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        compraService.delete(id);
    }
}
