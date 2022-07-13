package application;

public class Internacional extends Agencia {

	protected String pais;

	public Internacional(String nome_do_gerente, String CNPJ, String email, Endereco endereco, String pais) {
		super(nome_do_gerente, CNPJ, email, endereco);
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
