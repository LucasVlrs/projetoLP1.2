package application;

public abstract class Agencia {
		
	protected String nome_do_gerente;
	protected String CNPJ;
	protected String email;
	protected Endereco endereco;
	
	
	public Agencia(String nome_do_gerente, String CNPJ, String email, Endereco endereco) {
		this.nome_do_gerente = nome_do_gerente;
		this.CNPJ = CNPJ;
		this.email = email;
		this.endereco = endereco;
		
	}

	public String getNome_do_gerente() {
		return nome_do_gerente;
	}

	public void setNome_do_gerente(String nome_do_gerente) {
		this.nome_do_gerente = nome_do_gerente;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
