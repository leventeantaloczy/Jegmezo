package graphics;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.application.Platform;
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
import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;
 
public class MyGraphics extends Application {
	private Stage mainStage;
	private Stage iSelectStage;
	private Controller control;
	private ImageView[][] viewmx = new ImageView[9][9];
	private String path = Paths.get("").toAbsolutePath().toString();
    public static void main(String[] args) {
        launch(args);
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
    	VBox v = new VBox();
    	Image Splash = new Image(getClass().getClassLoader().getResourceAsStream("resources/splash.jpg"), 1200, 860,  false, false);
    	ImageView iv = new ImageView(Splash);
    	v.getChildren().add(iv);
    	Scene s = new Scene(v, 1200, 800);
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
       	        	mainStage.setScene(s);
	       	     	control = new Controller(Integer.parseInt(numPlayers.getText()));
	       	    	try {
	       				control.startGame(true);
	       			} catch (IOException t) {
	       				// TODO Auto-generated catch block
	       				t.printStackTrace();
	       			}
       	        	/*control.getGameArea().setNumberOfPlayers(Integer.parseInt(numPlayers.getText()));
       	        	control.getGameArea().init(control.getGameEnder(), true);*/
       	        	mainStage.setScene(MainScene());
       	        	/*try {
						control.runGame();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
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
    	
    	for (int i = 11; i < 109; i++) {
			if(!(i % 11 == 0 || i % 11 == 10)) {
				int x = i/11;
				int y = i%11;
				gridIceField.add(control.getGameArea().fieldsOnArea.get(i).getGraphics().refreshField(), y, x);
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
				iSelectStage = new Stage();
	            iSelectStage.setTitle("Choose Item");
	            iSelectStage.setHeight(1000);
	            iSelectStage.setWidth(1000);
	            iSelectStage.setScene(ItemSelectionScene());
	            iSelectStage.show();	
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
    	sUse.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	int mySelf = control.getGameArea().getActiveAvatar();
            	if(control.getGameArea().avatars.get(mySelf).getName().contains("e")) {
            		control.setCommand("sp");
            	}else {
            		whichDir("Researcher");
            	}
            	control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
            	refreshList(avatarsList);
            	if(control.getGameEnder().getEnd()) {
            		Stage endStage = endGameDialog();
            		endStage.show();
            	}
            }
    	});
    	
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
    	pickUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	int mySelf = control.getGameArea().getActiveAvatar();
            	control.setCommand("b");
            	control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
            	refreshList(avatarsList);
            	if(control.getGameEnder().getEnd()) {
            		Stage endStage = endGameDialog();
            		endStage.show();
            	}
            }
    	});
    	
    	Button dig = new Button();
        dig.setPrefSize(60, 60);
        dig.setLayoutX(60);
        dig.setLayoutY(191);
        dig.setText("DIG");
        dig.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle(ActionEvent e) {
        		int mySelf = control.getGameArea().getActiveAvatar();
            	control.setCommand("dig");
            	control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
            	refreshList(avatarsList);
            	if(control.getGameEnder().getEnd()) {
            		Stage endStage = endGameDialog();
            		endStage.show();
            	}
        	}
        });
    	
    	
    	Button up = new Button();
    	up.setPrefSize(60, 60);
    	up.setMaxSize(60, 60);
    	//Image arrowBackground = new Image(getClass().getClassLoader().getResourceAsStream("resources/arrowBlue.png"), 50, 50, false, false);
    	//up.setGraphic(new ImageView(arrowBackground));
    	path = path.replaceAll("\\\\", "/");
    	String arrowPath = path + "/src/resources/arrowBlue.png";
    	System.out.println(arrowPath);
      	up.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
    	up.setLayoutX(60);
    	up.setLayoutY(130);
    	up.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	int mySelf = control.getGameArea().getActiveAvatar();
            	Field temp = control.getGameArea().avatars.get(mySelf).getField();
            	control.setCommand("mn");
            	control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
            	temp.getGraphics().refreshField();
            	refreshList(avatarsList);
            	if(control.getGameEnder().getEnd()) {
            		Stage endStage = endGameDialog();
            		endStage.show();
            	}
            }
    	});
    	
    	
    	Button right = new Button();
    	right.setPrefSize(60, 60);
    	//right.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	right.setLayoutX(120);
    	right.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
    	right.setLayoutY(190);
    	right.setRotate(90);
    	right.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	int mySelf = control.getGameArea().getActiveAvatar();
            	Field temp = control.getGameArea().avatars.get(mySelf).getField();
            	control.setCommand("me");
            	control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
            	temp.getGraphics().refreshField();
            	refreshList(avatarsList);
            	if(control.getGameEnder().getEnd()) {
            		Stage endStage = endGameDialog();
            		endStage.show();
            	}
            }
    	});
    	
    	Button down = new Button();
    	down.setPrefSize(60, 60);
    	//down.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	down.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
    	down.setLayoutX(60);
    	down.setLayoutY(250);
    	down.setRotate(180);
    	down.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	int mySelf = control.getGameArea().getActiveAvatar();
            	Field temp = control.getGameArea().avatars.get(mySelf).getField();
            	control.setCommand("ms");
            	control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
            	temp.getGraphics().refreshField();
            	refreshList(avatarsList);
            	if(control.getGameEnder().getEnd()) {
            		Stage endStage = endGameDialog();
            		endStage.show();
            	}
            }
    	});
    	
    	Button left = new Button();
    	left.setPrefSize(60, 60);
    	//left.setStyle("-fx-background-image: url(\"file:///C:/Users/molna/Desktop/spec4.PNG\");");
    	left.setLayoutX(0);
    	left.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
    	left.setLayoutY(190);
    	left.setRotate(270);
    	left.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	int mySelf = control.getGameArea().getActiveAvatar();
            	Field temp = control.getGameArea().avatars.get(mySelf).getField();
            	control.setCommand("mw");
            	control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
            	temp.getGraphics().refreshField();
            	refreshList(avatarsList);
            	if(control.getGameEnder().getEnd()) {
            		Stage endStage = endGameDialog();
            		endStage.show();
            	}
            }
    	});
    	
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
		    int cnt = 0;
		    switch (i) {
            case 0:
                cnt = control.countItem("Cartridge");
                itemSelectionInside.add(new ImageView(cartridgeImage),0,0);
                itemSelectionInside.add(new Label("Cartridge"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but1 = new Button("Use");
                itemSelectionInside.add(but1, 3, 0);
                but1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                int mySelf = control.getGameArea().getActiveAvatar();
                        control.setCommand("Cartridge");
                        control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                        iSelectStage.close();
                    }
                });
                break;
            case 1:
                cnt = control.countItem("Flare");
                itemSelectionInside.add(new ImageView(flareImage),0,0);
                itemSelectionInside.add(new Label("Flare"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but2 = new Button("Use");
                itemSelectionInside.add(but2, 3, 0);
                but2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    int mySelf = control.getGameArea().getActiveAvatar();
                            control.setCommand("Flare");
                            control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                            iSelectStage.close();
                        }
                    });                
                break;
            case 2:
                cnt = control.countItem("Food");
                itemSelectionInside.add(new ImageView(foodImage),0,0);
                itemSelectionInside.add(new Label("Food"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but3 = new Button("Use");
                itemSelectionInside.add(but3, 3, 0);
                but3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    int mySelf = control.getGameArea().getActiveAvatar();
                            control.setCommand("Food");
                            control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                            iSelectStage.close();
                        }
                    });                
                break;
            case 3:
                cnt = control.countItem("fShovel");
                itemSelectionInside.add(new ImageView(fragileShovelImage),0,0);
                itemSelectionInside.add(new Label("Fragile Shovel"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but4 = new Button("Use");
                itemSelectionInside.add(but4, 3, 0);
                but4.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    int mySelf = control.getGameArea().getActiveAvatar();
                            control.setCommand("fShovel");
                            control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                            iSelectStage.close();
                        }
                    });                
                break;
            case 4:
                cnt = control.countItem("Gun");
                itemSelectionInside.add(new ImageView(gunImage),0,0);
                itemSelectionInside.add(new Label("Gun"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but5 = new Button("Use");
                itemSelectionInside.add(but5, 3, 0);
                but5.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    int mySelf = control.getGameArea().getActiveAvatar();
                            control.setCommand("Gun");
                            control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                            iSelectStage.close();
                        }
                    });                
                break;
               
            //Nem jo
            case 5:
                cnt = control.countItem("Rope");
                itemSelectionInside.add(new ImageView(ropeImage),0,0);
                itemSelectionInside.add(new Label("Rope"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but6 = new Button("Use");
                itemSelectionInside.add(but6, 3, 0);
                but6.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    		int mySelf = control.getGameArea().getActiveAvatar();
                    		whichDir("Rope");
                            control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                            iSelectStage.close();
                        }
                    });                
                break;
            case 6:
                cnt = control.countItem("Shovel");
                itemSelectionInside.add(new ImageView(shovelImage),0,0);
                itemSelectionInside.add(new Label("Shovel"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but7 = new Button("Use");
                itemSelectionInside.add(but7, 3, 0);
                but7.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    int mySelf = control.getGameArea().getActiveAvatar();
                            control.setCommand("Shovel");
                            control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                            iSelectStage.close();
                        }
                    });                
                break;
            case 7:
                cnt = control.countItem("Tent");
                itemSelectionInside.add(new ImageView(tentImage),0,0);
                itemSelectionInside.add(new Label("Tent"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but8 = new Button("Use");
                itemSelectionInside.add(but8, 3, 0);
                but8.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    int mySelf = control.getGameArea().getActiveAvatar();
                            control.setCommand("Tent");
                            control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                            iSelectStage.close();
                        }
                    });                
                break;
            case 8:
                cnt = control.countItem("WetSuit");
                itemSelectionInside.add(new ImageView(wetSuitImage),0,0);
                itemSelectionInside.add(new Label("WetSuit"),1,0);
                itemSelectionInside.add(new Label(Integer.toString(cnt)),2,0);
                Button but9 = new Button("Use");
                itemSelectionInside.add(but9, 3, 0);
                but9.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                    int mySelf = control.getGameArea().getActiveAvatar();
                            control.setCommand("WetSuit");
                            control.getGameArea().avatars.get(mySelf).getField().getGraphics().refreshField();
                            iSelectStage.close();
                        }
                    });                
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
    public Direction whichDir(String type) {
        Stage dirchoose = new Stage();
    	dirchoose.initModality(Modality.APPLICATION_MODAL);
    	
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
        
        //------------------------
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
        Text t = new Text("N/A");
        dialogVbox.getChildren().addAll(t,closeButton);
        dialogVbox.setAlignment(Pos.CENTER);
        
        Scene dialogScene = new Scene(dialogVbox, 250, 100);
        dialog.setTitle("Is it unstable?");
        dialog.setScene(dialogScene);
        //------------------------
        
        String arrowPath = path + "/src/resources/arrowBlue.png";
        up.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	    dir = Direction.North;
            	    if(type == "Rope") {
            	    	control.setCommand("ropen");
            	    }else {
            	    	control.setCommand("resn");
            	    	if(Controller.tempCapacity == -1) {
	        	    		t.setText("Stable");
	        	    	}else {
	        	    		t.setText("Unstable, cap: " + Controller.tempCapacity);
	        	    	}
            	    	dialog.show();
            	    }
            	    
            	    dirchoose.hide();
            }
        });
        up.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");

        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
	            	if(type == "Rope") {
	        	    	control.setCommand("ropee");
	        	    }else {
	        	    	control.setCommand("rese");
	        	    	if(Controller.tempCapacity == -1) {
	        	    		t.setText("Stable");
	        	    	}else {
	        	    		t.setText("Unstable, cap: " + Controller.tempCapacity);
	        	    	}
	        	    	
            	    	dialog.show();
	        	    }
            	    dirchoose.hide();
            }
        });
        right.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
        
        down.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
	            	if(type == "Rope") {
	        	    	control.setCommand("ropes");
	        	    }else {
	        	    	control.setCommand("ress");
	        	    	if(Controller.tempCapacity == -1) {
	        	    		t.setText("Stable");
	        	    	}else {
	        	    		t.setText("Unstable, cap: " + Controller.tempCapacity);
	        	    	}
            	    	dialog.show();
	        	    }
            	    dirchoose.hide();
            }
        });
        
        down.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
        
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
	            	if(type == "Rope") {
	        	    	control.setCommand("ropew");
	        	    }else {
	        	    	control.setCommand("resw");
	        	    	if(Controller.tempCapacity == -1) {
	        	    		t.setText("Stable");
	        	    	}else {
	        	    		t.setText("Unstable, cap: " + Controller.tempCapacity);
	        	    	}
            	    	dialog.show();
	        	    }
            	    dirchoose.hide();
            }
        });
        
        left.setStyle("-fx-background-image: url(\"file:///" + arrowPath + "\");" + "-fx-background-size: cover;");
        
        dirchoose.show();
        
    	return dir;
    }
    public void refreshList(VBox avatarsList) {
    	for(int i = 0; i < control.getGameArea().avatars.size(); i++) {
    		if(!(control.getGameArea().avatars.get(i).getName().contains("b"))) {
    			setLife(avatarsList, i, control.getGameArea().avatars.get(i).getHealthPoints());
    			deactivateAvatar(avatarsList, i);
    			if(control.getGameArea().getActiveAvatar() == i)
    				activateAvatar(avatarsList, i);
    		}
    	}
    }
    
    private Stage endGameDialog() {
    	final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(mainStage);
        VBox dialogVbox = new VBox(20);
        
        Button closeButton = new Button("Close");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Platform.exit();
            }
        });
        dialogVbox.getChildren().addAll(new Text("Game Over!"),closeButton);
        dialogVbox.setAlignment(Pos.CENTER);
        
        Scene dialogScene = new Scene(dialogVbox, 250, 100);
        dialog.setTitle("Better Luck Next Time!");
        dialog.setScene(dialogScene);
        return dialog;
    }
    			
}


	
