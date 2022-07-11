package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ControleTelaAdicionar extends MenuBar implements Initializable {

	Repositorio repositorio = new Repositorio();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private TextField tfGerente, tfCNPJ, tfEmail, tfELogradouro, tfENumero, tfECEP;

	public void ClickedConfirmar(ActionEvent event) { // botão de criar objeto

		String nome_do_gerente = tfGerente.getText();
		String CNPJ = tfCNPJ.getText();
		String email = tfEmail.getText();

		String logradouro = tfELogradouro.getText();
		int numero = parseInt(tfENumero.getText());
		String CEP = tfECEP.getText();

		Nacional agencia = new Nacional(nome_do_gerente, CNPJ, email, new Endereco(logradouro, numero, CEP));

		Main.repositorio.adicionar(agencia);

		for (Agencia a : Main.repositorio.getAgencias())
			System.out.println(a.toString());

		Alert alertInserido = new Alert(Alert.AlertType.INFORMATION);
		alertInserido.setTitle("Cadastrado com sucesso");
		alertInserido.setContentText("Nova agencia cadastrada!");
		alertInserido.showAndWait();
			
		System.out.println("clicou botao adicionar");
		
	}

	private int parseInt(String text) {
		return 0;
	}

}

/*
 * */
