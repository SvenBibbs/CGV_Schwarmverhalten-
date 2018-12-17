package Graphic;
import Algebra.Vektor2D;

public abstract class BasisObjekt {
	public int id;
	public Vektor2D position;
	
	public BasisObjekt(Vektor2D position) {
		this.position = new Vektor2D(position);
	}
	
	public abstract void render();
}
