package com.nutriplus.controle_nutricional.entity;

import com.nutriplus.controle_nutricional.entity.enums.ObjetivoEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "metas_nutricionais")
public class MetaNutricional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false, unique = true)
    private Long usuarioId;

    @Column(name = "meta_calorica_diaria", nullable = false, precision = 6, scale = 2)
    private BigDecimal metaCaloricaDiaria;

    @Column(name = "meta_proteinas_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal metaProteinasG;

    @Column(name = "meta_carboidratos_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal metaCarboidratosG;

    @Column(name = "meta_gorduras_g", nullable = false, precision = 6, scale = 2)
    private BigDecimal metaGordurasG;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "objetivo", nullable = false)
    private ObjetivoEnum objetivo;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public MetaNutricional() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public BigDecimal getMetaCaloricaDiaria() {
        return metaCaloricaDiaria;
    }

    public void setMetaCaloricaDiaria(BigDecimal metaCaloricaDiaria) {
        this.metaCaloricaDiaria = metaCaloricaDiaria;
    }

    public BigDecimal getMetaProteinasG() {
        return metaProteinasG;
    }

    public void setMetaProteinasG(BigDecimal metaProteinasG) {
        this.metaProteinasG = metaProteinasG;
    }

    public BigDecimal getMetaCarboidratosG() {
        return metaCarboidratosG;
    }

    public void setMetaCarboidratosG(BigDecimal metaCarboidratosG) {
        this.metaCarboidratosG = metaCarboidratosG;
    }

    public BigDecimal getMetaGordurasG() {
        return metaGordurasG;
    }

    public void setMetaGordurasG(BigDecimal metaGordurasG) {
        this.metaGordurasG = metaGordurasG;
    }

    public ObjetivoEnum getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ObjetivoEnum objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
