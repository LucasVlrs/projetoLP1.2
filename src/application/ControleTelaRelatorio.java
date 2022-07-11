package application;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ControleTelaRelatorio extends MenuBar implements Initializable {

	@FXML
	private TableView<Agencia> tbAgencias;
	@FXML
	private TextField tfPesquisarAgencia;
	@FXML
	private TextField txtCNPJ, txtGerente, txtEmail, txtLogradouro, txtNumero, txtCEP;
	@FXML
	private TableColumn<Agencia, String> colGerente;
	@FXML
	private TableColumn<Agencia, String> colCNPJ;
	@FXML
	private TableColumn<Agencia, Endereco> colEndereco, colLogradouro, colNumero, colCEP;
	@FXML
	private TableColumn<Agencia, String> colEmail;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	protected void ClicouPesquisar(ActionEvent event) {
		preencherTabela(Main.repositorio.getAgencias());
	}

	private void preencherTabela(ArrayList<Agencia> armz) {
		ObservableList<Agencia> data = FXCollections.observableArrayList(armz);

		colGerente.setCellValueFactory(new PropertyValueFactory<>("nome_do_gerente"));
		colCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		colLogradouro.setCellValueFactory(new PropertyValueFactory<>("logradouro"));
		colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		colCEP.setCellValueFactory(new PropertyValueFactory<>("CEP"));

		tbAgencias.setItems(data);
	}

	public void ClicouTbAgencia(MouseEvent event) {
		int i = tbAgencias.getSelectionModel().getSelectedIndex();

		Agencia agencia = (Agencia) tbAgencias.getItems().get(i);

		txtCNPJ.setText(agencia.getCNPJ());
		txtGerente.setText(agencia.getNome_do_gerente());
		txtEmail.setText(agencia.getEmail());

		txtLogradouro.setText(Endereco.valueOf(agencia.getEndereco()));
		txtNumero.setText(String.valueOf(agencia.getEndereco()));
		txtCEP.setText(Endereco.valueOf(agencia.getEndereco()));

	}

	public void ClicouAlterar(ActionEvent event) {

		String CNPJ = txtCNPJ.getText();
		String nome_do_gerente = txtGerente.getText();
		String email = txtEmail.getText();

		String logradouro = txtLogradouro.getText();
		int numero = Integer.parseInt(txtNumero.getText());
		String CEP = txtCEP.getText();

		for (int i = 0; i < Main.repositorio.getAgencias().size(); i++)
			if (CNPJ.equals(Main.repositorio.getAgencias().get(i).getCNPJ())) {

				Main.repositorio.getAgencias().get(i).setNome_do_gerente(nome_do_gerente);
				Main.repositorio.getAgencias().get(i).setEmail(email);
				Main.repositorio.getAgencias().get(i).getEndereco().setLogradouro(logradouro);
				Main.repositorio.getAgencias().get(i).getEndereco().setNumero(numero);
				Main.repositorio.getAgencias().get(i).getEndereco().setCEP(CEP);
				System.out.println("Alteração feita...");
				break;
			}
	}

	public void ClicouRemover(ActionEvent event) {
		String CNPJ = txtCNPJ.getText();
		for (int i = 0; i < Main.repositorio.getAgencias().size(); i++)
			if (CNPJ.equals(Main.repositorio.getAgencias().get(i).getCNPJ())) {
				Main.repositorio.getAgencias().remove(i);
				System.out.println("Agencia de CNPJ: " + CNPJ + " removida");
				break;
			}
	}

}
