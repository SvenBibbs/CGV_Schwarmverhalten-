package Algebra;

public class Vektor2D {
	public double First, Second;

	public Vektor2D() {
		this(0, 0);
	}

	public Vektor2D(double First, double Second) {
		setFirst(First);
		setSecond(Second);
	}

	public Vektor2D(Vektor2D vec) {
		this(vec.First, vec.Second);
	}

	public Vektor2D(double First, double Second, double x2, double y2) {
		this(x2 - First, y2 - Second);
	}

	public Vektor2D(Vektor2D a, Vektor2D b) {
		this(b.getFirst() - a.getFirst(), b.getSecond() - a.getSecond());
	}

	public void setFirst(double first) {
		this.First = first;
	}

	public void setSecond(double second) {
		this.Second = second;
	}

	public double getFirst() {
		return First;
	}

	public double getSecond() {
		return Second;
	}

	public void setPosition(Vektor2D vec) {
		setFirst(vec.getFirst());
		setSecond(vec.getSecond());
	}

	public boolean isNullvector() {
		return (First == 0 && Second == 0);
	}

	// Addition
	public void add(Vektor2D vec) {
		First += vec.First;
		Second += vec.Second;
	}

	// Subtraktion
	public void sub(Vektor2D vec) {
		First -= vec.First;
		Second -= vec.Second;
	}

	// Multiplikation mit Skalar
	public void mult(double s) {
		First *= s;
		Second *= s;
	}
	
	public void div(double s) {
	   if (s!=0) {
	      First /=s;
	      Second /=s;
	   }
	   else {
	      First =0;
	      Second =0;
	   }
	}
	
	// Gleichheit
	public boolean isEqual(Vektor2D vec) {
		return (First == vec.First && Second == vec.Second);
	}

	// Ungleichheit
	public boolean isNotEqual(Vektor2D vec) {
		return !isEqual(vec);
	}
 
	// Länge des Vektors
	public double length() {
		return Math.sqrt(First * First + Second * Second);
	}

	// Quadrat der Länge des Vektors
	public double lengthSquare() {
		return First * First + Second * Second;
	}

	// Normalisierung des Vektors ohne Exception
	public void normalize() {
		if (this.isNullvector())
			setPosition(LineareAlgebra.mult(this, (1.0 / this.length() + 0.00001)));
		else			
			setPosition(LineareAlgebra.div(this, this.length()));
	}
	
   public void truncate(double max) {
      if (length() > max) {
         normalize();
         mult(max);
      }
   }
   
}
