package examen;

// Clase que define una fracción
public class Fraccion {
	// Numerador
	private int num;

	// Denominador
	private int den;

	// Constructor por defecto

	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;
		} else {
			this.den = den;
			// devuelvo la fracci�n simplificada
			simplificar();
		}
	}

	// Constructor copia
	public Fraccion(final Fraccion fraction) {
		num = fraction.num;
		den = fraction.den;
	}

	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	/**
	 * @deprecated Use {@link #maxComunDivisor()} instead
	 */
	private int mcd() {
		return maxComunDivisor();
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int maxComunDivisor() {
		int numabs = Math.abs(num); // valor absoluto del numerador
		int demabs = Math.abs(den); // valor absoluto del denominador
		
		int aux;
		while (demabs != 0) {
			aux = numabs % demabs;
			numabs = demabs;
			demabs = aux;
		}
		return numabs;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int aux = maxComunDivisor();
		num = num / aux;
		den = den / aux;
	}

	// Método toString

	public String toString() {
		return num + "/" + den;

	}

	// suma de fracciones
	public Fraccion sumar(Fraccion fraction) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraction.den;
		int cruce2 = den * fraction.num;
		aux.num = cruce1 + cruce2;
		aux.den = den * fraction.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	public Fraccion restar(Fraccion fraction) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraction.den;
		int cruce2 = den * fraction.num;
		aux.num = cruce1 - cruce2;
		aux.den = den * fraction.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	public Fraccion multiplicar(Fraccion fraction) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraction.num;
		aux.den = den * fraction.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	public Fraccion dividir(Fraccion fraction) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraction.den;
		aux.den = den * fraction.num;
		aux.simplificar();
		return aux;

	}

}
