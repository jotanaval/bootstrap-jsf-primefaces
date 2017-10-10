/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.security.access.prepost.PostAuthorize;

/**
 *
 * @author junior
 */
@ManagedBean
@RequestScoped
public class NavegacaoBean {
    
    
    public String administracao(){
        return "administracao?faces-redirect=true";
    }
    public String administracaoMat(){
        return "administracaoMat?faces-redirect=true";
    }
    public String cadastro(){
        return "cadastro?faces-redirect=true";
    }
     public String cadastroMat(){
        return "cadastroMat?faces-redirect=true";
    }
     public String administracaoIp(){
         return "/protected/administracaoIp";
     }
     
     public String cadastroIp(){
         return "/protected/cadastroIp";
     }
     
     public String admin(){
         return "principal";
     }
    
}
