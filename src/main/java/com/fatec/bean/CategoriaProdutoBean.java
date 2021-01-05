package com.fatec.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.fatec.dao.CategoriaProdutoDAO;
import com.fatec.domain.CategoriaProduto;

import java.io.Serializable;
import java.util.List;

@Named("CatProdBean")
@ViewScoped
public class CategoriaProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CategoriaProduto categoriaProduto;
	private List<CategoriaProduto> categorias;
	private List<CategoriaProduto> categoriaFiltradas;
	private CategoriaProdutoDAO catProdDAO;
	
	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}
	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	/**
	 * @return the categorias
	 */
	public List<CategoriaProduto> getCategorias() {
		return categorias;
	}
	/**
	 * @return the catProdDAO
	 */
	public CategoriaProdutoDAO getCatProdDAO() {
		return catProdDAO;
	}
	
	
	
	
	
}
