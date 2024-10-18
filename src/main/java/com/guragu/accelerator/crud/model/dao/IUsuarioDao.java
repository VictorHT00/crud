package com.guragu.accelerator.crud.model.dao;

import com.guragu.accelerator.crud.model.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
}
