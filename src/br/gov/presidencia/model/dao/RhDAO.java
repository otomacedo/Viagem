package br.gov.presidencia.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import br.gov.presidencia.model.Funcionario;
import br.gov.presidencia.model.Rh;

public class RhDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private javax.persistence.EntityManager em;
	
	public RhDAO() {
		this.em = ConexaoFactory.getEntityManager();
	}
	
	public boolean incluir(Rh rh) {
		try {
			em.getTransaction().begin();
			this.em.persist(rh);
			this.em.flush();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Rh rh) {
		this.em.getTransaction().begin();
		this.em.remove(rh);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Rh rh) {
		this.em.merge(rh);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Rh consultar(long id) {
		return this.em.find(Rh.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Rh> listar() {
		Query q = this.em.createQuery("SELECT c FROM Rh c");
		return q.getResultList();
	}
	
	public Rh consultarPorFuncionario(Funcionario funcionario) {
		Query q = this.em.createQuery("SELECT r FROM Rh r WHERE r.funcionario.idFuncionario = "+funcionario.getIdFuncionario());
		return  q.getResultList().isEmpty() ? null : (Rh) q.getResultList().get(0);
	}

}
