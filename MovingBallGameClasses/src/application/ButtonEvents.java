package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonEvents {

//	public static void start(Stage stage, Button button){
//        button.setOnAction(new EventHandler<ActionEvent>() {
//  			@Override
//  			public void handle(ActionEvent event) {
//  				new GamePlayScreen(stage);				
//  			}
//  		});
//	}
	
	public static void beenden(Stage stage, Button button){
        button.setOnAction(new EventHandler<ActionEvent>() {
  			@Override
  			public void handle(ActionEvent event) {
  				Platform.exit();				
  			}
  		});
	}
	
	public static void back(Stage stage, Button button){
        button.setOnAction(new EventHandler<ActionEvent>() {
  			@Override
  			public void handle(ActionEvent event) {
  				new StartScreen(stage);				
  			}
  		});
	}
	
}
