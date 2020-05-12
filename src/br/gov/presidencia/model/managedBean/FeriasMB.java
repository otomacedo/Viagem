package br.gov.presidencia.model.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.presidencia.model.Ferias;
import br.gov.presidencia.model.dao.FeriasDAO;
@ManagedBean(name="feriasMB")
@RequestScoped
public class FeriasMB implements Serializable{
	private static final long serialVersionUID=1L;
	
	private List<Ferias> ferias = new ArrayList<Ferias>();
	private Ferias feria;
	
	private FeriasDAO feriasDAO;
	
	public FeriasMB() {
		feriasDAO = new FeriasDAO();
	}
	public String listarFerias() {
		ferias = feriasDAO.listar();
		return"ferias";
	}
	public List<Ferias> getFerias(){
		return ferias;
	}
	public void setFerias(List<Ferias> feria) {
		this.ferias = feria;
	}
	public Ferias getFeria() {
		return feria;
	}
	public void setFeria(Ferias feria) {
		this.feria = feria;
	}
	public String salvar() {
		feriasDAO.incluir(this.feria);
		return "ferias";
	}
	public String alterar()  {
		feriasDAO.alterar(this.feria);
		return "ferias";
	}
	
	public String excluir() {
		feriasDAO.excluir(this.feria);
		return "ferias"; 
	}
	public String consultar() {
		feriasDAO.consultar(serialVersionUID);
		return "ferias";
	}
}
