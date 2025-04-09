package com.example.demo.controller;

import com.example.demo.entities.EntityItensMagicos;
import com.example.demo.entities.EntityPersonagem;
import com.example.demo.service.ServiceItensMagicos;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerItensMagicos {

    @Autowired
    ServiceItensMagicos serviceItensMagicos;

    @GetMapping
    @Operation(summary = "Listar todos os Itens Magicos", description = "Retorna uma lista de Itens Magicos")
    public List<EntityItensMagicos> listarItensMagicos(){
        return  serviceItensMagicos.listarItensMagicos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um item Magico", description = "Retorna um Item Magico")
    public EntityItensMagicos findItensById(@PathVariable Long id) throws Exception {
        return serviceItensMagicos.buscarItemMagicoById(id);
    }

    @PostMapping("/add")
    @Operation(summary = "Cria um item Magico", description = "Cria um item magico ao banco")
    public EntityItensMagicos adicioarItemMagico(@RequestBody EntityItensMagicos item){
        return serviceItensMagicos.criarItemMagico(item);
    }

    @DeleteMapping("/remove/{id}")
    @Operation(summary = "Deleta um item Magico", description = "Deleta um Item Magico do banco")
    public void removerItemMagico(@PathVariable Long id){
        serviceItensMagicos.removerItemMagico(id);
    }

    @PostMapping("/vincular/{itemId}/{personagemId}")
    @Operation(summary = "Adiciona/vincula um item Magico a um personagem", description = "vincula um Item Magico a um personagem")
    public EntityPersonagem adicionarItemMagicoPersonagem(@PathVariable Long itemId,@PathVariable Long personagemId) throws Exception {
        return serviceItensMagicos.adicionarItemMagico(itemId,personagemId);
    }
}
