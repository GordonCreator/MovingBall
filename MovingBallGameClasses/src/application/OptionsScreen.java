package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OptionsScreen {

	Pane root = new Pane();
    Scene scene = new Scene(root, 300, 300);
    
    Button buttonEnde = new Button("Beenden");
    Button buttonBack = new Button("Zurück");
    
    
    public OptionsScreen(Stage stage) {
    	
		buttonEnde.relocate(235, 0);
		buttonBack.relocate(155, 0);
		    
		Button buttonEasy = new Button("Leicht");
		Button buttonmedium = new Button("Mittel");
		Button buttonHard = new Button("Schwer");
		buttonEasy.relocate(85, 130);
		buttonHard.relocate(155, 130);
		buttonmedium.relocate(45, 130);
		
		Label label = new Label("Schwierigkeitsgrad");
		label.relocate(50, 100);
		label.setFont(Font.font(17));
		
		root.getChildren().addAll(label, buttonEnde, buttonBack, buttonEasy, buttonmedium, buttonHard);
		root.setStyle("-fx-background-color:yellow");
		
		stage.setScene(scene);
		stage.show();
		
		buttonEasyMode(stage, buttonEasy);
		buttonEasyMode(stage, buttonHard);
		
		ButtonEvents.beenden(stage, buttonEnde);
		ButtonEvents.back(stage, buttonBack);

    	
    }
    
 
    public void buttonEasyMode(Stage stage, Button button) {
	    button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Target.setSpeed(1.2 + Math.random());
				System.out.println("easy");				
			}
		});
    }
    
    public void buttonHardMode(Stage stage, Button button) {
	    button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Target.setSpeed(0.6 + Math.random());
				System.out.println("hard");					
			}
		}); 
    }
    
}
