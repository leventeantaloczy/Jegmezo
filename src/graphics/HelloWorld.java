package graphics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
    	Text text1 = new Text("asd"); 
    	Text text2 = new Text("asd"); 
    	
    	BorderPane bPane = new BorderPane();
    	GridPane fieldPane = new GridPane(); 
    	fieldPane.setMinSize(800, 800);
       // fieldPane.setVgap(5); 
        //fieldPane.setHgap(5); 
    	//for
    	
    	fieldPane.add(text1, 0, 0); 
    	fieldPane.add(text1, 1, 0);
    	//fieldPane.add(text1, 0, 1);
    	//fieldPane.add(text1, 1, 1); 
        //bPane.setTop(new TextField("Top")); 
        //bPane.setBottom(new TextField("Bottom")); 
        bPane.setLeft(fieldPane); 
        //bPane.setRight(new TextField("Right")); 
        //bPane.setCenter(new TextField("Center")); 


    	
    	Scene mainScene = new Scene(bPane, 1200, 800);
    	
    	mainStage.setScene(mainScene);
    	mainStage.show();
    	
    }
}
	