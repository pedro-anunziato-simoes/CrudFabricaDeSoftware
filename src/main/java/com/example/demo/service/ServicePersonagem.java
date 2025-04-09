package com.example.demo.service;

import com.example.demo.entities.EntityItensMagicos;
import com.example.demo.entities.EntityPersonagem;
import com.example.demo.enums.TipoItens;
import com.example.demo.repositories.RepositoryPersonagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePersonagem {

    @Autowired
    RepositoryPersonagem repositoryPersonagem;
    @Autowired
    ServiceItensMagicos serviceItensMagicos;


    public EntityPersonagem cirarPersonagem(EntityPersonagem personagem){
        return repositoryPersonagem.save(personagem);
    }

    public List<EntityPersonagem> listarPersonagens(){
        return repositoryPersonagem.findAll();
    }

    public EntityPersonagem buscarPersonagensById(Long id) throws Exception {
        return repositoryPersonagem.findById(id).orElseThrow(() -> new Exception("Personagem não encontrado"));
    }

    public EntityPersonagem atualizarNomeGuerreiro(String nome, Long id) throws Exception {
        EntityPersonagem personagem = repositoryPersonagem.findById(id).orElseThrow(() -> new Exception("Personagem não encontrado"));;
        personagem.setNomeAventureiro(nome);
        return personagem;
    }

    public void removerPersonagem(Long id) throws Exception {
        repositoryPersonagem.delete(repositoryPersonagem.findById(id).orElseThrow(() -> new Exception("Personagem não encontrado")));
    }

    public List<EntityItensMagicos> listarItensMagicosPorPersonagem(Long id) throws Exception {
        EntityPersonagem personagem = repositoryPersonagem.findById(id).orElseThrow(() -> new Exception("Personagem não encontrado"));
        return personagem.getItensMagicos();
    }

    public EntityPersonagem removerItemMagicos(Long personagemId, Long itemMagicoId) throws Exception {
        EntityPersonagem personagem = repositoryPersonagem.findById(personagemId).orElseThrow(() -> new Exception("Personagem não encontrado"));
        EntityItensMagicos item = serviceItensMagicos.buscarItemMagicoById(itemMagicoId);
        personagem.getItensMagicos().remove(item);
        return personagem;
    }

    public EntityItensMagicos buscarItemAmuleto(Long personagemId) throws Exception {
        TipoItens amuleto = TipoItens.AMULETO;
        EntityPersonagem personagem = repositoryPersonagem.findById(personagemId).orElseThrow(() -> new Exception("Personagem não encontrado"));
       return personagem.getItensMagicos().stream()
                .filter(item -> item.getTipo().equals(amuleto))
                .findFirst()
                .orElse(null);
    }
}
