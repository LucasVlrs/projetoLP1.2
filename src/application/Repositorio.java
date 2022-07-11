package application;

import java.util.ArrayList;

public class Repositorio {

	ArrayList<Agencia> listaAgencia;

	public Repositorio() {
		listaAgencia = new ArrayList<Agencia>();

	}

	public void adicionar(Agencia agencia) {
		if (agencia != null)
			listaAgencia.add(agencia);
	}

	public ArrayList<Agencia> getAgencias() {
		return listaAgencia;
	}

}
