package Graphic;
import Algebra.Vektor2D;
import static org.lwjgl.opengl.GL11.*;

public class Ziel extends BewegendesObjekt {
	private static int objCounter = 0;
	private float r, g, b;
	private int size;
	private boolean isDragged;
	public ObjektManager objektManager;
	
	public int getSize() {
		return size;
	}
	
	public boolean isDragged() {
		return isDragged;
	}
	
	public void setDragged(boolean dragged) {
		isDragged = dragged;
	}

    public Ziel(Vektor2D position, Vektor2D velocity, int size, float r, float g, float b) {
        super(position, velocity);
        this.size = size;
        this.r=r;
        this.g=g;
        this.b=b;
        this.id = objCounter++;
    }
	
	public Ziel(Vektor2D position, Vektor2D velocity) {
		this(position, velocity, 40, 0, 1, 0);
	}
	
	public void setObjektManager(ObjektManager objektManager) {
		this.objektManager = objektManager;
	}
	
    @Override
    public void render() {
        glColor3d(r, g, b);
        glBegin(GL_QUADS);
        glVertex2d(position.First, position.Second);
        glVertex2d(position.First + size, position.Second);
        glVertex2d(position.First + size, position.Second + size);
        glVertex2d(position.First, position.Second + size);
        glEnd();
    }

    public boolean checkForHit(Vektor2D position){
        return position.getFirst() < this.position.getFirst() + this.getSize() &&
                position.getFirst() > this.position.getFirst() - this.getSize() &&
                position.getSecond() < this.position.getSecond() + this.getSize() &&
                position.getSecond() > this.position.getSecond();
    }
	
}
