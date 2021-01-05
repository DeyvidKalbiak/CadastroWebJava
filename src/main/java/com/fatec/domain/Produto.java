package com.fatec.domain;

import javax.persistence.Entity;


@Entity
public class Produto extends GenericDomain{

	
	private static final long serialVersionUID = 1L;

	private String codBarras;

	private String Desricao;

	private Double valor;

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getDesricao() {
		return Desricao;
	}

	public void setDesricao(String desricao) {
		Desricao = desricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
