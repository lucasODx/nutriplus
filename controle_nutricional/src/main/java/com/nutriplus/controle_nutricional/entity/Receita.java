package com.nutriplus.controle_nutricional.entity;

import com.nutriplus.controle_nutricional.entity.enums.DificuldadeEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "receitas")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "tempo_preparo_min", nullable = false)
    private Integer tempoPreparoMin;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "dificuldade")
    private DificuldadeEnum dificuldade = DificuldadeEnum.FACIL;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String instrucoes;

    public Receita() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTempoPreparoMin() {
        return tempoPreparoMin;
    }

    public void setTempoPreparoMin(Integer tempoPreparoMin) {
        this.tempoPreparoMin = tempoPreparoMin;
    }

    public DificuldadeEnum getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(DificuldadeEnum dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }
}
