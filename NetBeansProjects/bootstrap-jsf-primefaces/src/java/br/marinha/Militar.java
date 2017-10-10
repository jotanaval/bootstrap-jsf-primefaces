/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
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
public class Militar implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identidade;
    private String nome;
    @Column(unique=true)
    private String nip;
    private String endereco;
    private String telCel;
    private String telConvencional;
    private String cursos;
    //tiro de carreira
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVencimentoTiro;
    private String pontuacao;
    private String classeTiro; 
    
    //inspeção de saúde
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataUltima;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataValidade;
    private String resultado;
    private String dispensa;
    
    //contato Pessoa da familia
    private String nomeFamiliar;
    private String telContato;

    public Militar() {
    }

    public Militar(Integer id, String identidade, String nome, String nip, String endereco, String telCel, String telConvencional, String cursos, Date dataVencimentoTiro, String pontuacao, String classeTiro, Date dataUltima, Date dataValidade, String resultado, String dispensa, String nomeFamiliar, String telContato) {
        this.id = id;
        this.identidade = identidade;
        this.nome = nome;
        this.nip = nip;
        this.endereco = endereco;
        this.telCel = telCel;
        this.telConvencional = telConvencional;
        this.cursos = cursos;
        this.dataVencimentoTiro = dataVencimentoTiro;
        this.pontuacao = pontuacao;
        this.classeTiro = classeTiro;
        this.dataUltima = dataUltima;
        this.dataValidade = dataValidade;
        this.resultado = resultado;
        this.dispensa = dispensa;
        this.nomeFamiliar = nomeFamiliar;
        this.telContato = telContato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getTelConvencional() {
        return telConvencional;
    }

    public void setTelConvencional(String telConvencional) {
        this.telConvencional = telConvencional;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }

    public Date getDataVencimentoTiro() {
        return dataVencimentoTiro;
    }

    public void setDataVencimentoTiro(Date dataVencimentoTiro) {
        this.dataVencimentoTiro = dataVencimentoTiro;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getClasseTiro() {
        return classeTiro;
    }

    public void setClasseTiro(String classeTiro) {
        this.classeTiro = classeTiro;
    }

    public Date getDataUltima() {
        return dataUltima;
    }

    public void setDataUltima(Date dataUltima) {
        this.dataUltima = dataUltima;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDispensa() {
        return dispensa;
    }

    public void setDispensa(String dispensa) {
        this.dispensa = dispensa;
    }

    public String getNomeFamiliar() {
        return nomeFamiliar;
    }

    public void setNomeFamiliar(String nomeFamiliar) {
        this.nomeFamiliar = nomeFamiliar;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.identidade);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.nip);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        hash = 79 * hash + Objects.hashCode(this.telCel);
        hash = 79 * hash + Objects.hashCode(this.telConvencional);
        hash = 79 * hash + Objects.hashCode(this.cursos);
        hash = 79 * hash + Objects.hashCode(this.dataVencimentoTiro);
        hash = 79 * hash + Objects.hashCode(this.pontuacao);
        hash = 79 * hash + Objects.hashCode(this.classeTiro);
        hash = 79 * hash + Objects.hashCode(this.dataUltima);
        hash = 79 * hash + Objects.hashCode(this.dataValidade);
        hash = 79 * hash + Objects.hashCode(this.resultado);
        hash = 79 * hash + Objects.hashCode(this.dispensa);
        hash = 79 * hash + Objects.hashCode(this.nomeFamiliar);
        hash = 79 * hash + Objects.hashCode(this.telContato);
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
        final Militar other = (Militar) obj;
        if (!Objects.equals(this.identidade, other.identidade)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nip, other.nip)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telCel, other.telCel)) {
            return false;
        }
        if (!Objects.equals(this.telConvencional, other.telConvencional)) {
            return false;
        }
        if (!Objects.equals(this.cursos, other.cursos)) {
            return false;
        }
        if (!Objects.equals(this.pontuacao, other.pontuacao)) {
            return false;
        }
        if (!Objects.equals(this.classeTiro, other.classeTiro)) {
            return false;
        }
        if (!Objects.equals(this.resultado, other.resultado)) {
            return false;
        }
        if (!Objects.equals(this.dispensa, other.dispensa)) {
            return false;
        }
        if (!Objects.equals(this.nomeFamiliar, other.nomeFamiliar)) {
            return false;
        }
        if (!Objects.equals(this.telContato, other.telContato)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataVencimentoTiro, other.dataVencimentoTiro)) {
            return false;
        }
        if (!Objects.equals(this.dataUltima, other.dataUltima)) {
            return false;
        }
        if (!Objects.equals(this.dataValidade, other.dataValidade)) {
            return false;
        }
        return true;
    }
    

    
    
}
