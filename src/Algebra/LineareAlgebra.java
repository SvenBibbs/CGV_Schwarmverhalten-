package Algebra;

public class LineareAlgebra {
    private LineareAlgebra() {}

    // Addition 2D
	public static Vektor2D add(Vektor2D vec1, Vektor2D vec2) {
		return new Vektor2D(vec1.getFirst()+vec2.getFirst(), vec1.getSecond()+vec2.getSecond());
	}
	
	// Addition 3D
	public static Vektor3D add(Vektor3D vec1, Vektor3D vec2){
		return new Vektor3D(vec1.getX()+vec2.getX(), vec1.getY()+vec2.getY(), vec1.getZ()+vec2.getZ());
	}
	
	// Subtraktion 2D
	public static Vektor2D sub(Vektor2D vec1, Vektor2D vec2) {
		return new Vektor2D(vec1.getFirst()-vec2.getFirst(), vec1.getSecond()-vec2.getSecond());
	}
	
	// Subtraktion 3D
	public static Vektor3D sub(Vektor3D vec1, Vektor3D vec2){
		return new Vektor3D(vec1.getX()-vec2.getX(), vec1.getY()-vec2.getY(), vec1.getZ()-vec2.getZ());
	}	
	
	// Multiplikation mit Skalar 2D
	public static Vektor2D mult(Vektor2D vec, double s) {
		return new Vektor2D(vec.getFirst()*s, vec.getSecond()*s);
	}
	
	// Multiplikation mit Skalar 3D
	public static Vektor3D mult(Vektor3D vec, double s){
		return new Vektor3D(vec.getX()*s, vec.getY()*s, vec.getZ()*s);
	}
	
	// Multiplikation von links noch zusätzlich für bessere Lesbarkeit 2D
	public static Vektor2D mult(double s, Vektor2D vec) {
		return mult(vec, s);
	}	
	
	// Multiplikation von links noch zusätzlich für bessere Lesbarkeit 3D
	public static Vektor3D mult(double s, Vektor3D vec){
		return mult(vec, s);
	}		
	
	// Division mit Skalar 2D
	public static Vektor2D div(Vektor2D vec, double s) {
		if (s!=0)
			return new Vektor2D(vec.getFirst()/s, vec.getSecond()/s);
		else
			return new Vektor2D(0,0);
	}
	
	// Division mit Skalar 3D
	public static Vektor3D div(Vektor3D vec, double s){
		if (s!=0)
			return new Vektor3D(vec.getX()/s, vec.getY()/s, vec.getZ()/s);
		else
			return new Vektor3D(0,0,0);
	}	

	// Division von links noch zusätzlich für bessere Lesbarkeit 2D
	public static Vektor2D div(double s, Vektor2D vec) {
		return div(vec, s);
	}			

	// Division von links noch zusätzlich für bessere Lesbarkeit 3D
	public static Vektor3D div(double s, Vektor3D vec){
		return div(vec, s);
	}		

	// Gleichheit 2D
	public static boolean isEqual(Vektor2D vec1, Vektor2D vec2) {
		return (vec1.getFirst()==vec2.getFirst() && vec1.getSecond()==vec2.getSecond());
	}
	
	// Gleichheit 3D
	public static boolean isEqual(Vektor3D vec1, Vektor3D vec2){
		return (vec1.getX()==vec2.getX() && vec1.getY()==vec2.getY() && vec1.getZ()==vec2.getZ());
	}
	
	// Ungleichheit 2D
	public static boolean isNotEqual(Vektor2D vec1, Vektor2D vec2) {
		return !isEqual(vec1, vec2);
	}
	
	// Ungleichheit 3D
	public static boolean isNotEqual(Vektor3D vec1, Vektor3D vec2){
		return !isEqual(vec1, vec2);
	}	

	// Länge eines Vektors 2D
	public static float length(Vektor2D vec) {
		return (float)Math.sqrt(lengthSquare(vec));
	}	
	
