package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ControleTelaAdicionar extends MenuBar implements Initializable {

	Repositorio repositorio = new Repositorio();

	@FXML
	private CheckBox cbInternacional;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		tfPais.setDisable(true);
	}

	@FXML
	private TextField tfGerente, tfCNPJ, tfEmail, tfELogradouro, tfENumero, tfECEP;

	public void ClickedConfirmar(ActionEvent event) { // botão de criar objeto

		String nome_do_gerente = tfGerente.getText();
		String CNPJ = tfCNPJ.getText();
		String email = tfEmail.getText();

		String logradouro = tfELogradouro.getText();
		int numero = Integer.parseInt(tfENumero.getText());
		String CEP = tfECEP.getText();
//		String pais = tfPais.getText();
//
//		if (cbInternacional.isSelected()) {
//
//			Internacional agenciaI = new Internacional(nome_do_gerente, CNPJ, email, new Endereco(logradouro, numero, CEP), pais);
//
//			Main.repositorio.adicionar(agenciaI);

//		} else {
			
			Nacional agenciaN = new Nacional(nome_do_gerente, CNPJ, email, new Endereco(logradouro, numero, CEP));

			Main.repositorio.adicionar(agenciaN);
			
//		}
			for (Agencia a : Main.repositorio.getAgencias())
				System.out.println(a.toString());

		Alert alertInserido = new Alert(Alert.AlertType.INFORMATION);
		alertInserido.setTitle("Cadastrado com sucesso");
		alertInserido.setContentText("Nova agencia cadastrada!");
		alertInserido.showAndWait();
		
		//Limpando os campos
		tfGerente.setText("");
		tfCNPJ.setText("");
		tfEmail.setText("");
		tfELogradouro.setText("");
		tfENumero.setText("");
		tfECEP.setText("");
//		tfPais.setText("");

		System.out.println("clicou botao adicionar");

	}

//	@FXML
//	public void InternacionalCheckUncheck(ActionEvent e) {
//		if (cbInternacional.isSelected()) {
//			tfPais.setDisable(false);
//		} else {
//			tfPais.setDisable(true);
//		}
//	}

}