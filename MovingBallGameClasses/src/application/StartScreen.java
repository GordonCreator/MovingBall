package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartScreen {
	
	Pane root = new Pane();
	Scene scene = new Scene(root, 300, 300);
	
	Button buttonStart = new Button("Start");
	Button buttonHighscore = new Button("Highscore");
	Button buttonEnde = new Button("Beenden");
	Button buttonOptions = new Button("Optionen");
	
	GamePlayScreen gamePlayScreen;
	
	public StartScreen(Stage stage) {
		
		buttonStart.relocate(50, 120);
		buttonHighscore.relocate(100, 120);
		buttonEnde.relocate(190, 120);   	
	    buttonOptions.relocate(200, 50);
	    
		root.getChildren().addAll(buttonStart, buttonHighscore, buttonEnde, buttonOptions);
		root.setStyle("-fx-background-color:blue");

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);	
		
		ButtonEvents.beenden(stage, buttonEnde);
		setButtonFunction(stage);
	}
	
	
	public void setButtonFunction(Stage stage) {
		
		

		
		buttonStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gamePlayScreen = new GamePlayScreen(stage);
			}
		});
		
	    buttonHighscore.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new HighscoreScreen(stage);
			}
		});
		
	    buttonOptions.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	
				new OptionsScreen(stage);
			}
		});
		
	}




}
