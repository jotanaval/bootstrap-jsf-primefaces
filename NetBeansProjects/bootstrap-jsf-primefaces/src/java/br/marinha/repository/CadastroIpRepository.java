/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.marinha.repository;

import br.marinha.CadastroIp;
import br.marinha.Dao.GenericDao;
import javax.ejb.Stateless;

/**
 *
 * @author junior
 */
@Stateless
public class CadastroIpRepository extends GenericDao<CadastroIp>{

    public CadastroIpRepository() {
        super(CadastroIp.class);
    }

    public void remover(CadastroIp cadastroIp) {
         CadastroIp cadastrodb = manager.find(CadastroIp.class, cadastroIp.getIp_id());// precisa desatachar o objeto para que a exlusão ocorra
		this.manager.remove(cadastrodb);
    }
    
}
