package com.fatec.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import java.io.Serializable;

import com.fatec.dao.ProdutosDAO;
import com.fatec.domain.Produto;

@Named("MBProduto")
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	private ProdutosDAO produtosDAO;

	@PostConstruct
	public void iniciar() {
		produtosDAO = new ProdutosDAO();
		produto = new Produto();
		produtos = produtosDAO.listar();
	}

	public void salvar() {
		produtosDAO.salvar(produto);
		System.out.println("Produto salvo com sucesso! " + produto.getDesricao());
		mostraMensagem("Sucesso!!", "Produto inserido: " + produto.getDesricao());
		produto = new Produto();
		produtos = produtosDAO.listar();

	}

	public void deletar() {
		produtosDAO.deletar(produto.getId());
		produtos = produtosDAO.listar();
		mostraMensagem("Sucesso!!", "Produto removido: " + produto.getDesricao());
	}

	public void editar() {
		produtosDAO.editar(produto);
		produtos = produtosDAO.listar();
		mostraMensagem("Sucesso!!", "Produto editado: " + produto.getDesricao());
	}

	public void capturaProduto(ActionEvent e) {
		produto = (Produto) e.getComponent().getAttributes().get("prodSelecionado");
	}

	private void mostraMensagem(String titulo, String detalhe) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, detalhe));
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}
}
