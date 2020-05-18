package graphics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class HelloWorld extends Application {
	private Stage mainStage;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	mainStage = primaryStage;
    	
    	mainStage.setTitle("MainStage");
    	
    	
    	BorderPane bPane = new BorderPane();
    	
        bPane.setTop(new TextField("Top")); 
        bPane.setBottom(new TextField("Bottom")); 
        bPane.setLeft(new TextField("Left")); 
        bPane.setRight(new TextField("Right")); 
        bPane.setCenter(new TextField("Center")); 


    	
    	Scene mainScene = new Scene(bPane, 800, 800);
    	
    	mainStage.setScene(mainScene);
    	mainStage.show();
    }
}
	