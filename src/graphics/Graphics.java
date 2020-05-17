package graphics;

import javafx.scene.image.Image;

public class Graphics {
	protected Image image;
	
	public Graphics(Image image) {
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
}
