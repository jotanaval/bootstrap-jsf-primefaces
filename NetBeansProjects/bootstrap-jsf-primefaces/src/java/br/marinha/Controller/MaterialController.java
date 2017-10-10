/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha.Controller;

import br.marinha.Material;
import br.marinha.repository.MaterialRepositorio;
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
public class MaterialController {
    
    @EJB
    private MaterialRepositorio materialRepositorio;
    private Material material = new Material();
    private List<Material>materiais ;
    private String destinoSalvar;   
    
    
    public String salvar(){
        if (material.getMaterial_id() == null) {
            this.materialRepositorio.save(material);
             FacesMessage msg =  new FacesMessage("Material cadastrado com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            this.materialRepositorio.update(material);
            FacesMessage msg =  new FacesMessage("Alteração realizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        return "administracaoMat";
    }
    
    public String alterar(){
        return "cadastroMat";
    }
    
    
    public String excluir1() {
		
		materialRepositorio.excluir(this.material);
		this.materiais = null;
		return null;
	}

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Material> getMateriais() {
     this.materiais = this.materialRepositorio.findAll();
      return materiais;
    }

    public void setMateriais(ArrayList<Material> materiais) {
        this.materiais = materiais;
    }

    public String getDestinoSalvar() {
        return destinoSalvar;
    }

    public void setDestinoSalvar(String destinoSalvar) {
        this.destinoSalvar = destinoSalvar;
    }
    
    
    
}
