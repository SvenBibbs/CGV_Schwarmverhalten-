package Algebra;

public class Vektor3D {
	public double x, y, z;

	public Vektor3D() {
		this(0, 0, 0);
	}

	public Vektor3D(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
	}

	public Vektor3D(Vektor3D vec) {
		this(vec.getX(), vec.getY(), vec.getZ());
	}

	// Vector aus zwei Punkten ermitteln
	public Vektor3D(double x, double y, double z, double x2, double y2, double z2) {
		this(x2 - x, y2 - y, z2 - z);
	}

	public Vektor3D(Vektor3D a, Vektor3D b) {
		this(b.getX() - a.getX(), b.getY() - a.getY(), b.getZ() - a.getZ());
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getZ() {
		return z;
	}

	public void setPosition(Vektor3D vec) {
		x = vec.x;
		y = vec.y;
		z = vec.z;
	}

	public boolean isNullvector() {
		return (x == 0 && y == 0 && z == 0);
	}

	// Addition
	public void add(Vektor3D vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
	}

	// Subtraktion
	public void sub(Vektor3D vec) {
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;
	}

	// Multiplikation mit Skalar
	public void mult(double s) {
		x *= s;
		y *= s;
		z *= s;
	}

	// Gleichheit
	public boolean isEqual(Vektor3D vec) {
		return (x == vec.x && y == vec.y && z == vec.z);
	}

	// Ungleichheit
	public boolean isNotEqual(Vektor3D vec) {
		return !isEqual(vec);
	}

	// L�nge des Vektors
	public double length() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	// Quadrat der L�nge des Vektors
	public double lengthSquare() {
		return x * x + y * y + z * z;
	}

	// Normalisierung des Vektors ohne Exception
	public void normalize() {
		if (this.isNullvector())
			setPosition(LineareAlgebra.mult(this,
					(1f / this.length() + 0.00001f)));
		else
			setPosition(LineareAlgebra.div(this, this.length()));
	}
}