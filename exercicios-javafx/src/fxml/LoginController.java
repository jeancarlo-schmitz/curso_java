package fxml;


import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField emailField;

	@FXML
	private PasswordField passwordField;
	
	public void entrar() {
		boolean emailValido = emailField.getText().equals("teste@gmail.com");
		boolean senhaValida = passwordField.getText().equals("123456");
		
		if(emailValido && senhaValida) {
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.title("Login FXML")
				.text("Login Efetuado com Sucesso!!")
				.showInformation();
		}else {
			Notifications.create()
			.position(Pos.TOP_RIGHT)
			.title("Login FXML")
			.text("Usuário ou Senha Inválidos!")
			.showError();
		}
	}
}
