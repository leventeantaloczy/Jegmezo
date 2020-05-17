package graphics;


import org.graalvm.compiler.core.common.Fields;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import jegmezo.fields.Field;

public class FieldGraphics extends Graphics {
	private Field field;
	GridPane grid = new GridPane();
	
	public FieldGraphics(Image image, Field fieldd){
		super(image);
		this.field = fieldd;
	}
	
	public GridPane refreshField() {
		System.out.println("refreshbe bejon");
		//RAJZOLJA A FRISS INFOKAT
		//FIELD MEZOIN MEGY VEGIG ES RAJZOLJA KI ANNAK MEGFELELOEN
		/*field.getSnowAmount() == 0 {
			grid.getindex(3,3,field.item.getGraphics().getImage();
		}*/
		//grid ujrarajzolas
		/*
		switch(field.getShelter()) {
		case Igloo :
			grid.add(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/tent.png"), 100, 100, false, false)), 1, 1);
			//grid.setBackground(arg0);
			break;
		case Tent :
			grid.add(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/tent.png"), 100, 100, false, false)), 1, 1);
			//grid.setBackground(arg0);
			break;
		case None :
			int size = field.avatars.size();
			for (int i = 0; i < size; i++) {
				grid.add(new ImageView(field.avatars.get(i).getGraphics().getImage()), size/3, size%3);
			}
			grid.add(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/flare.png"), 100, 100, false, false)), 2, 1);
			//grid.setBackground(arg0); this.getimage();
			break;
		default:
			grid.add(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/flare.png"), 100, 100, false, false)), 2, 1);
		}
		*/
		
		System.out.println(field.id + " field id"); 
		
		System.out.println(field.avatars.isEmpty());
		if(!field.avatars.isEmpty()) {
			System.out.println(field.avatars.get(0).getGraphics().getImage().getHeight() + "Imagaea asdlkfjasédfh"); 
			System.out.println("heyho not empty");
			int size = field.avatars.size();
			for (int i = 0; i < size; i++) {
				System.out.println("hey" + i + "\n");
				System.out.println(field.avatars.get(i).getGraphics().getImage().getHeight() + " image height");
				grid.add(new ImageView(field.avatars.get(i).getGraphics().getImage()), 1, 1);
			}
		} else {
			grid.add(new Label("kaksi"), 0, 0);
		}
		/*
		Label kakik = new Label("kaki");
		kakik.setMinSize(88, 88);
		grid.add(kakik,0,0);
		*/
		
		return grid;
	}
}
