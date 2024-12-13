package br.com.gerenciamento.model;

public class Produto {
	
	private String cor;
    private String modelo;
    private int ano;
    private String cilindrada;
    private String marca;
    private int quantidade;
    private double preco;
    private String imagem;


	    private int id;
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public int getAno() {
			return ano;
		}
		public void setAno(int ano) {
			this.ano = ano;
		}
		public String getCilindrada() {
			return cilindrada;
		}
		public void setCilindrada(String cilindrada) {
			this.cilindrada = cilindrada;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		public String getImagem() {
			return imagem;
		}
		public void setImagem(String imagem) {
			this.imagem = imagem;
		}
		
		// Construtor padrão
	    public Produto() {
	    }

	    // Construtor com todos os atributos
	    public Produto(int id, String cor, String modelo, int ano, String cilindrada, String marca, int quantidade, double preco, String imagem) {
	        this.id = id;
	        this.cor = cor;
	        this.modelo = modelo;
	        this.ano = ano;
	        this.cilindrada = cilindrada;
	        this.marca = marca;
	        this.quantidade = quantidade;
	        this.preco = preco;
	        this.imagem = imagem;
	    }

}



	   
	

