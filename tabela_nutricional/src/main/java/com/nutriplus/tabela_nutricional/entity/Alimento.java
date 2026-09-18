package com.nutriplus.tabela_nutricional.entity;

import com.nutriplus.tabela_nutricional.entity.enums.IndiceGlicemicoEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alimentos")
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(name = "calorias_por_100g", nullable = false, precision = 6, scale = 2)
    private BigDecimal caloriasPor100g;

    @Column(name = "proteinas_100g", nullable = false, precision = 6, scale = 2)
    private BigDecimal proteinas100g;

    @Column(name = "carboidratos_100g", nullable = false, precision = 6, scale = 2)
    private BigDecimal carboidratos100g;

    @Column(name = "gorduras_100g", nullable = false, precision = 6, scale = 2)
    private BigDecimal gorduras100g;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "indice_glicemico")
    private IndiceGlicemicoEnum indiceGlicemico = IndiceGlicemicoEnum.BAIXO;

    @OneToMany(mappedBy = "alimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContraindicacaoAlimento> contraindicacoes = new ArrayList<>();

    public Alimento() {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getCaloriasPor100g() {
        return caloriasPor100g;
    }

    public void setCaloriasPor100g(BigDecimal caloriasPor100g) {
        this.caloriasPor100g = caloriasPor100g;
    }

    public BigDecimal getProteinas100g() {
        return proteinas100g;
    }

    public void setProteinas100g(BigDecimal proteinas100g) {
        this.proteinas100g = proteinas100g;
    }

    public BigDecimal getCarboidratos100g() {
        return carboidratos100g;
    }

    public void setCarboidratos100g(BigDecimal carboidratos100g) {
        this.carboidratos100g = carboidratos100g;
    }

    public BigDecimal getGorduras100g() {
        return gorduras100g;
    }

    public void setGorduras100g(BigDecimal gorduras100g) {
        this.gorduras100g = gorduras100g;
    }

    public IndiceGlicemicoEnum getIndiceGlicemico() {
        return indiceGlicemico;
    }

    public void setIndiceGlicemico(IndiceGlicemicoEnum indiceGlicemico) {
        this.indiceGlicemico = indiceGlicemico;
    }

    public List<ContraindicacaoAlimento> getContraindicacoes() {
        return contraindicacoes;
    }

    public void setContraindicacoes(List<ContraindicacaoAlimento> contraindicacoes) {
        this.contraindicacoes = contraindicacoes;
    }
}
