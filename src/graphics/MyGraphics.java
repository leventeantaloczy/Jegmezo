package graphics;

import java.io.IOException;
import java.nio.file.Paths;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
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
import jegmezo.Controller;
import jegmezo.Direction;
import jegmezo.GameArea;
 
public class MyGraphics extends Application {
	private Stage mainStage;
	private Controller control;
	private ImageView[][] viewmx = new ImageView[9][9];
	private String path = Paths.get("").toAbsolutePath().toString();
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void init() {
    	control = new Controller();
    	try {
			control.startGame(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public void start(Stage primaryStage) {
    	mainStage = primaryStage;
    	
    	mainStage.setTitle("MainStage");
    	mainStage.setResizable(false);
    	
    	
    	
    	
    	mainStage.setScene(MenuScene());
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
       	        	control.getGameArea().setNumberOfPlayers(Integer.parseInt(numPlayers.getText()));
       	        	control.getGameArea().init(control.getGameEnder(), true);
       	        	mainStage.setScene(MainScene());
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
    
    public Scene MainScene() {
    	
    	//------------Levente & Benedek ------ MainScene--------------Begin------------------------
    	BorderPane bPane = new BorderPane();
    	GridPane gridIceField = new GridPane();
    	gridIceField.setPrefSize(800, 800);
    	gridIceField.setMinSize(800, 800);
    	gridIceField.setGridLinesVisible(true);
    	//----------------Tivadar---------------------------------Begin------------------------
    	
    	Image IceField = new Image(getClass().getClassLoader().getResourceAsStream("resources/Ice.png"), 88.8, 88.8, false, false);
    	Image HoleField = new Image(getClass().getClassLoader().getResourceAsStream("resources/hole.png"), 88.8, 88.8, false, false);
    	Image Eskimo1  = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo1.png"), 29.6, 29.6, false, false);
    	Image Eskimo2 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo2.png"), 29.6, 29.6, false, false);
    	Image Eskimo3 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo3.png"), 29.6, 29.6, false, false);
    	Image Eskimo4 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo4.png"), 29.6, 29.6, false, false);
    	Image Eskimo5 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo5.png"), 29.6, 29.6, false, false);
    	Image Eskimo6 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo5.png"), 29.6, 29.6, false, false);
    	Image Researcher1 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher1.png"), 29.6, 29.6, false, false);
    	Image Researcher2 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher2.png"), 29.6, 29.6, false, false);
    	Image Researcher3 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher3.png"), 29.6, 29.6, false, false);
    	Image Researcher4 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher3.png"), 29.6, 29.6, false, false);
    	Image Researcher5 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher3.png"), 29.6, 29.6, false, false);
    	Image Researcher6 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher3.png"), 29.6, 29.6, false, false);
    	Image Bear = new Image(getClass().getClassLoader().getResourceAsStream("resources/medve.png"), 29.6, 29.6, false, false);
    	Image EskimoImageAvatar1 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo1.png"), 30, 30, false, false);
    	Image EskimoImageAvatar2 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo2.png"), 30, 30, false, false);
    	Image EskimoImageAvatar3 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo3.png"), 30, 30, false, false);
    	Image EskimoImageAvatar4 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo4.png"), 30, 30, false, false);
    	Image EskimoImageAvatar5 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo5.png"), 30, 30, false, false);
    	Image EskimoImageAvatar6 = new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo5.png"), 30, 30, false, false);
    	Image ResearcherImageAvatar1 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher1.png"), 30, 30, false, false);
    	Image ResearcherImageAvatar2 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher2.png"), 30, 30, false, false);
    	Image ResearcherImageAvatar3 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher3.png"), 30, 30, false, false);
    	Image ResearcherImageAvatar4 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher3.png"), 30, 30, false, false);
    	Image ResearcherImageAvatar5 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher3.png"), 30, 30, false, false);
    	Image ResearcherImageAvatar6 = new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher3.png"), 30, 30, false, false);
    	Image placeholderImageAvatar = new Image(getClass().getClassLoader().getResourceAsStream("resources/placeholder.png"), 30, 30, false, false);
    	//Image IceField2 = new Image(getClass().getClassLoader().getResourceAsStream("resources/Ice.png"), 29.6, 29.6, false, false);
    	
    	//----------------Tivadar---------------------------------End------------------------
    	
    	////-----------------------------------------IceField & Fields------------------------
    	int counter = 11;
    	int avatarcounter = 0;
    	for (int i = 0; i < 9; i++) {
    		int n = 0;
        	for(int j = 0; j < 11; j++) {
        		GridPane gridField = new GridPane();
        		gridField.setMinSize(88.8, 88.8);
        		gridField.setMaxSize(88.8, 88.8);
        		int helper = counter % 11;
        		System.out.println("helper: " + helper);
          		System.out.println("counter: " + counter);
        		if(!( helper == 0 || helper == 10 )) {
        			System.out.println("begy�ttem");
	        		if(control.getGameArea().fieldsOnArea.get(counter).getKills()) {
        			//if(false) {
	        			viewmx[n][i] = new ImageView(HoleField);
	        			gridIceField.add(viewmx[n][i], n, i);
	        		}else {
	        			viewmx[n][i] = new ImageView(IceField);
	        			gridIceField.add(viewmx[n][i], n, i);
	        		}
	        		for(int k = 0; k < 3; k++) {
	        			for(int l = 0; l < 3; l++) {
	        				ImageView halo = new ImageView();
	        				gridField.setGridLinesVisible(false);
	        				//System.out.println(control.getGameArea().fieldsOnArea.get(counter).avatars.size() + " " + avatarcounter);
	        				if(control.getGameArea().fieldsOnArea.get(counter).avatars.size() > avatarcounter) {
	        						//System.out.println("avatart talaltam");
		        					String melyik = control.getGameArea().fieldsOnArea.get(counter).avatars.get(avatarcounter).getName();
		        					switch (melyik) {
									case "e0":
										halo.setImage(Eskimo1);
										break;
									case "e1":
										halo.setImage(Eskimo2);
										break;
									case "e2":
										halo.setImage(Eskimo3);
										break;
									case "e3":
										halo.setImage(Eskimo4);
										break;
									case "e4":
										halo.setImage(Eskimo5);
										break;
									case "e5":
										halo.setImage(Eskimo6);
										break;
									case "r0":
										halo.setImage(Researcher1);
										break;
									case "r1":
										halo.setImage(Researcher2);
										break;
									case "r2":
										halo.setImage(Researcher3);
										break;
									case "r3":
										halo.setImage(Researcher4);
										break;
									case "r4":
										halo.setImage(Researcher5);
										break;
									case "r5":
										halo.setImage(Researcher6);
										break;
									case "b0":
										halo.setImage(Bear);
										break;
									case "b1":
										halo.setImage(Bear);
										break;
									case "b2":
										halo.setImage(Bear);
										break;
									default:
										break;
		        					}
		        				avatarcounter++;
	        				}
	        				gridField.add(halo, k, l);
	        			}
	        		}
	        		avatarcounter = 0;
	        		
	        		
	        		gridIceField.add(gridField, n, i);
	        		n++;
        		}
        		counter++;
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
        	Label avatarName = new Label("Not Playing :(");
        	avatarName.setFont(new Font(18));
        	avatarName.setMinSize(150, 33.3);
        	Label avatarLife = new Label("0");
        	avatarLife.setFont(new Font(18));
        	avatarRow.getChildren().add(new ImageView());
        	avatarRow.getChildren().add(avatarName);
        	avatarRow.getChildren().add(avatarLife);
        	
        	avatarsList.getChildren().add(avatarRow);
		}
    	
    	for(int i = 0; i < control.getGameArea().avatars.size(); i++) {
    		if(!(control.getGameArea().avatars.get(i).getName().contains("b"))) {
	    		String melyik = control.getGameArea().avatars.get(i).getName();
				switch (melyik) {
				case "e0":
					setImage(avatarsList,i,EskimoImageAvatar1);
					break;
				case "e1":
					setImage(avatarsList,i,EskimoImageAvatar2);
					break;
				case "e2":
					setImage(avatarsList,i,EskimoImageAvatar3);
					break;
				case "e3":
					setImage(avatarsList,i,EskimoImageAvatar4);
					break;
				case "e4":
					setImage(avatarsList,i,EskimoImageAvatar5);
					break;
				case "e5":
					setImage(avatarsList,i,EskimoImageAvatar6);
					break;
				case "r0":
					setImage(avatarsList,i,ResearcherImageAvatar1);
					break;
				case "r1":
					setImage(avatarsList,i,ResearcherImageAvatar2);
					break;
				case "r2":
					setImage(avatarsList,i,ResearcherImageAvatar3);
					break;
				case "r3":
					setImage(avatarsList,i,ResearcherImageAvatar4);
					break;
				case "r4":
					setImage(avatarsList,i,ResearcherImageAvatar5);
					break;
				case "r5":
					setImage(avatarsList,i,ResearcherImageAvatar6);
					break;
				default:
					setImage(avatarsList,i,placeholderImageAvatar);
					break;
				}
				setName(avatarsList,i,control.getGameArea().avatars.get(i).getName());
				setLife(avatarsList, i, control.getGameArea().avatars.get(i).getHealthPoints());
				deactivateAvatar(avatarsList, i);
				if(control.getGameArea().getActiveAvatar() == i)
	    			activateAvatar(avatarsList, i);
    		}
    	}
    	//Avatar's things
    	/*setLife(avatarsList,0,4);
    	setName(avatarsList,0,"Benedek");
    	setLife(avatarsList,1,5);
    	setName(avatarsList,1,"Levente");
    	setLife(avatarsList,2,4);
    	setName(avatarsList,2,"Zolt�n");
    	setLife(avatarsList,3,3);
    	setName(avatarsList,3,"Tivadar");
    	setLife(avatarsList,4,2);
    	setName(avatarsList,4,"Hanga");
    	setLife(avatarsList,5,2);
    	setName(avatarsList,5,"Hagymakarika");*/
    	
    	
    	
    	Pane uiRoot = new Pane();
    	    	
    	Button use = new Button();
    	use.setText("Use");
    	use.setLayoutX(212);
    	use.setLayoutY(130);
    	use.setStyle("-fx-background-radius: 10em; " +
                "-fx-min-width: 60px; " +
                "-fx-min-height: 60px; " +
                "-fx-max-width: 60px; " +
                "-fx-max-height: 60px;" + 
                "-fx-background-color: #99FF9D");
    	use.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Stage stage = new Stage();
	            stage.setTitle("Choose Item");
	            stage.setHeight(1000);
	            stage.setWidth(1000);
	            stage.setScene(ItemSelectionScene());
	            stage.show();
				
			}
    		
    	});
    	
    	Button sUse = new Button();
    	sUse.setText("S Use");
    	sUse.setLayoutX(257);
    	sUse.setLayoutY(196);
    	sUse.setStyle("-fx-background-radius: 10em; " +
                "-fx-min-width: 60px; " +
                "-fx-min-height: 60px; " +
                "-fx-max-width: 60px; " +
                "-fx-max-height: 60px;" + 
                "-fx-background-color: #C5B7FF");
    	
    	Button pickUp = new Button();
    	pickUp.setText("Pick Up");
    	pickUp.setLayoutX(216);
    	pickUp.setLayoutY(260);
    	pickUp.setStyle("-fx-background-radius: 10em; " +
                "-fx-min-width: 60px; " +
                "-fx-min-height: 60px; " +
                "-fx-max-width: 60px; " +
                "-fx-max-height: 60px;" + 
                "-fx-background-color: #FFB6B6");
    	
    	Button dig = new Button();
        dig.setPrefSize(60, 60);
        dig.setLayoutX(60);
        dig.setLayoutY(191);
    	
    	
    	Button up = new Button();
    	up.setPrefSize(60, 60);
    	up.setMaxSize(60, 60);
    	//Image arrowBackground = new Image(getClass().getClassLoader().getResourceAsStream("resources/arrowBlue.png"), 50, 50, false, false);
    	//up.setGraphic(new ImageView(arrowBackground));
    	String arrowPath = path + "/src/resources/arrowBlue.png";
    	
    	System.out.println(arrowPath);
    	up.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
    	up.setLayoutX(60);
    	up.setLayoutY(130);
    	
    	Button right = new Button();
    	right.setPrefSize(60, 60);
    	//right.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	right.setLayoutX(120);
    	right.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
    	right.setLayoutY(190);
    	right.setRotate(90);
    	
    	Button down = new Button();
    	down.setPrefSize(60, 60);
    	//down.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	down.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
    	down.setLayoutX(60);
    	down.setLayoutY(250);
    	down.setRotate(180);
    	
    	Button left = new Button();
    	left.setPrefSize(60, 60);
    	//left.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	left.setLayoutX(0);
    	left.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
    	left.setLayoutY(190);
    	left.setRotate(270);
    	
    	uiRoot.getChildren().add(use);
    	uiRoot.getChildren().add(sUse);
    	uiRoot.getChildren().add(pickUp);
    	uiRoot.getChildren().add(up);
    	uiRoot.getChildren().add(right);
    	uiRoot.getChildren().add(down);
    	uiRoot.getChildren().add(left);
    	uiRoot.getChildren().add(dig);

    	
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
    	return mainScene;
    }
    
    private Scene ItemSelectionScene() {
    	//------------Tivadar-----------ItemSelectionList----------------Begin---------------------
    	
    	VBox itemSelectionLayout = new VBox();
    	Image placeHolderImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/placeholder.png"), 100, 100, false, false);
    	Image cartridgeImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/batman.png"), 100, 100, false, false);
    	Image flareImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/flare.png"), 100, 100, false, false);
    	Image foodImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/food.png"), 100, 100, false, false);
    	Image fragileShovelImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/fragile_shovel.png"), 100, 100, false, false);
    	Image gunImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/gun.png"), 100, 100, false, false);
    	Image ropeImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/rope.png"), 100, 100, false, false);
    	Image shovelImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/shovel.png"), 100, 100, false, false);
    	Image tentImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/tent.png"), 100, 100, false, false);
    	Image wetSuitImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/Wetsuit.png"), 100, 100, false, false);
    	/*HBox itemSelectionInside1 = new HBox();
    	itemSelectionInside1.setAlignment(Pos.CENTER_LEFT);
    	HBox itemSelectionInside2 = new HBox();
    	itemSelectionInside2.setAlignment(Pos.CENTER_LEFT);
    	itemSelectionInside1.getChildren().add(new ImageView(placeHolderImage));
    	itemSelectionInside1.getChildren().add(placeHolderText);
    	itemSelectionInside2.getChildren().add(new ImageView(placeHolderImage));
    	itemSelectionInside2.getChildren().add(placeHolderText2);
    	itemSelectionLayout.getChildren().add(itemSelectionInside1);
    	itemSelectionLayout.getChildren().add(itemSelectionInside2);*/
    	for(int i = 0; i < 9; i++) {
    		GridPane itemSelectionInside = new GridPane();
    		ColumnConstraints col1 = new ColumnConstraints();
		    col1.setPercentWidth(25);
		    ColumnConstraints col2 = new ColumnConstraints();
		    col2.setPercentWidth(25);
		    ColumnConstraints col3 = new ColumnConstraints();
		    col3.setPercentWidth(25);
		    ColumnConstraints col4 = new ColumnConstraints();
		    col4.setPercentWidth(25);
		    itemSelectionInside.getColumnConstraints().addAll(col1,col2,col3,col4);
    		switch (i) {
			case 0:
				itemSelectionInside.add(new ImageView(cartridgeImage),0,0);
				itemSelectionInside.add(new Label("Cartridge"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				itemSelectionInside.add(new Button("Use"),3,0);
				break;
			case 1:
				itemSelectionInside.add(new ImageView(flareImage),0,0);
				itemSelectionInside.add(new Label("Flare"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				itemSelectionInside.add(new Button("Use"),3,0);
				break;
			case 2:
				itemSelectionInside.add(new ImageView(foodImage),0,0);
				itemSelectionInside.add(new Label("Food"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				itemSelectionInside.add(new Button("Use"),3,0);
				break;
			case 3:
				itemSelectionInside.add(new ImageView(fragileShovelImage),0,0);
				itemSelectionInside.add(new Label("Fragile Shovel"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				itemSelectionInside.add(new Button("Use"),3,0);
				break;
			case 4:
				itemSelectionInside.add(new ImageView(gunImage),0,0);
				itemSelectionInside.add(new Label("Gun"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				itemSelectionInside.add(new Button("Use"),3,0);
				break;
			case 5:
				itemSelectionInside.add(new ImageView(ropeImage),0,0);
				itemSelectionInside.add(new Label("Rope"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				itemSelectionInside.add(new Button("Use"),3,0);
				break;
			case 6:
				itemSelectionInside.add(new ImageView(shovelImage),0,0);
				itemSelectionInside.add(new Label("Shovel"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				itemSelectionInside.add(new Button("Use"),3,0);
				break;
			case 7:
				itemSelectionInside.add(new ImageView(tentImage),0,0);
				itemSelectionInside.add(new Label("Tent"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				itemSelectionInside.add(new Button("Use"),3,0);
				break;
			case 8:
				itemSelectionInside.add(new ImageView(wetSuitImage),0,0);
				itemSelectionInside.add(new Label("WetSuit"),1,0);
				itemSelectionInside.add(new Label("0"),2,0);
				break;
			default:
				break;
			}
    		itemSelectionLayout.getChildren().add(itemSelectionInside);
    	}
    	
    	Scene itemSelectionScene = new Scene(itemSelectionLayout, 1000, 1000);
    
    	//------------Tivadar-----------ItemSelectionList----------------End-----------------------
    	return itemSelectionScene;
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
    
    //Sets the picture of avatar in avatarlist
    public void setImage(VBox avatarlist, int index, Image image) {
    	HBox avatarRow = (HBox)avatarlist.getChildren().get(index);
    	ImageView imageofAvatar = (ImageView)avatarRow.getChildren().get(0);
    	imageofAvatar.setImage(image);
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
    
    private Direction dir = null;
    public Direction whichDir() {
        Stage dirchoose = new Stage();
    	dirchoose.initModality(Modality.APPLICATION_MODAL);
        dirchoose.initOwner(mainStage);
    	
        Pane pane = new Pane();
        
        Button up = new Button();
    	up.setPrefSize(60, 60);
    	up.setLayoutX(120);
    	up.setLayoutY(60);
    	
    	Button right = new Button();
    	right.setPrefSize(60, 60);
    	right.setLayoutX(180);
    	right.setLayoutY(120);
    	right.setRotate(90);
    	
    	Button down = new Button();
    	down.setPrefSize(60, 60);
    	down.setLayoutX(120);
    	down.setLayoutY(180);
    	down.setRotate(180);
    	
    	Button left = new Button();
    	left.setPrefSize(60, 60);
    	left.setLayoutX(60);
    	left.setLayoutY(120);
    	left.setRotate(270);
        
    	pane.getChildren().add(up);
    	pane.getChildren().add(right);
    	pane.getChildren().add(down);
    	pane.getChildren().add(left);

    	
    	
        Scene sceneDir = new Scene(pane,300,300);
        dirchoose.setTitle("Choose a direction!");
        dirchoose.setScene(sceneDir);
        
        
        up.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	    dir = Direction.North;
            	    dirchoose.hide();
            }
        });

        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	    dir = Direction.East;
            	    dirchoose.hide();
            }
        });
        down.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	    dir = Direction.South;
            	    dirchoose.hide();
            }
        });
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	    dir = Direction.West;
            	    dirchoose.hide();
            }
        });
        dirchoose.show();
        
    	return dir;
    }
   
}


	