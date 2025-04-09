package com.example.demo.service;

import com.example.demo.entities.EntityItensMagicos;
import com.example.demo.entities.EntityPersonagem;
import com.example.demo.enums.TipoItens;
import com.example.demo.repositories.RepositoryItensMagicos;
import com.example.demo.repositories.RepositoryPersonagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceItensMagicos {

    @Autowired
    RepositoryItensMagicos repositoryItensMagicos;
    @Autowired
    RepositoryPersonagem repositoryPersonagem;

    public EntityItensMagicos criarItemMagico(EntityItensMagicos itemMagico){
        return repositoryItensMagicos.save(itemMagico);
    }

    public List<EntityItensMagicos> listarItensMagicos(){
        return repositoryItensMagicos.findAll();
    }

    public EntityItensMagicos buscarItemMagicoById(Long id) throws Exception {
        return repositoryItensMagicos.findById(id).orElseThrow(() -> new Exception("item não encontrado"));
    }

    public void removerItemMagico(Long id){
        repositoryItensMagicos.deleteById(id);
    }

    public EntityPersonagem adicionarItemMagico(Long itemId, Long personagemId) throws Exception {

        EntityItensMagicos item = buscarItemMagicoById(itemId);
        EntityPersonagem personagem = repositoryPersonagem.findById(personagemId).orElseThrow(() -> new Exception("Personagem não encontrado"));
        boolean jaTemAmuleto = personagem.getItensMagicos().stream()
                .anyMatch(it -> it.getTipo() == TipoItens.AMULETO);
        if (item.getTipo() == TipoItens.AMULETO && jaTemAmuleto) {
            throw new Exception("Este personagem já possui um amuleto.");
        }
        item.setPersonagem(personagem);
        personagem.getItensMagicos().add(item);
        repositoryItensMagicos.save(item);
        return repositoryPersonagem.save(personagem);
    }
}
