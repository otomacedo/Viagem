package br.gov.presidencia.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.gov.presidencia.model.Gratificacao;

public class GratificacaoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private javax.persistence.EntityManager em;

	public GratificacaoDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Gratificacao gratificacao) {
		this.em.getTransaction().begin();
		this.em.persist(gratificacao);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Gratificacao gratificacao) {
		this.em.getTransaction().begin();
		this.em.remove(gratificacao);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Gratificacao gratificacao) {
		this.em.merge(gratificacao);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Gratificacao consultar(long id) {
		return this.em.find(Gratificacao.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Gratificacao> listar() {
		Query q = this.em.createQuery("SELECT c FROM Gratificacao c");
		return q.getResultList();
	}
}
