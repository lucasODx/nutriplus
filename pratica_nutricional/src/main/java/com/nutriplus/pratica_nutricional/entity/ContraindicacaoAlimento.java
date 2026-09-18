package com.nutriplus.pratica_nutricional.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contraindicacoes_alimento")
public class ContraindicacaoAlimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alimento_id", nullable = false)
    private Alimento alimento;

    @Column(name = "condicao_medica", nullable = false, length = 50)
    private String condicaoMedica;

    public ContraindicacaoAlimento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public String getCondicaoMedica() {
        return condicaoMedica;
    }

    public void setCondicaoMedica(String condicaoMedica) {
        this.condicaoMedica = condicaoMedica;
    }
}
