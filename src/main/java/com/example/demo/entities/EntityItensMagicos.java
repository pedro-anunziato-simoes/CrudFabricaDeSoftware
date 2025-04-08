package com.example.demo.entities;

import com.example.demo.enums.TipoItens;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class EntityItensMagicos {

    @Id
    private Long id;
    private String nome;
    private TipoItens tipo;
    private int forca;
    private int defesa;

    public EntityItensMagicos(String nome, TipoItens tipo, int forca, int defesa) {
        this.nome = nome;
        this.tipo = tipo;
        if(forca + defesa > 10 && forca > 0 && defesa > 0){
            System.out.println("você só tem 10 pontos de habilidade");
        }
        this.forca = forca;
        this.defesa = defesa;
    }

    public Long getId() {
        return id;
    }

    public void setForca(int forca) {
        switch (tipo) {
            case ARMA, AMULETO -> this.forca = forca;
            case ARMADURA -> this.forca = 0;
        }
    }

    public void setDefesa(int defesa) {
        switch (tipo) {
            case ARMADURA, AMULETO -> this.defesa = defesa;
            case ARMA -> this.defesa = 0;
        }
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public TipoItens getTipo() {
        return tipo;
    }

    public void setTipo(TipoItens tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
