package Graphic;
import Algebra.Vektor2D;

public class KreisVerhalten implements Verhalten{
	private Kreis kreis;
	private Physik steering;
	
	public KreisVerhalten (Kreis kreis) {
		this.kreis = kreis;
		this.steering = new Physik();
	}
	
	@Override
	public void update() {
		Vektor2D mouseForce = steering.folgen(kreis);
		Vektor2D separationForce = steering.separation(kreis, 32);
		Vektor2D alignmentForce = steering.alignment(kreis, 70);
		Vektor2D cohesionForce = steering.cohesion(kreis);
		
		mouseForce.mult(1f);
		separationForce.mult(10f);
		alignmentForce.mult(0.02f);
		cohesionForce.mult(0.01f);
		
		steering.applyForce(mouseForce);
		steering.applyForce(separationForce);
		steering.applyForce(alignmentForce);
		steering.applyForce(cohesionForce);
		
	      kreis.velocity.add(steering.acceleration);
	      float MAX_SPEED = 7.5f;
	      kreis.velocity.truncate(MAX_SPEED);
	      kreis.position.add(kreis.velocity);
	      
	      steering.resetAcceleration();
	}
}
