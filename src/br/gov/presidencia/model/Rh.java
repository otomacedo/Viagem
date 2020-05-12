package br.gov.presidencia.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Rh implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRh;
	
	private String orgaoOrigem;
	private Date possePr;
	private String matriculaSiape;
	private String matriculaPr;
	private boolean escala;
	
	public Rh() {}
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<Ferias> ferias;
	
	@OneToOne
	@JoinColumn(name="idFuncionario")
	private Funcionario funcionario;
	
	@OneToOne
	@JoinColumn(name="idDepartamento")
	private Departamento departamento;
	
	@OneToOne
	@JoinColumn(name="idSetor")
	private Setor setor; 
	
	@OneToOne
	@JoinColumn(name="idGratificacao")
	private Gratificacao gratificacao;
	
	@OneToOne
	@JoinColumn(name="idGraduacao")
	private Graduacao graduacao;
	
	@OneToOne
	@JoinColumn(name="idAtividade")
	private Atividade atividade;
	
	public Integer getIdRh() {
		return idRh;
	}
	public void setIdRh(Integer idRh) {
		this.idRh = idRh;
	}
	public String getOrgaoOrigem() {
		return orgaoOrigem;
	}
	public void setOrgaoOrigem(String orgaoOrigem) {
		this.orgaoOrigem = orgaoOrigem;
	}
	public Date getPossePr() {
		return possePr;
	}
	public void setPossePr(Date possePr) {
		this.possePr = possePr;
	}
	public String getMatriculaSiape() {
		return matriculaSiape;
	}
	public void setMatriculaSiape(String matriculaSiape) {
		this.matriculaSiape = matriculaSiape;
	}
	public String getMatriculaPr() {
		return matriculaPr;
	}
	public void setMatriculaPr(String matriculaPr) {
		this.matriculaPr = matriculaPr;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Ferias> getFerias() {
		return ferias;
	}
	public void setFerias(List<Ferias> ferias) {
		this.ferias = ferias;
	}

	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Gratificacao getGratificacao() {
		return gratificacao;
	}
	public void setGratificacao(Gratificacao gratificacao) {
		this.gratificacao = gratificacao;
	}
	public Graduacao getGraduacao() {
		return graduacao;
	}
	public void setGraduacao(Graduacao graduacao) {
		this.graduacao = graduacao;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public boolean isEscala() {
		return escala;
	}
	public void setEscala(boolean escala) {
		this.escala = escala;
	}
	
	
	
	
}
