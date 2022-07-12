package application;

public class Endereco {
	protected String logradouro, CEP;
	protected int numero;

	public Endereco(String logradouro, int numero, String CEP) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.CEP = CEP;

	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
