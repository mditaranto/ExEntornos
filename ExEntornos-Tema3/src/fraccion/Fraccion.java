package fraccion;

// Clase que define una fracción
/**
 * Clase que define una fraccion
 * @author mditaranto
 *
 */
public class Fraccion {
	// Numerador
	/**
	 * Atributo del numerador
	 */
	private int num;

	// Denominador
	/**
	 * Atributo del denominador
	 */
	private int den;

	// Constructor por defecto
	/**
	 * Constructor que debe generar el valor neutro que es 0/1
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	/**
	 * Este constructor sirve para asignar valores
	 * @param num numerador
	 * @param den denominador
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	// Constructor copia
	/**
	 * Constructor que copia valores
	 * @param f parametro para la fraccion
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	// getters y setters
	/**
	 * Metodo para establecer valor a la variable
	 * @param num variable a la que hay que darle el valor
	 */
	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * Metodo para coger un valor
	 * @return devuelve el valor de la variable
	 */
	public int getNum() {
		return num;

	}
	/**
	 * Metodo para establecer valor a la variable
	 * @param den variable a la que hay que darle el valor
	 */
	public void setDen(int den) {
		this.den = den;
	}
	
	/**
	 * Metodo para coger un valor
	 * @return devuelve el valor de la variable
	 */
	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	/**
	 * Metodo que calcula el MCD
	 * @return devuelve el MCD
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	// método para simplificar fracciones
	/**
	 * Metodo que simplifica las fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	// Método toString
	/**
	 * Metodo que devuelve un mensaje
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	/**
	 * Metodo que suma las fracciones
	 * @param f la fraccion a sumar
	 * @return la suma de las fracciones
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones
	/**
	 * Metodo para restar fracciones
	 * @param f la fraccion a restar
	 * @return la resta de las fracciones
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	//Multiplicar fracciones
	/**
	 * Metodo para multiplicar fracciones
	 * @param f la fraccion a multiplicar
	 * @return resultado de la multiplicacion 
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones
	/**
	 * Metodo para dividar fracciones
	 * @param f la fraccion a dividir
	 * @return resuldado de la division
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
