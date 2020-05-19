package graphics;



import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import jegmezo.fields.Field;

public class FieldGraphics extends Graphics {
    private Field field;
	GridPane grid = new GridPane();
	private String path = Paths.get("").toAbsolutePath().toString();
	
	
	public FieldGraphics(Image image, Field fieldd){
		super(image);
		this.field = fieldd;
	}
	
	public GridPane refreshField() {
		
		grid.getChildren().clear();
		
		//FILL THE GRID WITH EMPTY SPACE
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Label lab = new Label("");
				lab.setMinSize(29.6, 29.6);
				lab.setMaxSize(29.6, 29.6);
				grid.add(lab, i, j);
			}
		}
		
		switch(field.getShelter()) {
		case Igloo :
			//IGLOO and AVATARS INSIDE
			grid.add(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/igloo.png"), 29.6, 29.6, false, false)), 1, 1);
			//ITEM
			if(field.item != null && field.getSnowAmount() <= 0)
				grid.add(new ImageView(field.item.getGraphics().getImage()), 1, 2);
			//BACKGROUND
			grid.setBackground(new Background(new BackgroundImage( this.image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(88.8,88.8,false,false,false,false))));
			break;
		case Tent :
			//TENT and AVATARS INSIDE
			grid.add(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/tent.png"), 29.6, 29.6, false, false)), 1, 1);
			//ITEM 
			if(field.item != null && field.getSnowAmount() <= 0)
				grid.add(new ImageView(field.item.getGraphics().getImage()), 1, 2);
			//BACKGROUND
			grid.setBackground(new Background(new BackgroundImage( this.image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(88.8,88.8,false,false,false,false))));
			break;
		case None :
			//AVATARS
			int size = field.avatars.size();
			for (int i = 0; i < size; i++) {
				grid.add(new ImageView(field.avatars.get(i).getGraphics().getImage()), i%3, i/3);
			}
			//SNOW AMOUNT
			Label snow = new Label(Integer.toString(field.getSnowAmount()));
			snow.setMinSize(29.6, 29.6);
			snow.setMaxSize(29.6, 29.6);
			snow.setAlignment(Pos.CENTER);
			grid.add(snow , 2, 2);
			//ITEM
			if(field.item != null && field.getSnowAmount() <= 0)
				grid.add(new ImageView(field.item.getGraphics().getImage()), 1, 2);
			//BACKGROUND
			System.out.println("------------------>None type background");
			grid.setBackground(new Background(new BackgroundImage( this.image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(88.8,88.8,false,false,false,false))));
			break;
		default:
			grid.add(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/flare.png"), 100, 100, false, false)), 2, 1);
		}
		
		/*
		Label kakik = new Label("kaki");
		kakik.setMinSize(88, 88);
		grid.add(kakik,0,0);
		*/
		
		return grid;
	}
}