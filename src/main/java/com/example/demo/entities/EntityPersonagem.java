package com.example.demo.entities;

import com.example.demo.enums.Classe;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class EntityPersonagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeAventureiro;
    private Classe classe;
    private int level;
    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EntityItensMagicos> itensMagicos = new ArrayList<>();
    private int forca;
    private int defesa;

    public EntityPersonagem(String nome, String nomeAventureiro,List<EntityItensMagicos> itensMagicos, Classe classe, int level, int forca, int defesa) {
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.itensMagicos = itensMagicos;
        this.classe = classe;
        this.level = level;
        if(forca + defesa > 10){
            System.out.println("você só tem 10 pontos de habilidade");
        }
            this.defesa = defesa;
            this.forca = forca;

    }

    public EntityPersonagem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
