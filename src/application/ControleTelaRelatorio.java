package application;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
	private TableColumn<Agencia, String> colEndereco, colLogradouro, colNumero, colCEP;
	@FXML
	private TableColumn<Agencia, String> colEmail;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void ClicouPesquisar(ActionEvent event) {
		if(tfPesquisarAgencia.getText().equals("")) {
			preencherTabela(Main.repositorio.getAgencias());
		}else {
			ArrayList<Agencia> pesq = new ArrayList<>();
				for(Agencia a: Main.repositorio.getAgencias()) {
					if( a.getCNPJ().equals(tfPesquisarAgencia.getText()))
						pesq.add(a);
				}
				preencherTabela(pesq);
		}
	}

	@FXML
	protected void ClicouAtualizar(ActionEvent event) {
		preencherTabela(Main.repositorio.getAgencias());
	}

	private void preencherTabela(ArrayList<Agencia> armz) {
		ObservableList<Agencia> data = FXCollections.observableArrayList(armz);

		// exibir dados de objetos na tabela
		colGerente.setCellValueFactory(new PropertyValueFactory<>("nome_do_gerente"));
		colCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

		// exibir o endereco na tabela
		colLogradouro
				.setCellValueFactory(dado -> new SimpleStringProperty(dado.getValue().getEndereco().getLogradouro()));
		colNumero.setCellValueFactory(
				dado -> new SimpleStringProperty(String.valueOf(dado.getValue().getEndereco().getNumero())));
		colCEP.setCellValueFactory(dado -> new SimpleStringProperty(dado.getValue().getEndereco().getCEP()));

		tbAgencias.setItems(data);
	}

	public void ClicouTbAgencia(MouseEvent event) { // quando clica no item da tb, joga os comp para o tf
		int i = tbAgencias.getSelectionModel().getSelectedIndex();

		Agencia agencia = (Agencia) tbAgencias.getItems().get(i);

		txtCNPJ.setText(agencia.getCNPJ());
		txtGerente.setText(agencia.getNome_do_gerente());
		txtEmail.setText(agencia.getEmail());

		txtLogradouro.setText((agencia.endereco.getLogradouro()));
		txtNumero.setText(String.valueOf(agencia.endereco.getNumero()));
		txtCEP.setText((agencia.endereco.getCEP()));

	}

	public void ClicouAlterar(ActionEvent event) { // altera os valores do objeto em questão #nn pode mudar cnpj#

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

				System.out.println("Alterando itens...");

				break;
			}
	}

	public void ClicouRemover(ActionEvent event) { // remove objetos da tabela caso o usuario confirme a opcao

		String CNPJ = txtCNPJ.getText();

		for (int i = 0; i < Main.repositorio.getAgencias().size(); i++)
			if (CNPJ.equals(Main.repositorio.getAgencias().get(i).getCNPJ())) {

				// Adicionando confirmacao de exclusao
				Alert alertDelete1 = new Alert(Alert.AlertType.CONFIRMATION);
				alertDelete1.setTitle("Excluir Agência?");
				alertDelete1.setContentText("Você tem certeza que deseja Excluir?");

				// Capturando a resposta do Usuario
				Optional<ButtonType> result1 = alertDelete1.showAndWait();
				if (result1.get() == ButtonType.OK) {
					Main.repositorio.getAgencias().remove(i);
					System.out.println("Agencia de CNPJ: " + CNPJ + " removida");
					JOptionPane.showMessageDialog(null, "Agencia de CNPJ: " + CNPJ + " foi removida com Sucesso");
					Main.repositorio.getAgencias().remove(i);
				}

				else {
					JOptionPane.showMessageDialog(null, "Agencia de CNPJ: " + CNPJ + " não foi removida");
					break;
				}

			}
	}
}
