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
public class CadastroIp implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ip_id;
    private String omSolicitante;
    private String nomeDoSolicitante;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSolicitacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVencimento;
    private String nomeDoCadastrante;
    private String faixaLiberada;

    public CadastroIp() {
    }

    public CadastroIp(Integer ip_id, String omSolicitante, String nomeDoSolicitante, Date dataSolicitacao, Date dataVencimento, String nomeDoCadastrante, String faixaLiberada) {
        this.ip_id = ip_id;
        this.omSolicitante = omSolicitante;
        this.nomeDoSolicitante = nomeDoSolicitante;
        this.dataSolicitacao = dataSolicitacao;
        this.dataVencimento = dataVencimento;
        this.nomeDoCadastrante = nomeDoCadastrante;
        this.faixaLiberada = faixaLiberada;
    }

    public Integer getIp_id() {
        return ip_id;
    }

    public void setIp_id(Integer ip_id) {
        this.ip_id = ip_id;
    }

    public String getOmSolicitante() {
        return omSolicitante;
    }

    public void setOmSolicitante(String omSolicitante) {
        this.omSolicitante = omSolicitante;
    }

    public String getNomeDoSolicitante() {
        return nomeDoSolicitante;
    }

    public void setNomeDoSolicitante(String nomeDoSolicitante) {
        this.nomeDoSolicitante = nomeDoSolicitante;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNomeDoCadastrante() {
        return nomeDoCadastrante;
    }

    public void setNomeDoCadastrante(String nomeDoCadastrante) {
        this.nomeDoCadastrante = nomeDoCadastrante;
    }

    public String getFaixaLiberada() {
        return faixaLiberada;
    }

    public void setFaixaLiberada(String faixaLiberada) {
        this.faixaLiberada = faixaLiberada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.ip_id);
        hash = 61 * hash + Objects.hashCode(this.omSolicitante);
        hash = 61 * hash + Objects.hashCode(this.nomeDoSolicitante);
        hash = 61 * hash + Objects.hashCode(this.dataSolicitacao);
        hash = 61 * hash + Objects.hashCode(this.dataVencimento);
        hash = 61 * hash + Objects.hashCode(this.nomeDoCadastrante);
        hash = 61 * hash + Objects.hashCode(this.faixaLiberada);
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
        final CadastroIp other = (CadastroIp) obj;
        if (!Objects.equals(this.omSolicitante, other.omSolicitante)) {
            return false;
        }
        if (!Objects.equals(this.nomeDoSolicitante, other.nomeDoSolicitante)) {
            return false;
        }
        if (!Objects.equals(this.nomeDoCadastrante, other.nomeDoCadastrante)) {
            return false;
        }
        if (!Objects.equals(this.faixaLiberada, other.faixaLiberada)) {
            return false;
        }
        if (!Objects.equals(this.ip_id, other.ip_id)) {
            return false;
        }
        if (!Objects.equals(this.dataSolicitacao, other.dataSolicitacao)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CadastroIp{" + "ip_id=" + ip_id + ", omSolicitante=" + omSolicitante + ", nomeDoSolicitante=" + nomeDoSolicitante + ", dataSolicitacao=" + dataSolicitacao + ", dataVencimento=" + dataVencimento + ", nomeDoCadastrante=" + nomeDoCadastrante + ", faixaLiberada=" + faixaLiberada + '}';
    }

    
}
