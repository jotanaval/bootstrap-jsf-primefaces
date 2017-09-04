/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import mar.mil.br.entity.Sugestao;
import mar.mil.br.repository.SugestaoRepository;
import mar.mil.br.usuario.Usuario;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Junior
 */
@ManagedBean
@ViewScoped
public class SugestaoBean {
    
    @EJB
    SugestaoRepository sugestaoRepository;
   
    private Sugestao sugestao = new Sugestao();
    private List<Sugestao>findAll= new ArrayList<>(); 
    private Sugestao sugestaoSelecionada;
    //este atributo é para fazer o relacionamento na hora da gravação
   Long modeloID; 
   
   private String ip;
   
   private String analise ="Em Analise";
   private String respondido = "Respondido";
   //pegando usuario logado e adicionando o nome dele a atualização
   String modificador = SecurityContextHolder.getContext().getAuthentication().getName();
   //=============================================================================

    public Sugestao getSugestaoSelecionada() {
        return sugestaoSelecionada;
    }
    public void setViaturaSelecionada(Sugestao sugestaoSelecionada) {
        this.sugestaoSelecionada = sugestaoSelecionada;
    }
   public void novaSituacao(){
       sugestao = new Sugestao();
   }
   public String logar(){
       return "/publico/login.xhtml?faces-redirect=true";
   }
   //este método direciona para pagina de usuários
   public String admin(){
       return "/usuario/principal.xhtml";
   }
    public String home(){
       return "/home.xhtml?faces-redirect=true";
   }
    
        
        
   
   //=============================================================================
    public String save(){
        if(sugestao.getAssunto()!= null && sugestao.getSugestao()!= null){
        if(sugestao.getId() == null){
             this.sugestao.setModificador(modificador);
             sugestao.setDataSugestao(new Date());
             sugestao.setSituacao(analise);
             // pega o ip do usuario no momento da criação da sugestão
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
             sugestao.setIp(request.getRemoteAddr());  
             
             
              this.sugestaoRepository.save(sugestao);
              FacesMessage msg =  new FacesMessage("Sugestão cadastrada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            
             this.sugestao.setModificador(modificador);
             sugestao.setDataObservacao(new Date());
             this.sugestaoRepository.update(sugestao); 
              FacesMessage msg =  new FacesMessage("Observação salva com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }    
       this.sugestao = new Sugestao();
       this.findAll=null;
       return null;
        }
        else{
        FacesMessage msg =  new FacesMessage(" A sugestão e/ou Assunto não pode ficar em branco, por favor preencha novamente!");
        FacesContext.getCurrentInstance().addMessage(null, msg);    
        
        }
       
        return null;
}
    public String editar(){
        return "addViatura";
    }
    public void excluir(){
        this.sugestaoRepository.delete(sugestaoSelecionada.getId());
        sugestaoSelecionada = null;
        
        FacesMessage msg =  new FacesMessage("Sugestão removida com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }    
//++++++++++++++++++++++++++++++++++++++++++++++++++
    public List<Sugestao> getFindAll() {
        this.findAll = this.sugestaoRepository.sugestoes();
        return findAll;
    }
     /**
 *  Busca as sugestões no banco de dados e organiza comforme a data
 * 
     * @return 
 */
    public List<Sugestao> getOrdenadas() {
        this.findAll = this.sugestaoRepository.sugestoes();
        return findAll;
    }
    //=============================Consulta de acordo com a OM======================================================
  /**
 *  Busca a Om do usuário logado no sistema e retorna a tabela conforme a regra de negócio para aquela OM
 * 
     * @return 
 */
    public List<Sugestao> getFindAllDefguranca() {   
        
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario OmLogado = this.sugestaoRepository.findOneLogadoOm(login);
        String om = OmLogado.getOm();
        String DivAnf = "DivAnf" ;
        List<Sugestao> findAllOm = new ArrayList<>();        
        if(OmLogado.getOm().equals(DivAnf)){
          findAllOm = this.sugestaoRepository.sugestoes();         
          }        
        return findAllOm;        
    }
    
    //==============================================================================================================

     /** Identifica o endereço IP remot
     * @return o*/
    public String getIP() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  
		    //String ip = null;
		    ip = request.getHeader("x-forwarded-for");
		    if (ip == null) {
		    	ip = request.getHeader("X_FORWARDED_FOR");
		        if (ip == null){
		        	ip = request.getRemoteAddr();
		        }
                    }
                    return ip;
    }
    //Este método verifica se o usuário esta logado e caso esteja ele retorna true
   public boolean isAuthenticated(){
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
}
      //lista de assuntos para escolha   
    public List<String>getAssuntos(){
        List<String> assuntos = new ArrayList<>();
        assuntos.add("Rancho");
        assuntos.add("Conforto");
        assuntos.add("Limpeza");
        assuntos.add("Força de Trabalho");
        assuntos.add("Rancho");
        assuntos.add("Ativ_Administrativa");
        assuntos.add("Ativ_Ensino");
        assuntos.add("Ativ_Esportiva");
        assuntos.add("Cerimônias");
        assuntos.add("Estacionamento");
        assuntos.add("Serviço da OM");
        assuntos.add("Eventos");
        return assuntos;
        
    }
    public SugestaoRepository getSugestaoRepository() {
        return sugestaoRepository;
    }

    public Sugestao getSugestao() {
        return sugestao;
    }

    public Long getModeloID() {
        return modeloID;
    }

    public String getModificador() {
        return modificador;
    }

    public void setSugestaoRepository(SugestaoRepository sugestaoRepository) {
        this.sugestaoRepository = sugestaoRepository;
    }

    public void setSugestao(Sugestao sugestao) {
        this.sugestao = sugestao;
    }

    public void setFindAll(List<Sugestao> findAll) {
        this.findAll = findAll;
    }

    public void setSugestaoSelecionada(Sugestao sugestaoSelecionada) {
        this.sugestaoSelecionada = sugestaoSelecionada;
    }

    public void setModeloID(Long modeloID) {
        this.modeloID = modeloID;
    }

    public void setModificador(String modificador) {
        this.modificador = modificador;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public String getRespondido() {
        return respondido;
    }

    public void setRespondido(String respondido) {
        this.respondido = respondido;
    }
    
    
}
