package application;

public class Nacional extends Agencia {

	public Nacional(String nome_do_gerente, String CNPJ, String email, Endereco endereco) {
		super(nome_do_gerente, CNPJ, email, endereco);

		this.nome_do_gerente = nome_do_gerente;
		this.CNPJ = CNPJ;
		this.email = email;
		this.endereco = endereco;
	}
}
