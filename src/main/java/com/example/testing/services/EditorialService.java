package com.example.testing.services;

import com.example.testing.entities.Autor;
import com.example.testing.entities.Editorial;
import com.example.testing.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Transactional
    public List<Editorial> findAll() throws Exception {
        try{
            List<Editorial> entities = editorialRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Editorial findById(Long id) throws Exception {
        try{
            Optional<Editorial> entityOptional = editorialRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public Editorial save(Editorial entity) throws Exception {
        try{
            entity = editorialRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
