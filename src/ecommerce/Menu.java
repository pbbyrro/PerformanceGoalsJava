package ecommerce;

import ecommerce.model.Produto;
import ecommerce.model.Comida;
import ecommerce.controller.EcommerceController;
import ecommerce.model.Bebida;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		EcommerceController produtos = new EcommerceController();
		
		Scanner leia = new Scanner(System.in);
		
		int opçao, codigo, tipo;
		String nome, descriçao;
		float preço;
		
		System.out.println("\nCriar Produtos\n");
		
		Comida c1 = new Comida(produtos.gerarCodigo(), "Alface", 2.0f, "Verdura");
		
		Comida c2 = new Comida(produtos.gerarCodigo(), "Maçã", 3.0f, "Fruta");
		
		Bebida b1 = new Bebida(produtos.gerarCodigo(), "Coca-cola", 10.0f, "Refrigerante");
		
		Bebida b2 = new Bebida(produtos.gerarCodigo(), "Sprite", 9.0f, "Refrigerante");
		
		while (true) {
			
			System.out.println("******************************************");
			System.out.println("                                          ");
			System.out.println("           QUITANDA DA PATUCA             ");
			System.out.println("                                          ");
			System.out.println("******************************************");
			System.out.println("                                          ");
			System.out.println("       1 - Listar Todos os Produtos       ");
			System.out.println("       2 - Listar Produto por ID          ");
			System.out.println("       3 - Cadastrar Produto              ");
			System.out.println("       4 - Atualizar Produto              ");
			System.out.println("       5 - Deletar Produto                ");
			System.out.println("                                          ");
			System.out.println("******************************************");
			System.out.println("                                          ");
			System.out.println("       Entre com a opção desejada:        ");
			System.out.println("                                          ");
			
			try {
				opçao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opçao = 0;
			}
			
			switch (opçao) {
			case 1:
				System.out.println("1 - Listar Todos os Produtos: ");
				produtos.listarTodos();
				
				keyPress();
				break;
			case 2:
				System.out.println("2 - Listar Produto por ID: ");
				
				System.out.println("Digite o código do produto:");
				codigo = leia.nextInt();
				
				produtos.procurarPorID(codigo);
				
				keyPress();
				break;
			case 3:
				System.out.println("3 - Cadastrar Produto: ");
				
				System.out.println("Digite o código do produto: ");
				codigo = leia.nextInt();
				
				System.out.println("Digite o nome do produto: ");
				leia.skip("\\R?");
				nome = leia.nextLine();
				
				System.out.println("Digite o preço do produto (R$): ");
				preço = leia.nextFloat();
				
				System.out.println("Digite a descrição do produto: ");
				descriçao = leia.nextLine();
				
				do { 
					System.out.println("Digite o tipo do produto (1 - Comida ou 2 - Bebida): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);
				
				switch (tipo) {
				case 1 -> {
					produtos.cadastrar(new Comida(produtos.gerarCodigo(), nome, preço, descriçao));
					break;
				}
				case 2 -> {
					produtos.cadastrar(new Bebida(produtos.gerarCodigo(), nome, preço, descriçao));
					break;
				}
				}
				
				keyPress();
				break;
			case 4:
				System.out.println("4 - Atualizar Produto: ");
				
				System.out.println("Digite o código do produto: ");
				codigo = leia.nextInt();
				
				var buscaProduto = produtos.buscarNaCollection(codigo);
				
				if(buscaProduto != null) {
					tipo = buscaProduto.getTipo();
					
					System.out.println("Digite o nome do produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					
					System.out.println("Digite o preço do produto (R$): ");
					preço = leia.nextFloat();
					
					System.out.println("Digite a descrição do produto: ");
					descriçao = leia.nextLine();
					
					switch(tipo) {
					case 1 -> {
						produtos.atualizar(new Comida(codigo, nome, preço, descriçao));
					}
					case 2 -> {
						produtos.atualizar(new Bebida(codigo, nome, preço, descriçao));
					}
					default -> {
						System.out.println("Tipo de produto inválido!");
					}
					}
				} else {
					System.out.println("O produto não foi encontrado!");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("5 - Deletar Produto: ");
				
				System.out.println("Digite o código do produto: ");
				codigo = leia.nextInt();
				
				produtos.deletar(codigo);
				
				keyPress();
				break;
			default:
				System.out.println("Opção inválida! Escolha um número de 1 a 5.");
				
				keyPress();
				break;
			}
			
			
		}
	}
	
	public static void keyPress() {
		
		try {
			System.out.println("Pressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}
}
