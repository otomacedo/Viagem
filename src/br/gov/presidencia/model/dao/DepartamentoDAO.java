package br.gov.presidencia.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.gov.presidencia.model.Departamento;

public class DepartamentoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private javax.persistence.EntityManager em;

	public DepartamentoDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Departamento departamento) {
		this.em.getTransaction().begin();
		this.em.persist(departamento);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Departamento departamento) {
		this.em.getTransaction().begin();
		this.em.remove(departamento);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Departamento departamento) {
		this.em.merge(departamento);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Departamento consultar(long id) {
		return this.em.find(Departamento.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Departamento> listar() {
		Query q = this.em.createQuery("SELECT c FROM Departamento c");
		return q.getResultList();
	}
	
}
