package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HighscoreScreen {

	private Pane root = new Pane();
	private Scene scene = new Scene(root, 300, 300);
    
	private Button buttonEnde = new Button("Beenden");
	private Button buttonBack = new Button("Zurück");
	
	private String zeitErster, zeitZweiter, zeitDritter;
    
	
    public HighscoreScreen(Stage stage) {
    	
        buttonEnde.relocate(235, 0);
        buttonBack.relocate(155, 0);

        Label label0 = new Label("Highscore");
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(label0, label1, label2, label3);
        vBox.relocate(100,100);
        
        label0.setFont(Font.font(25));
//        label1.relocate(100, 100);
        label1.setFont(Font.font(22));       
//        label2.relocate(100, 125);
        label2.setFont(Font.font(22));
//        label3.relocate(100, 150);
        label3.setFont(Font.font(22));
        
    	
        createHighScoreList();
        label1.setText("1.  " + zeitErster);
        label2.setText("2.  " + zeitZweiter);
        label3.setText("3.  " + zeitDritter);
        
      root.getChildren().addAll(vBox, buttonEnde, buttonBack);
//        root.getChildren().addAll(label1, label2, label3, buttonEnde, buttonBack);
        root.setStyle("-fx-background-color:grey");

        stage.setScene(scene);
        stage.show();
    	
        ButtonEvents.beenden(stage, buttonEnde);
        ButtonEvents.back(stage, buttonBack);
        
    }
    
    public void createHighScoreList() {
    	
        String fileName = "Highscore.txt";
//      String line = null;

      try {
          FileReader fr = new FileReader(fileName);
          BufferedReader br =  new BufferedReader(fr);
          
          

          String str;
          ArrayList<String> arrHighScore = new ArrayList<>();
          while ((str = br.readLine()) != null) {
          	arrHighScore.add(str);
          } 	
          	
          // Minimum bestimmen
          int min = 999999;
          int currentArrElement;
          for (int i = 0; i < arrHighScore.size(); i++){ 
        	  currentArrElement = Integer.parseInt(arrHighScore.get(i));
	        	try {	
	            	if (min > currentArrElement)
	            		min = Integer.parseInt(arrHighScore.get(i));
	        	} catch (Exception e){
	        		// Zeileneintrag ignorieren
	        	}
          }   
          
          // Zweitkleinstes bestimmen
          int min2 = 999999;
          for (int i = 0; i < arrHighScore.size(); i++){ 	
        	  currentArrElement = Integer.parseInt(arrHighScore.get(i));
	        	try {	
	        		if (min2 > currentArrElement && currentArrElement != min){
	            		min2 = Integer.parseInt(arrHighScore.get(i));
	            	}
	        	} catch (Exception e){
	        		// Zeileneintrag ignorieren
	        	}
          }  
          
          // Drittkleinstes bestimmen
          int min3 = 999999;
          for (int i = 0; i < arrHighScore.size(); i++){ 	
        	  currentArrElement = Integer.parseInt(arrHighScore.get(i));
	        	try {	
	        		if (min3 > currentArrElement && currentArrElement != min
	        				&& currentArrElement != min2){
	            		min3 = Integer.parseInt(arrHighScore.get(i));
	            	}
	        	} catch (Exception e){
	        		// Zeileneintrag ignorieren
	        	}
          } 
          
         
          

          br.close();  
          
          zeitErster = String.valueOf(min); 
          zeitZweiter = String.valueOf(min2); 
          zeitDritter = String.valueOf(min3); 
      }
      catch(FileNotFoundException ex) {
          System.out.println(
              "Unable to open file '" + 
              fileName + "'");                
      }
      catch(IOException ex) {
          System.out.println(
              "Error reading file '" 
              + fileName + "'");                  
      }
    }
	
}
