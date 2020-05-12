package br.gov.presidencia.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.gov.presidencia.model.Documento;

public class DocumentoDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private javax.persistence.EntityManager em;

	public DocumentoDAO () {
		this.em = ConexaoFactory.getEntityManager();
	}

	public boolean incluir(Documento documento) {
		this.em.getTransaction().begin();
		this.em.persist(documento);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) { 
			return false;
		}
	}

	public boolean excluir(Documento documento) {
		this.em.getTransaction().begin();
		this.em.remove(documento);
		try {
			this.em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alterar(Documento documento) {
		this.em.merge(documento);
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Documento consultar(long id) {
		return this.em.find(Documento.class,id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Documento> listar() {
		Query q = this.em.createQuery("SELECT c FROM Documento c");
		return q.getResultList();
	}
	
}
		
		
		