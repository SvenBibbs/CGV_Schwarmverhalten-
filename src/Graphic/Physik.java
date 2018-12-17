package Graphic;
import Algebra.LineareAlgebra;
import Algebra.Vektor2D;

public class Physik {
	public Vektor2D acceleration;
	
	public Physik() {
		acceleration = new Vektor2D(0, 0);
	}
	
	public void resetAcceleration() {
		acceleration.mult(0);
	}
	
	public void applyForce(Vektor2D force) {									
		acceleration.add(force);	
	}
	
	public Vektor2D folgen(Kreis ego) {											// Partikel folgt dem Ziel -> Richtungsvektor in Abhängigkeit des Ziels
		double lowestDistance = 0;
		int lowestZielId = 0;
		
		Object[] ziele = ego.objektManager.getZielMap().values().toArray();
		for (Object foo : ziele) {
			Ziel ziel = (Ziel) foo;
			
			if (ego.id != ziel.id) {
				double distance = LineareAlgebra.euklDistance(ego.position, ziel.position);
				if (lowestDistance != 0) {
					lowestZielId = ziel.id;
					lowestDistance = distance;
				}
				else {
					lowestDistance = distance;
					lowestZielId = ziel.id;
				}
			}
		}
		
		Ziel ziel = ego.objektManager.getZiel(lowestZielId);
		Vektor2D position = new Vektor2D(ziel.position);
		position.sub(ego.position);
		position.normalize();
		return position;
	}
	
	public Vektor2D separation(Kreis ego, double dist) {						// Abstand von Partikel zu anderen Partikel
		Vektor2D steeringForce = new Vektor2D(0, 0);
		
		for (int i = 0; i < ego.objektManager.getKreisSize(); i++) {
			if (ego.id == i) {
				continue;
			}
			
			Kreis buf_Obj = ego.objektManager.getKreis(i);
			if (LineareAlgebra.euklDistance(ego.position, buf_Obj.position) < dist) {
				Vektor2D buf = LineareAlgebra.sub(ego.position, buf_Obj.position);
				double length = buf.length();
				buf.normalize();
				buf.div(length/6);
				steeringForce.add(buf);
			}
		}
		return steeringForce;
	}
	
	public Vektor2D alignment (Kreis ego, float dist) {							// Bewegungsrichtung von Partikel in abhängigkeit anderer Partikel
		Vektor2D steeringForce = new Vektor2D(0,0);
		
		int count = 0;
		for (int i = 0; i < ego.objektManager.getKreisSize(); i++) {
			if (ego.id == i) {
				continue;
			}
			
			Kreis buf_Obj = ego.objektManager.getKreis(i);
			if (LineareAlgebra.euklDistance(ego.position, buf_Obj.position) < dist) {
				steeringForce.add(buf_Obj.velocity);
				count++;
			}
		}
		
		if (count > 0) {
			steeringForce.mult(1f / count);
			steeringForce.sub(ego.velocity);
		}
		return steeringForce;
	}
	
	public Vektor2D cohesion(Kreis ego) {										// Partikel neue Richtung geben in abhängigkeit von umgebenden Partikeln
		Vektor2D steeringForce = new Vektor2D(0,0);
		
		int count = 0;
		for (int i = 0; i < ego.objektManager.getKreisSize(); i++ ) {			// So oft ausführen, wie Partikel im System
			if (ego.id == i)
				continue;
			
			Kreis buf_Obj = ego.objektManager.getKreis(i);
				steeringForce.add(buf_Obj.position);
				count++;
		}
		
		if (count != 0) {
			steeringForce.mult(1f/count);
			steeringForce.sub(ego.position);
		}
		return steeringForce;
	}
	
}
