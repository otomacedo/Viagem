package br.gov.presidencia.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Gratificacao implements Serializable {
	private static final long serialVersionUID=1L;
	public Gratificacao() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGratificacao;
	private String descricao;
	
	public Long getIdGratificacao() {
		return idGratificacao;
	}
	public void setIdGratificacao(Long idGratificacao) {
		this.idGratificacao = idGratificacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
