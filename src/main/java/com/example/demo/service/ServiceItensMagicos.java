package com.example.demo.service;

import com.example.demo.entities.EntityItensMagicos;
import com.example.demo.repositories.RepositoryItensMagicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceItensMagicos {

    @Autowired
    RepositoryItensMagicos repositoryItensMagicos;

    public EntityItensMagicos criarItemMagico(EntityItensMagicos itemMagico){
        return repositoryItensMagicos.save(itemMagico);
    }

    public List<EntityItensMagicos> listarItensMagicos(){
        return repositoryItensMagicos.findAll();
    }

    public EntityItensMagicos buscarItemMagico(Long id) throws Exception {
        return repositoryItensMagicos.findById(id).orElseThrow(() -> new Exception("item não encontrado"));
    }
}
