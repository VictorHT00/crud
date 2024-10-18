package com.guragu.accelerator.crud.model.dao;

import com.guragu.accelerator.crud.model.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {

}
