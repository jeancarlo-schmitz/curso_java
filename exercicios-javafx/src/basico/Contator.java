package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contator extends Application {

	private int contador = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {

		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("titulo");
		Label labelNumero = new Label(Integer.toString(contador));
		labelNumero.getStyleClass().add("numero");
		
		Button botaoIncremento = new Button("+");
		botaoIncremento.getStyleClass().add("botoes");
		this.adicionaAcaoBotaoIncremento(botaoIncremento, labelNumero);
		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botoes");
		this.adicionaAcaoBotaoDecremento(botaoDecremento, labelNumero);
		
		HBox boxBotoes = new HBox();
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxBotoes.getChildren().add(botaoDecremento);
		boxBotoes.getChildren().add(botaoIncremento);
		
		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.setSpacing(10);
		boxConteudo.getChildren().add(labelTitulo);		
		boxConteudo.getChildren().add(labelNumero);		
		boxConteudo.getChildren().add(boxBotoes);		
		
		String caminhoCss = getClass()
				.getResource("/basico/Contador.css").toExternalForm();
		Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
		cenaPrincipal.getStylesheets().add(caminhoCss);
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
		
		primaryStage.setScene(cenaPrincipal);
		
		primaryStage.show();
	}
	
	private void adicionaAcaoBotaoDecremento(Button botaoDecremento, Label labelNumero) {
		botaoDecremento.setOnAction(e -> {
			contador--;
			this.aplicaEstiloLabelNumero(labelNumero);
			labelNumero.setText(Integer.toString(contador));
		});
		
	}

	private void adicionaAcaoBotaoIncremento(Button botaoIncremento, Label labelNumero) {
		botaoIncremento.setOnAction(e -> {
			contador++;
			this.aplicaEstiloLabelNumero(labelNumero);
			labelNumero.setText(Integer.toString(contador));
		});
	}

	private void aplicaEstiloLabelNumero(Label labelNumero) {
		this.removeCores(labelNumero);
		if(contador > 0) {
			labelNumero.getStyleClass().add("verde");
		}else if(contador < 0) {
			labelNumero.getStyleClass().add("vermelha");
		}
	}
	
	private void removeCores(Label labelNumero) {
		labelNumero.getStyleClass().remove("verde");
		labelNumero.getStyleClass().remove("branco");
		labelNumero.getStyleClass().remove("vermelha");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
