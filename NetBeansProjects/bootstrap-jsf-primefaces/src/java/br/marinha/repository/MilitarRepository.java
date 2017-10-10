/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha.repository;

import br.marinha.Dao.GenericDao;
import br.marinha.Material;
import br.marinha.Militar;
import javax.ejb.Stateless;

/**
 *
 * @author junior
 */
@Stateless
public class MilitarRepository extends GenericDao<Militar>{

    public MilitarRepository() {
        super(Militar.class);
    }

    public void excluir(Militar militar) {
        Militar militardb = manager.find(Militar.class, militar.getId());// precisa desatachar o objeto para que a exlusão ocorra
		this.manager.remove(militardb);
    }
    
    
}
