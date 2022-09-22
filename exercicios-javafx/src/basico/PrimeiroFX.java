package basico;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimeiroFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button bA = new Button("A");
		Button bB = new Button("B");
		Button bC = new Button("C");
		
		bA.setOnAction(e -> System.out.println("Botão A" + e));
		bB.setOnAction(e -> System.out.println("Botão B" + e));
		bC.setOnAction(e -> System.exit(0));
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);//padding
		box.getChildren().add(bA);
		box.getChildren().add(bB);
		box.getChildren().add(bC);
		
		Scene unicaCena = new Scene(box, 100, 150);
		
		primaryStage.setScene(unicaCena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
