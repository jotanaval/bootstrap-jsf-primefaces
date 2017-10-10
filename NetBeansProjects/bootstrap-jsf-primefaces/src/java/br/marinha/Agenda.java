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
import javax.xml.crypto.Data;

/**
 *
 * @author junior
 */
@Entity
public class Agenda implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String executor;
    private String faxina;
    private String observacaoes;
    private String solucaoImpl;
    private String lancador;
    
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSolicitacao;
      @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataExecFaxina;

    public Agenda() {
    }

    public Agenda(Integer id, String executor, String faxina, String observacaoes, String solucaoImpl, String lancador, Date dataSolicitacao, Date dataExecFaxina) {
        this.id = id;
        this.executor = executor;
        this.faxina = faxina;
        this.observacaoes = observacaoes;
        this.solucaoImpl = solucaoImpl;
        this.lancador = lancador;
        this.dataSolicitacao = dataSolicitacao;
        this.dataExecFaxina = dataExecFaxina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.executor);
        hash = 79 * hash + Objects.hashCode(this.faxina);
        hash = 79 * hash + Objects.hashCode(this.observacaoes);
        hash = 79 * hash + Objects.hashCode(this.solucaoImpl);
        hash = 79 * hash + Objects.hashCode(this.lancador);
        hash = 79 * hash + Objects.hashCode(this.dataSolicitacao);
        hash = 79 * hash + Objects.hashCode(this.dataExecFaxina);
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
        final Agenda other = (Agenda) obj;
        if (!Objects.equals(this.executor, other.executor)) {
            return false;
        }
        if (!Objects.equals(this.faxina, other.faxina)) {
            return false;
        }
        if (!Objects.equals(this.observacaoes, other.observacaoes)) {
            return false;
        }
        if (!Objects.equals(this.solucaoImpl, other.solucaoImpl)) {
            return false;
        }
        if (!Objects.equals(this.lancador, other.lancador)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataSolicitacao, other.dataSolicitacao)) {
            return false;
        }
        if (!Objects.equals(this.dataExecFaxina, other.dataExecFaxina)) {
            return false;
        }
        return true;
    }

      
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getFaxina() {
        return faxina;
    }

    public void setFaxina(String faxina) {
        this.faxina = faxina;
    }

    public String getObservacaoes() {
        return observacaoes;
    }

    public void setObservacaoes(String observacaoes) {
        this.observacaoes = observacaoes;
    }

    public String getSolucaoImpl() {
        return solucaoImpl;
    }

    public void setSolucaoImpl(String solucaoImpl) {
        this.solucaoImpl = solucaoImpl;
    }

    public String getLancador() {
        return lancador;
    }

    public void setLancador(String lancador) {
        this.lancador = lancador;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataExecFaxina() {
        return dataExecFaxina;
    }

    public void setDataExecFaxina(Date dataExecFaxina) {
        this.dataExecFaxina = dataExecFaxina;
    }

    @Override
    public String toString() {
        return "Agenda{" + "id=" + id + ", executor=" + executor + ", faxina=" + faxina + ", observacaoes=" + observacaoes + ", solucaoImpl=" + solucaoImpl + ", lancador=" + lancador + ", dataSolicitacao=" + dataSolicitacao + ", dataExecFaxina=" + dataExecFaxina + '}';
    }

    
}
