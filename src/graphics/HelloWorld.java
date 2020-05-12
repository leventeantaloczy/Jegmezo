package graphics;

import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    	//------------Levente & Benedek ------ MainScene--------------Begin------------------------
    	BorderPane bPane = new BorderPane();
    	GridPane gridIceField = new GridPane();
    	gridIceField.setPrefSize(800, 800);
    	gridIceField.setMinSize(800, 800);
    	gridIceField.setGridLinesVisible(true);
    	
    	////-----------------------------------------IceField & Fields------------------------
    	for (int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		GridPane gridField = new GridPane();
        		gridField.setMinSize(88.8, 88.8);
        		gridField.setMaxSize(88.8, 88.8);
        		
        		//inside Fields
        		for(int k = 0; k < 3; k++) {
        			for(int l = 0; l < 3; l++) {
        				TextField halo = new TextField("heyho");
        				halo.setMinSize(29, 29);
        				gridField.setGridLinesVisible(false);
        				gridField.add(halo, k, l);
        			}
        		}
        		
        		
        		gridIceField.add(gridField, i, j);
        	}
		}
    	
    	////-----------------------------------------IceField & Fields-END-----------------------
    	////------------------------------------------------UI-BEGIN-------------------------------
    	VBox uiElements = new VBox(8);
    	
    	//Avatars list
    	VBox avatarsList = new VBox(1);
    	avatarsList.setMaxSize(350, 200);
    	avatarsList.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #ddf4fe, #98dffb);");
    	
    	//AvatarRows
    	for (int i = 0; i < 6; i++) {
    		HBox avatarRow = new HBox();
        	avatarRow.setMinSize(350, 33.3);
        	avatarRow.setSpacing(40);
        	avatarRow.setAlignment(Pos.CENTER_LEFT);
        	Image placeHolderImageAvatar = new Image(getClass().getClassLoader().getResourceAsStream("resources/placeholder.png"), 30, 30, false, false);
        	Label avatarName = new Label("Not Playing :(");
        	avatarName.setFont(new Font(18));
        	avatarName.setMinSize(150, 33.3);
        	Label avatarLife = new Label("0");
        	avatarLife.setFont(new Font(18));
        	avatarRow.getChildren().add(new ImageView(placeHolderImageAvatar));
        	avatarRow.getChildren().add(avatarName);
        	avatarRow.getChildren().add(avatarLife);
        	
        	avatarsList.getChildren().add(avatarRow);
		}
    	
    	//Avatar's things
    	setLife(avatarsList,0,4);
    	setName(avatarsList,0,"Benedek");
    	setLife(avatarsList,1,5);
    	setName(avatarsList,1,"Levente");
    	setLife(avatarsList,2,4);
    	setName(avatarsList,2,"Zoltán");
    	setLife(avatarsList,3,3);
    	setName(avatarsList,3,"Tivadar");
    	setLife(avatarsList,4,2);
    	setName(avatarsList,4,"Hanga");
    	setLife(avatarsList,5,2);
    	setName(avatarsList,5,"Hagymakarika");
    	
    	activateAvatar(avatarsList, 2);
    	
    	Pane uiRoot = new Pane();
    	    	
    	Button use = new Button();
    	use.setText("Use");
    	use.setLayoutX(212);
    	use.setLayoutY(130);
    	use.setStyle("-fx-background-radius: 10em; " +
                "-fx-min-width: 55px; " +
                "-fx-min-height: 55px; " +
                "-fx-max-width: 55px; " +
                "-fx-max-height: 55px;" + 
                "-fx-background-color: #99FF9D");
    	
    	Button sUse = new Button();
    	sUse.setText("S Use");
    	sUse.setLayoutX(257);
    	sUse.setLayoutY(196);
    	sUse.setStyle("-fx-background-radius: 10em; " +
                "-fx-min-width: 55px; " +
                "-fx-min-height: 55px; " +
                "-fx-max-width: 55px; " +
                "-fx-max-height: 55px;" + 
                "-fx-background-color: #C5B7FF");
    	
    	Button pickUp = new Button();
    	pickUp.setText("Pick Up");
    	pickUp.setLayoutX(216);
    	pickUp.setLayoutY(260);
    	pickUp.setStyle("-fx-background-radius: 10em; " +
                "-fx-min-width: 55px; " +
                "-fx-min-height: 55px; " +
                "-fx-max-width: 55px; " +
                "-fx-max-height: 55px;" + 
                "-fx-background-color: #FFB6B6");
    	
    	Button up = new Button();
    	up.setPrefSize(60, 60);
    	up.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	up.setLayoutX(60);
    	up.setLayoutY(130);
    	
    	Button right = new Button();
    	right.setPrefSize(60, 60);
    	right.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	right.setLayoutX(120);
    	right.setLayoutY(190);
    	right.setRotate(90);
    	
    	Button down = new Button();
    	down.setPrefSize(60, 60);
    	down.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	down.setLayoutX(60);
    	down.setLayoutY(250);
    	down.setRotate(180);
    	
    	Button left = new Button();
    	left.setPrefSize(60, 60);
    	left.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	left.setLayoutX(0);
    	left.setLayoutY(190);
    	left.setRotate(270);
    	
    	uiRoot.getChildren().add(use);
    	uiRoot.getChildren().add(sUse);
    	uiRoot.getChildren().add(pickUp);
    	uiRoot.getChildren().add(up);
    	uiRoot.getChildren().add(right);
    	uiRoot.getChildren().add(down);
    	uiRoot.getChildren().add(left);

    	
    	//Addig elements to UI
    	uiElements.getChildren().add(avatarsList);
    	uiElements.getChildren().add(uiRoot);
    	
    	
    	////------------------------------------------------UI-END-------------------------------
    	
        //bPane.setTop(new TextField("Top")); 
        //bPane.setBottom(new TextField("Bottom")); 
        bPane.setLeft(gridIceField); 
        bPane.setRight(uiElements); 
        //bPane.setCenter(new TextField("Center")); 

    	Scene mainScene = new Scene(bPane, 1200, 800);
    	//------------Levente & Benedek ------ MainScene--------------End------------------------
    	
    	mainStage.setScene(mainScene);
    	mainStage.show();
    }
    
    //Menu scene method
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
    
    //returns a field in the IceField
    private GridPane getCell(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return (GridPane)node;
            }
        }
        return null;
    }
    
    //TODO: Sets the last grid cell of the field (??)help
    public void setSnowOnField(GridPane gridPane, int snow, int col, int row) {
    	GridPane field = getCell(gridPane,col,row);
    	//TODO: Set snow LabelText in Fields last cell
    }
    
    //Sets the remaning life of avatar at the avatarlist index
    public void setLife(VBox avatarlist, int index, int life) {
    	HBox avatarRow = (HBox)avatarlist.getChildren().get(index);
    	Label lifeofAvatar = (Label)avatarRow.getChildren().get(2);
    	lifeofAvatar.setText(Integer.toString(life));
    }
    
    //Sets the name of avatar in the avatar list
    public void setName(VBox avatarlist, int index, String name) {
    	HBox avatarRow = (HBox)avatarlist.getChildren().get(index);
    	Label nameofAvatar = (Label)avatarRow.getChildren().get(1);
    	nameofAvatar.setText(name);
    }
    
    //Fills the active avatars name with red color 
    public void activateAvatar(VBox avatarlist, int index) {
    	HBox avatarRow = (HBox)avatarlist.getChildren().get(index);
    	Label nameofAvatar = (Label)avatarRow.getChildren().get(1);
    	//nameofAvatar.setFont(new Font("Arial Rounded MT Bold", 18));
    	nameofAvatar.setTextFill(Color.RED);
    }
    
    //Fills the deactivated avatars name with black
    public void deactivateAvatar(VBox avatarlist, int index) {
    	HBox avatarRow = (HBox)avatarlist.getChildren().get(index);
    	Label nameofAvatar = (Label)avatarRow.getChildren().get(1);
    	//nameofAvatar.setFont(new Font("Arial Rounded MT Bold", 18));
    	nameofAvatar.setTextFill(Color.BLACK);
    }
}
	