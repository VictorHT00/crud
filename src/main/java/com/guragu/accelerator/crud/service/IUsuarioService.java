package com.guragu.accelerator.crud.service;

import com.guragu.accelerator.crud.model.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void delete(Long id);

}
