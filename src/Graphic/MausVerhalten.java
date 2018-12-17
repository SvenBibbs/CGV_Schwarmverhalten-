package Graphic;
import Algebra.Vektor2D;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class MausVerhalten implements Verhalten{
	private Ziel ziel;
	
	public MausVerhalten(Ziel ziel) {
		this.ziel = ziel;
	}
	
	@Override
	public void update() {
		Vektor2D position = new Vektor2D(Mouse.getX(), Display.getDisplayMode().getHeight() - Mouse.getY());
		
		if (ziel.isDragged()) {
			ziel.position = position;
		}
		
		if (Mouse.isButtonDown(0)) {
			if (ziel.checkForHit(position)) {
				ziel.setDragged(true);
				ziel.position = position;
			}
		}
		else {
			ziel.setDragged(false);
		}
	}
}
