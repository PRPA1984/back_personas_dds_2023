package com.catedra.democatedra.services;

import com.catedra.democatedra.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService{
    public List<Domicilio> findALL() throws Exception;
    public Page<Domicilio> findALL(Pageable pageable) throws Exception;
    public Domicilio findById(Long id) throws Exception;
    public Domicilio save(Domicilio entity) throws Exception;
    public Domicilio update(Long id, Domicilio entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
