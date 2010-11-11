package br.com.furb.engenhariasoftware.conceptproof.videostore.model;

public abstract class Veiculo {
	private Integer numeroChassi;
	private String numeroPlaca;
	private String fabricante;
	private String modelo;
	private Integer anoFabricacao;
	private String cor;

	public Veiculo(Integer numeroChassi, String numeroPlaca, String fabricante, String modelo, Integer anoFabricacao, String cor){
		this.numeroChassi = numeroChassi;
		this.numeroPlaca = numeroPlaca;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
	}

	public Integer getNumeroChassi() {
		return numeroChassi;
	}

	public void setNumeroChassi(Integer numeroChassi) {
		this.numeroChassi = numeroChassi;
	}

	public String getNumeroPlaca() {
		return numeroPlaca;
	}

	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
