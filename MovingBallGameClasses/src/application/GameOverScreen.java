package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOverScreen {

	private Pane root = new Pane();
	private Scene scene = new Scene(root, 300, 300);

	private long timePassed;
	private int mouseClicks;
    
    public GameOverScreen(Stage stage) {
    	  
    	Button buttonEnde = new Button("Beenden");
    	Button buttonBack = new Button("Zurück");
    	
        buttonEnde.relocate(235, 0);
        buttonBack.relocate(155, 0);

        Label labelTimePassed = new Label();
        Label labelStats = new Label();
        
        labelTimePassed.relocate(100, 100);

        timePassed = Target.getTimePassed();       
		labelTimePassed.setText(String.valueOf(timePassed) + " ms");
        labelTimePassed.setFont(Font.font(22));
        
        mouseClicks = GamePlayScreen.getTotalMouseClicks();
        labelStats.relocate(100, 150);
        labelStats.setFont(Font.font(17));
        
        // ****warum +1? -> checken*****
        labelStats.setText("Versuche: " + String.valueOf(mouseClicks + 1));
        // *****************************
        
        root.getChildren().addAll(labelTimePassed, labelStats, buttonEnde, buttonBack);
        root.setStyle("-fx-background-color:red");

        stage.setScene(scene);
        stage.show();
        
        GamePlayScreen.setTotalMouseClicks(0);
        
        editHighScoreTextFile();
        
        ButtonEvents.beenden(stage, buttonEnde);
        ButtonEvents.back(stage, buttonBack);
    }

    public void editHighScoreTextFile() {
    	
		try(FileWriter fw = new FileWriter("Highscore.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);)
			{
			bw.write(String.valueOf(timePassed));
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Error writing to file");
		}
    	
    }

}


