package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuBar {
	@FXML
	protected void ClickAddPage(ActionEvent event) {
		Main.switchMudaTelas(1);
	
	}
	
	@FXML 
	protected void ClickRelatorioPage(ActionEvent event) {
		Main.switchMudaTelas(4);
	}
}
