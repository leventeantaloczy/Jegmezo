package graphics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
    	mainStage.setResizable(false);
    	
    	//------------Tivadar-----------ItemSelectionList----------------Begin---------------------
    	
    	VBox itemSelectionLayout = new VBox();
    	Label placeHolderText = new Label("This is a placeholder");
    	Label placeHolderText2 = new Label("This is a placeholder2");
    	Image placeHolderImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/placeholder.png"), 100, 100, false, false);
    	HBox itemSelectionInside1 = new HBox();
    	itemSelectionInside1.setAlignment(Pos.CENTER_LEFT);
    	HBox itemSelectionInside2 = new HBox();
    	itemSelectionInside2.setAlignment(Pos.CENTER_LEFT);
    	itemSelectionInside1.getChildren().add(new ImageView(placeHolderImage));
    	itemSelectionInside1.getChildren().add(placeHolderText);
    	itemSelectionInside2.getChildren().add(new ImageView(placeHolderImage));
    	itemSelectionInside2.getChildren().add(placeHolderText2);
    	itemSelectionLayout.getChildren().add(itemSelectionInside1);
    	itemSelectionLayout.getChildren().add(itemSelectionInside2);
    	
    	Scene itemSelectionScene = new Scene(itemSelectionLayout, 800, 800);
    
    	//------------Tivadar-----------ItemSelectionList----------------End-----------------------
    	
    	BorderPane bPane = new BorderPane();
    	
        bPane.setTop(new TextField("Top")); 
        bPane.setBottom(new TextField("Bottom")); 
        bPane.setLeft(new TextField("Left")); 
        bPane.setRight(new TextField("Right")); 
        bPane.setCenter(new TextField("Center")); 


    	
    	Scene mainScene = new Scene(bPane, 800, 800);
    	
    	mainStage.setScene(itemSelectionScene);
    	mainStage.show();
    }
}