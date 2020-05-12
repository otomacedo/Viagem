package br.gov.presidencia.model.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.presidencia.model.Funcionario;
import br.gov.presidencia.model.dao.FuncionarioDAO;

@ManagedBean(name="funcionarioMB")
@RequestScoped
public class FuncionarioMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private Funcionario funcionario;
	
	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioMB() {
		this.funcionario = new Funcionario();
		this.funcionarioDAO = new FuncionarioDAO();
		funcionarios = funcionarioDAO.listar();
	}
	
	public String listarFuncionarios() {
		 funcionarioDAO.listar();
		return "funcionarios";
	}
	
	public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}
	
	public void setFuncionarios(List<Funcionario> funcionario) {
		this.funcionarios= funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String alterarSalvar(){
		if(this.funcionario.getIdFuncionario() == null ) {
			return this.salvar();
			}
		else
			return this.alterar();
}

	
	public String editarFuncionario(Funcionario funcionario){
     this.funcionario = funcionario;
     return "cadastroFuncionario";
	}
	
	public String salvar() {
		funcionarioDAO.incluir(this.funcionario);
		return "cadastro";
	}
	public String alterar() {
		funcionarioDAO.alterar(this.funcionario);
		return "cadastro";
	}
	public String excluir(Funcionario funcionario) {
		funcionarioDAO.excluir(funcionario);
		return "funcionarios";
	}
	public String consultar() {
		
		return "cadastro";
	}
	
	
}