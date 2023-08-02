package com.catedra.democatedra.services;

import com.catedra.democatedra.entities.Domicilio;
import com.catedra.democatedra.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    @Transactional
    public List<Domicilio> findALL() throws Exception {
        try {
            return domicilioRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Domicilio> findALL(Pageable pageable) throws Exception {
        try {
            return domicilioRepository.findAll(pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio findById(Long id) throws Exception {
        try{
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            if(entityOptional.isEmpty()) {
                throw new Exception("No se encontro la entidad con el id dado.");
            }
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio save(Domicilio domicilio) throws Exception {
        try{
            return domicilioRepository.save(domicilio);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio update(Long id, Domicilio domicilio) throws Exception {
        try{
            if (domicilio.getId() == null) {
                throw new Exception("La entidad a modificar debe contener un Id.");
            } else if(!id.equals(domicilio.getId())){
                throw new Exception("El id enviado como parametro y el id de la entidad deben coincidir.");
            }

            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);

            if(entityOptional.isEmpty()) {
                throw new Exception("No se encontro la entidad con el id dado.");
            }

            return domicilioRepository.save(domicilio);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(domicilioRepository.existsById(id)){
                domicilioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
