package br.gov.presidencia.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import br.gov.presidencia.model.Ferias;

	public class FeriasDAO implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private javax.persistence.EntityManager em;
		
		public FeriasDAO() {
			this.em = ConexaoFactory.getEntityManager();
		}
		public boolean incluir(Ferias ferias) {
			this.em.getTransaction().begin();
			this.em.persist(ferias);
			try {
				this.em.getTransaction().commit();
				return true;
			} catch (Exception e) { 
				return false;
			}
		}

		public boolean excluir(Ferias ferias) {
			this.em.getTransaction().begin();
			this.em.remove(ferias);
			try {
				this.em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		public boolean alterar(Ferias ferias) {
			this.em.merge(ferias);
			try {
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		public Ferias consultar(long id) {
			return this.em.find(Ferias.class,id);
		}
		
		@SuppressWarnings("unchecked")
		public List<Ferias> listar() {
			Query q = this.em.createQuery("SELECT c FROM Ferias c");
			return q.getResultList();
		}
	
	
}
