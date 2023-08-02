package com.catedra.democatedra.services;

import com.catedra.democatedra.entities.Persona;
import com.catedra.democatedra.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public List<Persona> findALL() throws Exception {
        try {
            return personaRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Persona> findALL(Pageable pageable) throws Exception {
        try {
            return personaRepository.findAll(pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
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
    public Persona save(Persona persona) throws Exception {
        try{
            return personaRepository.save(persona);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona persona) throws Exception {
        try{
            if (persona.getId() == null) {
                throw new Exception("La entidad a modificar debe contener un Id.");
            } else if(!id.equals(persona.getId())){
                throw new Exception("El id enviado como parametro y el id de la entidad deben coincidir.");
            }

            Optional<Persona> entityOptional = personaRepository.findById(id);

            if(entityOptional.isEmpty()) {
                throw new Exception("No se encontro la entidad con el id dado.");
            }

            return personaRepository.save(persona);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            return personaRepository.search(filtro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            return personaRepository.search(filtro, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
