package com.example.demo.entities;

import com.example.demo.enums.Classe;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.util.List;
@Entity
public class EntityPersonagem {

    @Id
    private Long id;
    private String nome;
    private String nomeAventureiro;
    private Classe classe;
    private int level;
    private List<EntityItensMagicos> itensMagicos;
    private int forca;
    private int defesa;

    public EntityPersonagem(String nome, String nomeAventureiro, Classe classe, int level, List<EntityItensMagicos> itensMagicos, int forca, int defesa) {
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.itensMagicos = itensMagicos;
        if(forca + defesa > 10){
            System.out.println("você só tem 10 pontos de habilidade");
        }
            this.forca = forca;
            this.defesa = defesa;
    }

    public Long getId() {
        return id;
    }

    public int getForca() {
        int itensForca = 0;
        for (EntityItensMagicos item : itensMagicos) {
            itensForca = item.getForca();
        }
        return forca + itensForca;
    }

    public int getDefesa() {
        int itensDefesa = 0;
        for(EntityItensMagicos item : itensMagicos){
            itensDefesa = item.getDefesa();
        }
        return defesa+itensDefesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public Classe getClasse() {
        return classe;
    }

    public int getLevel() {
        return level;
    }

    public List<EntityItensMagicos> getItensMagicos() {
        return itensMagicos;
    }

    public void setItensMagicos(List<EntityItensMagicos> itensMagicos) {
        this.itensMagicos = itensMagicos;
    }
}
