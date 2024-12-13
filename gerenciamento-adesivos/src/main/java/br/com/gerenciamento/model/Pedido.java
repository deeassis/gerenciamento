package br.com.gerenciamento.model;

public class Pedido {
	private String clienteNome;
    private int quantidade;
    private String dataPedido;
    private String previsaoEntrega;
    private String endereco;
    private int referenciaModelo;
    
	private int id;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getPrevisaoEntrega() {
		return previsaoEntrega;
	}
	public void setPrevisaoEntrega(String previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getReferenciaModelo() {
		return referenciaModelo;
	}
	public void setReferenciaModelo(int referenciaModelo) {
		this.referenciaModelo = referenciaModelo;
	}
	// Construtor padrão
    public Pedido() {
    }

    // Construtor com todos os atributos
    public Pedido(int id, String clienteNome, int quantidade, String dataPedido, String previsaoEntrega, String endereco, int referenciaModelo) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.quantidade = quantidade;
        this.dataPedido = dataPedido;
        this.previsaoEntrega = previsaoEntrega;
        this.endereco = endereco;
        this.referenciaModelo = referenciaModelo;
    }
}


