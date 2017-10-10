/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha.Controller;


import br.marinha.Militar;
import br.marinha.repository.MilitarRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author junior
 */
@ManagedBean
@RequestScoped
public class MilitarController {
    
    @EJB
    MilitarRepository militarRepository;
    
    private List<Militar>militares = new ArrayList<Militar>();
    
    private Militar militar = new Militar();
    
        
    public String salvar(){
        if (militar.getId() == null) {
            this.militarRepository.save(militar);
            FacesMessage msg =  new FacesMessage("Militar cadastrado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            this.militarRepository.update(militar);
            FacesMessage msg =  new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        return "administracao";
    }
    public String alterar(){
        return "cadastro";
    }
    
    public String excluir(){
        this.militarRepository.excluir(militar);
        this.militares = null;  
        FacesMessage msg =  new FacesMessage("Remoção realizada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
        
                
    }

    public List<Militar> getMilitares() {
        this.militares = this.militarRepository.findAll();
        return militares;
    }

    public Militar getMilitar() {
        return militar;
    }

    public void setMilitar(Militar militar) {
        this.militar = militar;
    }
    
    
    
}
