package br.gov.presidencia.model.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.gov.presidencia.model.Funcionario;
import br.gov.presidencia.model.Rh;
import br.gov.presidencia.model.dao.RhDAO;

@ManagedBean(name="rhMB")
@SessionScoped
public class RhMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public List<Rh> rhs = new ArrayList<Rh>();
	private Rh rh = new Rh();
	private RhDAO rhDAO;
	
	public RhMB() {
		rhDAO = new RhDAO();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	public String listarRhs() {
		rhs = rhDAO.listar();
		return "rhs";
	}
	public List<Rh> getRhs(){
		return rhs;
	}
	public void setRhs(List<Rh> rh) {
		this.rhs = rh;
	}
	public Rh getRh() {
		return rh;
	}
	public void setRh(Rh rh) {
		this.rh = rh;
	}
	public String salvar() {
		rhDAO.incluir(this.rh);
		return "funcionairos";
	}
	public String alterarSalvar() {
		if (this.rh.getIdRh() == null) 
			this.salvar();
		else 
			this.alterar();
		return "funcionarios";
	}
	public String excluir() {
		rhDAO.excluir(this.rh);
		return "funcionarios";
	}
	public String alterar() {
		rhDAO.alterar(this.rh);
		return "funcionarios";
	}
	public String  consultar() {
	//	rhDAO.consultar(serialVersionUID);
		return "funcionarios";
	}
	public String  gerenciar(Funcionario funcionario) {
		this.rh.setFuncionario(funcionario);
		Rh gerenciar = rhDAO.consultarPorFuncionario(funcionario);
		if(gerenciar != null)
			this.rh = gerenciar; 
		System.out.println("Alterei esse arquivo");
		return "gerenciar";
	}
		
	
}
