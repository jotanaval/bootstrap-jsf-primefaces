/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author junior
 */
@Entity
public class Material implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer material_id;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entradaOperacao;
    private String vidaUtil;
    private String situacaoAtual;
    private String numeroMatricial;
    private String valor;
    private String tipo;

    public Material() {
    }

    public Material(Integer material_id, String descricao, Date entradaOperacao, String vidaUtil, String situacaoAtual, String numeroMatricial, String valor, String tipo) {
        this.material_id = material_id;
        this.descricao = descricao;
        this.entradaOperacao = entradaOperacao;
        this.vidaUtil = vidaUtil;
        this.situacaoAtual = situacaoAtual;
        this.numeroMatricial = numeroMatricial;
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Material{" + "material_id=" + material_id + ", descricao=" + descricao + ", entradaOperacao=" + entradaOperacao + ", vidaUtil=" + vidaUtil + ", situacaoAtual=" + situacaoAtual + ", numeroMatricial=" + numeroMatricial + ", valor=" + valor + ", tipo=" + tipo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.material_id);
        hash = 61 * hash + Objects.hashCode(this.descricao);
        hash = 61 * hash + Objects.hashCode(this.entradaOperacao);
        hash = 61 * hash + Objects.hashCode(this.vidaUtil);
        hash = 61 * hash + Objects.hashCode(this.situacaoAtual);
        hash = 61 * hash + Objects.hashCode(this.numeroMatricial);
        hash = 61 * hash + Objects.hashCode(this.valor);
        hash = 61 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Material other = (Material) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.vidaUtil, other.vidaUtil)) {
            return false;
        }
        if (!Objects.equals(this.situacaoAtual, other.situacaoAtual)) {
            return false;
        }
        if (!Objects.equals(this.numeroMatricial, other.numeroMatricial)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.material_id, other.material_id)) {
            return false;
        }
        if (!Objects.equals(this.entradaOperacao, other.entradaOperacao)) {
            return false;
        }
        return true;
    }

    
    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getEntradaOperacao() {
        return entradaOperacao;
    }

    public void setEntradaOperacao(Date entradaOperacao) {
        this.entradaOperacao = entradaOperacao;
    }

    public String getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getSituacaoAtual() {
        return situacaoAtual;
    }

    public void setSituacaoAtual(String situacaoAtual) {
        this.situacaoAtual = situacaoAtual;
    }

    public String getNumeroMatricial() {
        return numeroMatricial;
    }

    public void setNumeroMatricial(String numeroMatricial) {
        this.numeroMatricial = numeroMatricial;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
