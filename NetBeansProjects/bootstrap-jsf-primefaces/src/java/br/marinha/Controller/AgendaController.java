/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha.Controller;

import br.marinha.Agenda;
import br.marinha.repository.AgendaRepository;
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
public class AgendaController {

    @EJB
    private AgendaRepository agendaRepository;

    private Agenda agenda = new Agenda();
    private List<Agenda> agendas;
    private String destinoSalvar;
    
    String modificador = SecurityContextHolder.getContext().getAuthentication().getName();
    
    public String salvar(){
        
        if (agenda.getId() == null) {
            this.agenda.setLancador(modificador);
            this.agendaRepository.save(agenda);
            FacesMessage msg =  new FacesMessage("Agenda Memória cadastrada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        }else{
            this.agenda.setLancador(modificador);
            this.agendaRepository.update(agenda);
            FacesMessage msg =  new FacesMessage("Agenda Memória Atualizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        return "administracaoAgenda";
    }
    
    public String alterar(){
        return "cadastroAgenda";
    }
    public String remover(){
        this.agendaRepository.excluir(agenda);
        this.agendas = null;
        return null;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<Agenda> getAgendas() {
        this.agendas = this.agendaRepository.findAll();
        return this.agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
    
    
    
    
}
