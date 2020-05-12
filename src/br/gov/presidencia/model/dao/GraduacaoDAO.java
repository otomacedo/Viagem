package br.gov.presidencia.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.gov.presidencia.model.Graduacao;


public class GraduacaoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private javax.persistence.EntityManager em;

	public GraduacaoDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Graduacao graduacao) {
		this.em.getTransaction().begin();
		this.em.persist(graduacao);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Graduacao graduacao) {
		this.em.getTransaction().begin();
		this.em.remove(graduacao);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Graduacao graduacao) {
		this.em.merge(graduacao);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Graduacao consultar(long id) {
		return this.em.find(Graduacao.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Graduacao> listar() {
		Query q = this.em.createQuery("SELECT c FROM Graduacao c");
		return q.getResultList();
	}

}
