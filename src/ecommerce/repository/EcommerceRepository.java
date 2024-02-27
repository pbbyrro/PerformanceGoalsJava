package ecommerce.repository;

import ecommerce.model.Produto;

public interface EcommerceRepository {

	//CRUD do Produto
	public void listarTodos();
	public void procurarPorID(int numero);
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int numero);
}
