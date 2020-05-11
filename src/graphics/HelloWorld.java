package graphics;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
 
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
    
    public Scene MenuScene() {
    	VBox menuItems = new VBox();
    	menuItems.prefWidth(1200);
    	menuItems.prefHeight(800);
    	menuItems.setAlignment(Pos.CENTER);
    	menuItems.setSpacing(100);
    	
    	Label letsplay = new Label("How many players?");
       	letsplay.setFont(new Font("Arial Rounded MT Bold",50));
       	
       	TextField numPlayers = new TextField("3");
       	numPlayers.setMaxWidth(100);
       	numPlayers.setMinHeight(70);
       	numPlayers.setFont(new Font(44));
       	UnaryOperator<Change> integerFilter = change -> {
       	    String newText = change.getControlNewText();
       	    if (newText.matches("-?([1-9][0-9]*)?")) { 
       	        return change;
       	    }
       	    return null;
       	};

       	numPlayers.setTextFormatter(new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
       	
       	Button startGame = new Button("Start Game");
       	startGame.setMinWidth(150);
       	startGame.setMinHeight(70);
       	startGame.setFont(new Font("Arial Rounded MT Bold",30));
       	startGame.setOnAction(new EventHandler<ActionEvent>() {
       	    @Override public void handle(ActionEvent e) {
       	        if(Integer.parseInt(numPlayers.getText()) > 6 || Integer.parseInt(numPlayers.getText()) < 3) {
       	        	final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(mainStage);
                    VBox dialogVbox = new VBox(20);
                    
                    Button closeButton = new Button("Close");
                    closeButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent e) {
                            dialog.hide();
                        }
                    });
                    dialogVbox.getChildren().addAll(new Text("Enter a valid number please! (3-6)"),closeButton);
                    dialogVbox.setAlignment(Pos.CENTER);
                    
                    Scene dialogScene = new Scene(dialogVbox, 250, 100);
                    dialog.setTitle("Error :(");
                    dialog.setScene(dialogScene);
                    dialog.show();
       	        } else {
           	      //TODO: START GAME
       	        }
       	    }
       	});
       	
    	menuItems.getChildren().addAll(letsplay, numPlayers, startGame);
    	String style = "-fx-background-color: linear-gradient(#24fffb, #ffebeb);";   	
    	//String style = "-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");";   	

    	menuItems.setStyle(style);
    	
		Scene menuScene = new Scene(menuItems,1200,800);
		//menuScene.setFill(pattern);
    	
    	return menuScene;
    }
}
	