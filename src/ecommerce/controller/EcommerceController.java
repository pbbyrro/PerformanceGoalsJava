package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Produto;
import ecommerce.repository.EcommerceRepository;

public class EcommerceController implements EcommerceRepository {
	
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int codigo = 0;

	@Override
	public void listarTodos() {
		// TODO Auto-generated method stub
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void procurarPorID(int codigo) {
		// TODO Auto-generated method stub
		var produto = buscarNaCollection(codigo);
		
		if(produto != null) {
			produto.visualizar();
		} else
			System.out.println("O produto de código: " + codigo + " não foi encontrado!");
		
	}

	@Override
	public void cadastrar(Produto produto) {
		// TODO Auto-generated method stub
		listaProdutos.add(produto);
		System.out.println("O produto de código: " + produto.getCodigo() + " foi criado com sucesso!" );
		
	}

	@Override
	public void atualizar(Produto produto) {
		// TODO Auto-generated method stub
		var buscaProduto = buscarNaCollection(produto.getCodigo());
		
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("O produto de código: " + produto.getCodigo() + " foi atualizado com sucesso!");
		} else
			System.out.println("O produto de código: " + produto.getCodigo() + " não foi encontrado!");
		
	}

	@Override
	public void deletar(int codigo) {
		// TODO Auto-generated method stub
		var produto = buscarNaCollection(codigo);
		
		if(produto != null) {
			if(listaProdutos.remove(produto) == true) {
				System.out.println("O produto de código: " + codigo + " foi deletado com sucesso!");
			} else
				System.out.println("O produto de código: " + codigo + " não foi encontrado!");
		}
	}
	
	public int gerarCodigo() {
		return ++ codigo;
	}

	public Produto buscarNaCollection(int codigo) {
		for (var produto : listaProdutos) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}
}