	// Länge eines Vektors 3D
	public static float length(Vektor3D vec){
		return (float)Math.sqrt(vec.x*vec.x + vec.y*vec.y + vec.z*vec.z);
	}
	
	// Quadrat der Länge eines Vektors 2D
	public static double lengthSquare(Vektor2D vec) {
		return vec.First *vec.First + vec.Second *vec.Second;
		// oder multscalar: Math.sqrt(mult_scalar(vec, vec))
	}
	
	// Quadrat der Länge eines Vektors 3D
	public static float lengthSquare(Vektor3D vec) {
		return (float) (vec.x*vec.x + vec.y*vec.y + vec.z*vec.z); 
		// oder multscalar: Math.sqrt(mult_scalar(vec, vec))
	}

	// Euklidische Distanz zwischen zwei Vektoren 2D
	public static float euklDistance(Vektor2D vec, Vektor2D vec2) {
		return length(sub(vec2, vec)); 
	}	

	// Euklidische Distanz zwischen zwei Vektoren 3D
	public static float euklDistance(Vektor3D vec, Vektor3D vec2) {
		return length(sub(vec2, vec)); 
	}

	// Normalisierung eines Vektors ohne Exception 2D
	public static Vektor2D normalize(Vektor2D vec) {
		if (vec.isNullvector())
			return new Vektor2D(mult(vec, (1.0/vec.length()+0.00001)));
		else			
			return new Vektor2D(div(vec, vec.length()));
	}
	
	// Normalisierung eines Vektors ohne Exception 3D
	public static Vektor3D normalize(Vektor3D vec) {
		if (vec.isNullvector())
			return new Vektor3D(mult(vec, (1f/vec.length()+0.00001f)));
		else			
			return new Vektor3D(div(vec, vec.length()));
	}
	
	// Kreuzprodukt zweier Vektoren 3D
	public static Vektor3D crossProduct(Vektor3D vec1, Vektor3D vec2) {
		return new Vektor3D(vec1.getY()*vec2.getZ() - vec1.getZ()*vec2.getY(),
							vec1.getZ()*vec2.getX() - vec1.getX()*vec2.getZ(),
							vec1.getX()*vec2.getY() - vec1.getY()*vec2.getX());
	}	
	
	// Punktprodukt zweier Vektoren 2D
	public static double dotProduct(Vektor2D vec1, Vektor2D vec2) {
		return vec1.getFirst()*vec2.getFirst() + vec1.getSecond()*vec2.getSecond();
	}
	
	// Punktprodukt zweier Vektoren 3D
	public static double dotProduct(Vektor3D vec1, Vektor3D vec2)
	{
		return vec1.getX()*vec2.getX() + vec1.getY()*vec2.getY() + vec1.getZ()*vec2.getZ();
	}	

	// Winkel zwischen zwei Vektoren im Bogenmaß 2D
	public static float angleRad(Vektor2D vec1, Vektor2D vec2) {
		System.out.print("vec1: ");
		show(vec1);
		System.out.print("norm1: ");
		show(normalize(vec1));
		System.out.print("vec2: ");
		show(vec2);
		System.out.print("norm2: ");
		show(normalize(vec2));
		//return Math.acos(dotProduct(normalize(vec1), normalize(vec2)));
		return (float)Math.acos(kosinusFormel(vec1, vec2));
	}
	
	// Kosinusformel
	public static double kosinusFormel(Vektor2D vec1, Vektor2D vec2) {
		return dotProduct(vec1, vec2) / (vec1.length()*vec2.length());
	}
	
	public static double kosinusFormel(Vektor3D vec1, Vektor3D vec2) {
	   return dotProduct(vec1, vec2) / (vec1.length()*vec2.length());
   }  
	
	// Sinusformel
	public static double sinusFormel(Vektor2D vec1, Vektor2D vec2) {
		return determinante(vec1, vec2) / (vec1.length()*vec2.length());
	}	

