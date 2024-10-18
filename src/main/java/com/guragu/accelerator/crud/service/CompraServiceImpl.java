package com.guragu.accelerator.crud.service;

import com.guragu.accelerator.crud.model.dao.ICompraDao;
import com.guragu.accelerator.crud.model.entities.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    private ICompraDao compraDao;

    @Override
    public List<Compra> findAll() {
        return (List<Compra>) compraDao.findAll();
    }

    @Override
    public Compra findById(Long id) {
        return compraDao.findById(id).orElse(null);
    }

    @Override
    public Compra save(Compra compra) {
        return compraDao.save(compra);
    }

    @Override
    public void delete(Long id) {
        compraDao.deleteById(id);
    }
}
