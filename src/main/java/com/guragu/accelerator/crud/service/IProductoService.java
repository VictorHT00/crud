package com.guragu.accelerator.crud.service;

import com.guragu.accelerator.crud.model.entities.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    void delete(Long id);
}
