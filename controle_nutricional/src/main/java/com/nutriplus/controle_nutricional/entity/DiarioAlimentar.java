package com.nutriplus.controle_nutricional.entity;

import com.nutriplus.controle_nutricional.entity.enums.TipoRefeicaoEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "diario_alimentar")
public class DiarioAlimentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "data_refeicao", nullable = false)
    private LocalDateTime dataRefeicao;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "tipo_refeicao", nullable = false)
    private TipoRefeicaoEnum tipoRefeicao;

    @Column(name = "alimento_id", nullable = false)
    private Long alimentoId;

    @Column(name = "quantidade_gramas", nullable = false, precision = 8, scale = 2)
    private BigDecimal quantidadeGramas;

    @CreationTimestamp
    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm;

    public DiarioAlimentar() {
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

    public LocalDateTime getDataRefeicao() {
        return dataRefeicao;
    }

    public void setDataRefeicao(LocalDateTime dataRefeicao) {
        this.dataRefeicao = dataRefeicao;
    }

    public TipoRefeicaoEnum getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(TipoRefeicaoEnum tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    public Long getAlimentoId() {
        return alimentoId;
    }

    public void setAlimentoId(Long alimentoId) {
        this.alimentoId = alimentoId;
    }

    public BigDecimal getQuantidadeGramas() {
        return quantidadeGramas;
    }

    public void setQuantidadeGramas(BigDecimal quantidadeGramas) {
        this.quantidadeGramas = quantidadeGramas;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
