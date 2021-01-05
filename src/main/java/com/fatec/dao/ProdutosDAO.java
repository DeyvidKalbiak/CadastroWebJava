package com.fatec.dao;

import com.fatec.domain.Produto;

public class ProdutosDAO extends GenericDAO<Produto>{

	private static final long serialVersionUID = 1L;

	public ProdutosDAO() {
		super(Produto.class);
		
	}
	
}
