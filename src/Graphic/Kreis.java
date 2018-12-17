package Graphic;
import Algebra.Vektor2D;
import static org.lwjgl.opengl.GL11.*;

public class Kreis extends BewegendesObjekt {
	private static int objCounter = 0;
	private float radius;
	private float r, g, b;
	public ObjektManager objektManager;
	
	public Kreis(Vektor2D position, Vektor2D velocity, float radius, float r, float g, float b) {
		super(position, velocity);
		this.radius = radius;
		this.r = r;
		this.g = g;
		this.b = b;
		this.id = objCounter++;
	}
	
	public void setObjektManager(ObjektManager objektManager) {
		this.objektManager = objektManager;
	}
	
	@Override
	public void render() {
		glColor3d(r, g, b);
		glBegin(GL_TRIANGLE_FAN);
		glVertex2f((float)position.First, (float)position.Second);
		for (int angle=0; angle<360; angle+=30) {
			glVertex2f((float)position.First + (float)Math.sin(angle) * radius, (float)position.Second + (float)Math.cos(angle) * radius);
		}
		glEnd(); 
	}
	
}
