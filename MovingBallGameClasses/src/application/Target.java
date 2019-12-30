package application;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Target extends Circle{

	// Variablen
	private Circle ball;	
	private Timeline timeline;	
	private static double speed;
	private Stage stage;
	
	private long timeStart;
	private static long timePassed;
	
	// zählt Anzahl der geklickten Targets
	private static int nrOfTargetsHit;  
		
	
	// Konstruktor
	public Target(Stage stage) {
		
		speed = 1.2 + Math.random();
		int y = 50 + (int) (Math.random() * 170);	
		int radius = 20 + (int) (Math.random() * 33);
		
		this.stage = stage;
		this.setRadius(radius);
		this.setFill(Color.RED);
		this.relocate(0, y);
	}
		
	// Methoden
    public void startTimeline(Scene scene, Target ball) {
    	
    	KeyValue keyValue = new KeyValue(ball.layoutXProperty(), scene.getWidth() - ball.getRadius());      
    	KeyFrame keyFrame = new KeyFrame(Duration.seconds(speed), keyValue);
    	timeline = new Timeline(keyFrame);
      
    	timeline.setCycleCount(11);
    	timeline.setAutoReverse(true);
    	timeline.play();
    	
    	timeStart = System.currentTimeMillis();
    	clickEvent(stage, ball);
    }
	
    public void clickEvent(Stage stage, Circle ball) {
    	
    	ball.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {					
				nrOfTargetsHit++;
				ball.setVisible(false);
				timeline.stop();
				if(nrOfTargetsHit == 3) {
					final long timeEnd = System.currentTimeMillis();
					timePassed = timeEnd - timeStart;
					new GameOverScreen(stage);
					nrOfTargetsHit = 0;
				}	    	
			}
		});
    }

	public static long getTimePassed() {
		return timePassed;
	}

	public static double getSpeed() {
		return speed;
	}

	public static void setSpeed(double speed) {
		Target.speed = speed;
	}
	
}
