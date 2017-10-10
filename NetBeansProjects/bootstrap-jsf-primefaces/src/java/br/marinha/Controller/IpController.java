/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha.Controller;

import br.marinha.CadastroIp;
import br.marinha.repository.CadastroIpRepository;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author junior
 */
@ManagedBean
@RequestScoped
public class IpController implements Serializable{

    public IpController() {
    }
    
    @EJB
    private CadastroIpRepository cadastroIpRepository;
    
    @SuppressWarnings("FieldMayBeFinal")
    private CadastroIp cadastroIp = new CadastroIp();
    private CadastroIp alvo = new CadastroIp();
    private List<CadastroIp>ips;
    private String destino;
    //pega o usuario logado 
    String modificador = SecurityContextHolder.getContext().getAuthentication().getName();
    
    public String salvar(){
        
        if (alvo.getIp_id() == null) {
            this.alvo.setNomeDoCadastrante(modificador);//grava o cadastrante
            
            this.cadastroIpRepository.save(alvo);
            
            FacesMessage msg =  new FacesMessage("Controle IP cadastrado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        }else{
            this.alvo.setNomeDoCadastrante(modificador);//grava o cadastrante
            this.cadastroIpRepository.update(alvo);
            FacesMessage msg =  new FacesMessage("Controle IP Atualizado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return "administracaoIp";
    }
    
    public String alterar(){
        return "/protected/cadastroIp";
    }
    
    public String remover(){
        this.cadastroIpRepository.remover(this.alvo);
        this.ips = null;
        return null;
    }

    public CadastroIp getCadastroIp() {
        return cadastroIp;
    }

    public List<CadastroIp> getIps() {
        this.ips = this.cadastroIpRepository.findAll();
        return ips;
    }

    public String getDestino() {
        return destino;
    }

    public CadastroIp getAlvo() {
        return alvo;
    }

    public void setAlvo(CadastroIp alvo) {
        this.alvo = alvo;
    }
    
    
}
