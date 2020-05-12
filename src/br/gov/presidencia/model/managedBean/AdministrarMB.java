package br.gov.presidencia.model.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.presidencia.model.Atividade;
import br.gov.presidencia.model.Graduacao;
import br.gov.presidencia.model.Gratificacao;
import br.gov.presidencia.model.Setor;
import br.gov.presidencia.model.dao.AtividadeDAO;
import br.gov.presidencia.model.dao.DepartamentoDAO;
import br.gov.presidencia.model.dao.GraduacaoDAO;
import br.gov.presidencia.model.dao.GratificacaoDAO;
import br.gov.presidencia.model.dao.SetorDAO;
import br.gov.presidencia.model.Departamento;

@ManagedBean (name="administrarMB")
@RequestScoped
public class AdministrarMB implements Serializable {
		
	private static final long serialVersionUID= 1L;
	
	private List<Atividade> atividades = new ArrayList<Atividade>();
	private Atividade atividade;
	private AtividadeDAO atividadeDAO;
	
	private List<Graduacao> graduacoes = new ArrayList<Graduacao>();
	private Graduacao graduacao;
	private GraduacaoDAO graduacaoDAO ;
	
	private List<Gratificacao> gratificacoes = new ArrayList<Gratificacao>();
	private Gratificacao gratificacao;
	private GratificacaoDAO gratificacaoDAO;
	
	private List<Departamento> departamentos = new ArrayList<Departamento>();
	private Departamento departamento;
	private DepartamentoDAO departamentoDAO;
	
	private List<Setor> setores = new ArrayList<Setor>();
	private Setor setor;
	private SetorDAO setorDAO;
	
	
	public AdministrarMB() {
		this.atividadeDAO = new AtividadeDAO();
		this.atividade = new Atividade();
		this.graduacaoDAO = new GraduacaoDAO();
		this.graduacao = new Graduacao();
		this.gratificacaoDAO = new GratificacaoDAO();
		this.gratificacao = new Gratificacao();
		this.departamentoDAO = new DepartamentoDAO();
		this.departamento = new Departamento();
		this.setorDAO = new SetorDAO();
		this.setor = new Setor();
		
		this.listarAtividades();
		this.listarGraduacoes();
		this.listarGratificacoes();
		this.listarDepartamentos();
		this.listarSertores();
		
	}
	
	public void listarAtividades() {
		atividades = atividadeDAO.listar();
	}
	
	public List<Atividade> getAtividades(){
		return atividades;
	}
	
	public void setAtividades(List<Atividade> atividade) {
		this.atividades=atividade;
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	
	public void setAtividade(Atividade atividade) {
		this.atividade=atividade;
	}
	public String salvarAtividade() {
		atividadeDAO.incluir(this.atividade);
		return "cadastro";
	}
	public String excluirAtividade(){
		atividadeDAO.excluir(this.atividade);
		return "cadastro";
	}
	public String alterarAtiviadade() {
		atividadeDAO.alterar(this.atividade);
		return "cadastro";
	}
	public String consultarAtividade() {
		atividadeDAO.consultar(serialVersionUID);
		return "cadastro";
	}
	
	
//	
//	
	public String listarGraduacoes() {
		graduacoes = graduacaoDAO.listar();
		return "graduacoes";
	}
	
	public List<Graduacao> getGraduacoes(){
		return graduacoes;
	}
	
	public void setGraduacoes(List<Graduacao> graduacao) {
		this.graduacoes=graduacao;
	}
	
	public Graduacao getGraduacao() {
		return graduacao;
	}
	
	public void setGraduacao(Graduacao graduacao) {
		this.graduacao=graduacao;
	}
	public String salvarGraduacao() {
		graduacaoDAO.incluir(this.graduacao);
		return "cadastro";
	}
	public String excluirGraduacao() {
		graduacaoDAO.excluir(this.graduacao);
		return "cadastro";
	}
	public String alterarGraduacao() {
		graduacaoDAO.alterar(this.graduacao);
		return "cadastro";
	}
	public String consultarGraduacao() {
		graduacaoDAO.consultar(serialVersionUID);
		return "cadastro";
	}
	
//
//	
	
	public String listarGratificacoes() {
		gratificacoes = gratificacaoDAO.listar();
		return "gratificacoes";
	}
	
	public List<Gratificacao> getGratificacoes(){
		return gratificacoes;
	}
	
	public void setGratificacoes(List<Gratificacao> gratificacao) {
		this.gratificacoes=gratificacao;
	}
	
	public Gratificacao getGratificacao() {
		return gratificacao;
	}
	
	public void setGratificacao(Gratificacao gratificacao) {
		this.gratificacao=gratificacao;
	}
	public String salvarGratificacao() {
		gratificacaoDAO.incluir(this.gratificacao);
		return "cadastro";
	}
	public String excluirGratificacao() {
		gratificacaoDAO.excluir(this.gratificacao);
		return "cadastro";
	}
	public String alterarGratificacao() {
		gratificacaoDAO.alterar(this.gratificacao);
		return "cadastro";
	}
	public String consultarGratificacao() {
		gratificacaoDAO.consultar(serialVersionUID);
		return "cadastro";
	}
//
//
	
	public String listarDepartamentos() {
		departamentos = departamentoDAO.listar();
		return "departamentos";
	}
	
	public List<Departamento> getDepartamentos(){
		return departamentos;
	}
	
	public void setDepartamentos(List<Departamento> departamento) {
		this.departamentos=departamento;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento (Departamento departamento) {
		this.departamento=departamento;
	}
	public String salvarDepartamento() {
		departamentoDAO.incluir(this.departamento);
		return "cadastro";
	}
	public String excluirDepartamento(){
		departamentoDAO.excluir(this.departamento);
		return "cadastro";
	}
	public String alterarDepartamento() {
		departamentoDAO.alterar(this.departamento);
		return "cadastro";
	}
	public String consultarDepartamento() {
		departamentoDAO.consultar(serialVersionUID);
		return "cadastro";
	}
	
//
	

	public String listarSertores() {
		setores = setorDAO.listar();
		return "setores";
	}
	
	public List<Setor> getSetores(){
		return setores ;
	}
	
	public void setSetores(List<Setor> setor) {
		this.setores= setor;
	}
	
	public Setor getSetor() {
		return setor;
	}
	
	public void setSetor(Setor setor) {
		this.setor= setor;
	}
	public String salvarSetor() {
		setorDAO.incluir(this.setor);
		return "cadastro";
	}
	public String excluirSetor(){
		setorDAO.excluir(this.setor);
		return "cadastro";
	}
	public String alterarSetor() {
		setorDAO.alterar(this.setor);
		return "cadastro";
	}
	public String consultarSetor() {
		setorDAO.consultar(serialVersionUID);
		return "cadastro";
	
}
}
