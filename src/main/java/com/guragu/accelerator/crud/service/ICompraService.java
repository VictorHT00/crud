package com.guragu.accelerator.crud.service;

import com.guragu.accelerator.crud.model.entities.Compra;

import java.util.List;

public interface ICompraService {
    List<Compra> findAll();
    Compra findById(Long id);
    Compra save(Compra compra);
    void delete(Long id);
}
