package ecommerce;

import ecommerce.model.Produto;
import ecommerce.model.Comida;
import ecommerce.model.Bebida;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opçao;
		
		//Teste da Classe Comida
		Comida c1 = new Comida(456, "Maçã", 5.0f, "Fruta");
		c1.visualizar();
		
		//Teste da Classe Bebida
		Bebida b1 = new Bebida(789, "Guaraná", 7.0f, "Refrigerante");
		b1.visualizar();
		
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
				
				keyPress();
				break;
			case 2:
				System.out.println("2 - Listar Produto por ID: ");
				
				keyPress();
				break;
			case 3:
				System.out.println("3 - Cadastrar Produto: ");
				
				keyPress();
				break;
			case 4:
				System.out.println("4 - Atualizar Produto: ");
				
				keyPress();
				break;
			case 5:
				System.out.println("5 - Deletar Produto: ");
				
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
