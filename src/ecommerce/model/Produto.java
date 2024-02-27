package ecommerce.model;

public abstract class Produto {
	
	private int codigo;
	private String nome;
	private float preço;
	private String descriçao;
	private int tipo;
	
	public Produto(int codigo, String nome, float preço, String descriçao) {
		this.codigo = codigo;
		this.nome = nome;
		this.preço = preço;
		this.descriçao = descriçao;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreço() {
		return preço;
	}

	public void setPreço(float preço) {
		this.preço = preço;
	}

	public String getDescriçao() {
		return descriçao;
	}

	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}
	
	public void visualizar() {
		String tipo = "";
		
		switch (this.tipo) {
		case 1:
			tipo = "Comida";
			break;
		case 2:
			tipo = "Bebida";
			break;
		}
		
		System.out.println("******************************************");
		System.out.println("Dados do Produto:");
		System.out.println("******************************************");
		System.out.println("Código do produto: " + this.codigo);
		System.out.println("Nome do produto: " + this.nome);
		System.out.println("Preço do produto: " + this.preço);
		System.out.println("Descrição do produto: " + this.descriçao);
	}
}