	public static double sinusFormel(Vektor3D vec1, Vektor3D vec2) {
	   return determinante(vec1, vec2) / (vec1.length()*vec2.length());
	}  

	// Winkel zwischen zwei Vektoren im Bogenmaß 3D
	public static float angleRad(Vektor3D vec1, Vektor3D vec2) {
		return (float)Math.acos(dotProduct(vec1, vec2) / (vec1.length()*vec2.length()));
	}	

	// Winkel zwischen zwei Vektoren im Bogenmaß 2D, schnelle Version  
	public static float angleRadFast(Vektor2D vec1, Vektor2D vec2) {
		return (float)Math.acos(dotProduct(vec1, vec2) / Math.sqrt(vec1.lengthSquare()*vec2.lengthSquare()));
	}	
	
	// Winkel zwischen zwei Vektoren im Bogenmaß 3D, schnelle Version  
	public static float angleRadFast(Vektor3D vec1, Vektor3D vec2) {
		return (float)Math.acos(dotProduct(vec1, vec2) / Math.sqrt(vec1.lengthSquare()*vec2.lengthSquare()));
	}
	
	// Winkel zwischen zwei Vektoren in Grad 2D
	public static float angleDegree(Vektor2D vec1, Vektor2D vec2) {
		return radToDegree((float)Math.acos(dotProduct(vec1, vec2) / (vec1.length()*vec2.length())));
	}		
	
	// Winkel zwischen zwei Vektoren in Grad 3D
	public static float angleDegree(Vektor3D vec1, Vektor3D vec2) {
		return radToDegree((float)Math.acos(dotProduct(vec1, vec2) / (vec1.length()*vec2.length())));
	}		
	
	public static double determinante(Vektor2D v, Vektor2D w) {
		return v.getFirst()*w.getSecond() - v.getSecond()*w.getFirst();
	}
	
	// Hausaufgabe für MArco
	public static double determinante(Vektor3D v, Vektor3D w) {
	   return v.getX()*w.getY() - v.getY()*w.getX();
	}
	
	public static float orientationRad(Vektor2D vec1, Vektor2D vec2) {
		return (float)Math.asin(sinusFormel(vec1, vec2));
	}
	
	// Orientierung zwischen zwei Vektoren in Grad 2D
	public static float orientationDegree(Vektor2D vec1, Vektor2D vec2) {
		return radToDegree((float)Math.asin(determinante(vec1, vec2) / (vec1.length()*vec2.length())));
	}	
	
	// Orientierung zwischen zwei Vektoren in Grad 2D
	public static float orientationDegreeFast(Vektor2D vec1, Vektor2D vec2) {
		return radToDegree((float)Math.asin(determinante(vec1, vec2) / Math.sqrt(vec1.lengthSquare()*vec2.lengthSquare())));
	}
		
	// Bogenmaß in Grad umrechnen
	public static float radToDegree(float rad) {
		return (float)(180*rad/Math.PI);
	}
	
	// Grad in Bogenmaß umrechnen
	public static float DegreeToRad(float degree) {
		return (float)Math.PI*degree/180;
	}

	// Absolutvektor 2D
	public static Vektor2D abs(Vektor2D vec) {
		return new Vektor2D(Math.abs(vec.getFirst()), Math.abs(vec.getSecond()));
	}	
	
	// Absolutvektor 3D
	public static Vektor3D abs(Vektor3D vec) {
		return new Vektor3D(Math.abs(vec.getX()), Math.abs(vec.getY()), Math.abs(vec.getZ()));
	}	

	// Vektor in Zeilenschreibweise ausgeben 2D
	public static void show(Vektor2D vec) {
		System.out.println("("+vec.getFirst()+", "+vec.getSecond()+")");
	}	
	
	// Vektor in Zeilenschreibweise ausgeben 3D
	public static void show(Vektor3D vec) {
		System.out.println("("+vec.getX()+", "+vec.getY()+", "+vec.getZ()+")");
	}	
}
