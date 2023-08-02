package com.catedra.democatedra.services;

import com.catedra.democatedra.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService {
    public List<Persona> findALL() throws Exception;
    public Page<Persona> findALL(Pageable pageable) throws Exception;
    public Persona findById(Long id) throws Exception;
    public Persona save(Persona entity) throws Exception;
    public Persona update(Long id, Persona entity) throws Exception;
    public boolean delete(Long id) throws Exception;
    List<Persona> search(String filtro) throws Exception;
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
