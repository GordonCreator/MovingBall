package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GamePlayScreen {

	private Pane root = new Pane();
	private Scene scene = new Scene(root, 300, 300);

	private Button buttonEnde = new Button("Beenden");
	// zählt Anzahl der Mausklicks (auch erfolglose)
	private static int totalMouseClicks;

    
    public GamePlayScreen(Stage stage) {
    	totalMouseClicks = 0;
    	buttonEnde.relocate(235, 0);
    	
    	
    	
    	
    	Target ball1 = new Target(stage);
    	Target ball2 = new Target(stage);
    	Target ball3 = new Target(stage);
 	
    	ball1.startTimeline(scene, ball1);   
    	ball2.startTimeline(scene, ball2);
    	ball3.startTimeline(scene, ball3);
    	
    	root.getChildren().addAll(buttonEnde, ball1, ball2, ball3);
    	root.setStyle("-fx-background-color:green");   	
    	
    	
    	stage.setScene(scene);
    	stage.show();
        
    	ButtonEvents.beenden(stage, buttonEnde);
    	   	
    	countNrOfClicks(stage);
    }

	

    
    public void countNrOfClicks(Stage stage) {
		root.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setTotalMouseClicks(getTotalMouseClicks() + 1);			
			}
		});
    }
    
    
	public Scene getScene() {
		return scene;
	}

	public static int getTotalMouseClicks() {
		return totalMouseClicks;
	}

	public static void setTotalMouseClicks(int totalMouseClicks) {
		GamePlayScreen.totalMouseClicks = totalMouseClicks;
	}
	


}
