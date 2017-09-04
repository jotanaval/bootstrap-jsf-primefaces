/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import mar.mil.br.entity.Sugestao;
import mar.mil.br.generics.GenericDAO;
import mar.mil.br.usuario.Usuario;

/**
 *
 * @author Junior
 */
@Stateless
public class SugestaoRepository extends GenericDAO<Sugestao>{

    public SugestaoRepository() {
        super(Sugestao.class);
    }
    public List<Sugestao> findAllNome() {
        String situacao = null;
        Query query = manager.createQuery("select s.id from Sugestao s ", Sugestao.class);
         return query.getResultList();
    }
     public List<Sugestao> ordenadas() {
         Query query = manager.createQuery("select v from Sugestao v ", Sugestao.class);
         return query.getResultList();
  
    }
     
     public List<Sugestao> sugestoes() {
         Query query = manager.createQuery("select v from Sugestao v order by v.dataSugestao DESC", Sugestao.class);
         return query.getResultList();
  
    }

    public Usuario findOneLogadoOm(String login) {
      String jpql = "select u from Usuario u where u.login = :login";
      return this.manager
              .createQuery(jpql,Usuario.class)
              .setParameter("login", login)
              .getSingleResult();
    }

    public List<Sugestao> findAllOm(String om) {
        String jpql = "select v from Sugestao v where v.om = :om";
      return this.manager
              .createQuery(jpql,Sugestao.class)
              .setParameter("om", om)
              .getResultList();
    }
    
    public void excluir(Sugestao sugestao) {
		Sugestao sugestaodb = manager.find(Sugestao.class, sugestao.getId());// precisa desatachar o objeto para que a exlusão ocorra
		this.manager.remove(sugestaodb);
	}
    
}
