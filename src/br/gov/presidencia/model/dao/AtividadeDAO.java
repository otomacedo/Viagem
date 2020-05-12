package br.gov.presidencia.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.gov.presidencia.model.Atividade;


public class AtividadeDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private javax.persistence.EntityManager em;

	public AtividadeDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Atividade atividade) {
		this.em.getTransaction().begin();
		this.em.persist(atividade);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Atividade atividade) {
		this.em.getTransaction().begin();
		this.em.remove(atividade);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Atividade atividade) {
		this.em.merge(atividade);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Atividade consultar(long id) {
		return this.em.find(Atividade.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Atividade> listar() {
		Query q = this.em.createQuery("SELECT c FROM Atividade c");
		return q.getResultList();
	}
}
