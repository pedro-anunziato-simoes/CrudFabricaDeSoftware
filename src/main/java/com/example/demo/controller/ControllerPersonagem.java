package com.example.demo.controller;

import com.example.demo.entities.EntityItensMagicos;
import com.example.demo.entities.EntityPersonagem;
import com.example.demo.enums.TipoItens;
import com.example.demo.service.ServicePersonagem;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class ControllerPersonagem {

    @Autowired
    ServicePersonagem servicePersonagem;

    @PostMapping("/add")
    @Operation(summary = "Cria um Personagem", description = "Adiciona um personagem no banco")
    public EntityPersonagem cirarPersonagem(@RequestBody EntityPersonagem personagem){
        return servicePersonagem.cirarPersonagem(personagem);
    }

    @GetMapping
    @Operation(summary = "Lista todos os Personagens", description = "Retorna uma lista de personagens")
    public List<EntityPersonagem> listarPersonagens(){
        return servicePersonagem.listarPersonagens();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um Personagem", description = "Busca um personagem no banco pelo seu Id")
    public EntityPersonagem buscarPersonagensById(@PathVariable  Long id) throws Exception {
        return servicePersonagem.buscarPersonagensById(id);
    }

    @PostMapping("/atualizarNome/{id}")
    @Operation(summary = "Atualiza o nome de guerreiro de um Personagem", description = "Atualiza o nome de um Personagem")
    public EntityPersonagem atualizarNomeGuerreiro(@RequestBody String nome,@PathVariable Long id) throws Exception {
        return servicePersonagem.atualizarNomeGuerreiro(nome,id);
    }

    @DeleteMapping("/remove/{id}")
    @Operation(summary = "Deleta o Personagem", description = "Deleta o Personagem do banco com base no seu id")
    public void removerPersonagem(@PathVariable Long id) throws Exception {
        servicePersonagem.removerPersonagem(id);
    }

    @GetMapping("/ListarItens/{id}")
    @Operation(summary = "Lista todos itens magicos de um personagem", description = "Lista todos itens magicos de um personagem com base no id do personagem")
    public List<EntityItensMagicos> listarItensMagicosPorPersonagem(@PathVariable Long id) throws Exception {
        return servicePersonagem.listarItensMagicosPorPersonagem(id);
    }

    @PostMapping("/removeItens/{personagemId}/{itemMagicoId}")
    @Operation(summary = "Remove o item magico do personagem", description = "Remove o item magico do personagem com base nos seus id's")
    public EntityPersonagem removerItemMagicos(@PathVariable Long personagemId,@PathVariable Long itemMagicoId) throws Exception {
        return servicePersonagem.removerItemMagicos(personagemId,itemMagicoId);
    }

    @GetMapping("/findAmuleto/{personagemId}")
    @Operation(summary = "Buscar o amuleto do Personagem", description = "Buscar o amuleto do Personagem com base no id")
    public EntityItensMagicos buscarItemAmuleto(@PathVariable Long personagemId) throws Exception {
        return servicePersonagem.buscarItemAmuleto(personagemId);
    }
}
