/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha.repository;

import br.marinha.Dao.GenericDao;
import br.marinha.Material;
import javax.ejb.Stateless;

/**
 *
 * @author junior
 */
@Stateless
public class MaterialRepositorio extends GenericDao<Material>{

    public MaterialRepositorio() {
        super(Material.class);
    }

    public void excluir(Material material) {
        Material materialdb = manager.find(Material.class, material.getMaterial_id());// precisa desatachar o objeto para que a exlusão ocorra
		this.manager.remove(materialdb);
    }
    
    
}
